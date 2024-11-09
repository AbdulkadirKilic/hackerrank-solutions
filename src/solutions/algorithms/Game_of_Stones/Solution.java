// HackerRank Question: https://www.hackerrank.com/challenges/game-of-stones-1/problem

package solutions.algorithms.Game_of_Stones;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'gameOfStones' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER n as parameter.
   */

  public static String gameOfStones(int n) {
    // Check the modulo condition to determine the winner
    if (n % 7 == 0 || n % 7 == 1) {
      return "Second"; // P2 wins
    } else {
      return "First"; // P1 wins
    }
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

                String result = Result.gameOfStones(n);

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
