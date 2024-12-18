// HackerRank Question: https://www.hackerrank.com/challenges/tower-breakers-1/problem

package solutions.algorithms.Tower_Breakers;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'towerBreakers' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER m
   */

  public static int towerBreakers(int n, int m) {
    // If the tower height is 1, Player 2 wins by default
    if (m == 1) {
      return 2;
    }
    // If the number of towers is even, Player 2 wins; otherwise, Player 1 wins
    return (n % 2 == 0) ? 2 : 1;
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
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

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
