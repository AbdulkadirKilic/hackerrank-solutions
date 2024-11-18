// HackerRank Question: https://www.hackerrank.com/challenges/picking-cards/problem

package solutions.mathematics.Picking_Cards;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY c as parameter.
   */

  private static final int MOD = 1_000_000_007;

  public static int solve(List<Integer> c) {
    int n = c.size();
    Collections.sort(c); // Sort the cards to handle them in increasing order

    long result = 1; // Start with a result of 1
    int picked = 0; // Cards picked so far

    for (int ci : c) {
      if (ci > picked) {
        // If the card's value is greater than the number of picked cards, it's invalid
        return 0;
      }
      result = (result * (picked - ci + 1)) % MOD; // Calculate permutations
      picked++; // Increment picked cards count
    }

    return (int) result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                int cCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> c =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                int result = Result.solve(c);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
