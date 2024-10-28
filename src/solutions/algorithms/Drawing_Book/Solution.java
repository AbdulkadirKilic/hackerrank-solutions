// HackerRank Question: https://www.hackerrank.com/challenges/drawing-book/problem

package solutions.algorithms.Drawing_Book;

import java.io.*;

class Result {

  /*
   * Complete the 'pageCount' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER p
   */

  public static int pageCount(int n, int p) {
    // Calculate turns needed starting from the front
    int frontTurns = p / 2;

    // Calculate turns needed starting from the back
    int backTurns = (n / 2) - (p / 2);

    // Return the minimum turns needed
    return Math.min(frontTurns, backTurns);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int p = Integer.parseInt(bufferedReader.readLine().trim());

    int result = Result.pageCount(n, p);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}