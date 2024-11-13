// HackerRank Question: https://www.hackerrank.com/challenges/game-with-cells/problem

package solutions.mathematics.Army_Game;

import java.io.*;

class Result {

  /*
   * Complete the 'gameWithCells' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER m
   */

  public static int gameWithCells(int n, int m) {

    return ((n + 1) / 2) * ((m + 1) / 2);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    int result = Result.gameWithCells(n, m);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
