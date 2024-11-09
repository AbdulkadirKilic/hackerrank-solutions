// HackerRank Question: https://www.hackerrank.com/challenges/a-chessboard-game-1/problem

package solutions.algorithms.A_Chessboard_Game;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'chessboardGame' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER x
   *  2. INTEGER y
   */

  public static String chessboardGame(int x, int y) {
    // Check if both x and y satisfy the losing condition modulo 4
    if ((x % 4 == 1 || x % 4 == 2) && (y % 4 == 1 || y % 4 == 2)) {
      return "Second";
    } else {
      return "First";
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
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int x = Integer.parseInt(firstMultipleInput[0]);

                int y = Integer.parseInt(firstMultipleInput[1]);

                String result = Result.chessboardGame(x, y);

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
