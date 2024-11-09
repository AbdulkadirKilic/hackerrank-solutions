// HackerRank Question: https://www.hackerrank.com/challenges/nimble-game-1/problem

package solutions.algorithms.Nimble_Game;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'nimbleGame' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY s as parameter.
   */

  public static String nimbleGame(List<Integer> s) {
    int xorSum = 0;

    // XOR the indices of squares with an odd number of coins
    for (int i = 0; i < s.size(); i++) {
      if (s.get(i) % 2 != 0) {
        xorSum ^= i;
      }
    }

    // If the XOR sum is zero, the second player wins; otherwise, the first player wins
    return xorSum == 0 ? "Second" : "First";
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
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> s =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.nimbleGame(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
