// HackerRank Question: https://www.hackerrank.com/challenges/misere-nim-1/problem

package solutions.algorithms.Misère_Nim;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'misereNim' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY s as parameter.
   */

  public static String misereNim(List<Integer> s) {
    int xorSum = 0;
    boolean allOnes = true;

    for (int stones : s) {
      xorSum ^= stones;
      if (stones > 1) {
        allOnes = false;
      }
    }

    // If all piles contain only one stone
    if (allOnes) {
      return (s.size() % 2 == 0) ? "First" : "Second";
    }

    // If xorSum is not zero, the first player can force a win
    return (xorSum != 0) ? "First" : "Second";
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

                String result = Result.misereNim(s);

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
