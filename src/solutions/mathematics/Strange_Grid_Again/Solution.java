// HackerRank Question: https://www.hackerrank.com/challenges/strange-grid/problem

package solutions.mathematics.Strange_Grid_Again;

import java.io.*;

class Result {

  /*
   * Complete the 'strangeGrid' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER r
   *  2. INTEGER c
   */

  public static long strangeGrid(long r, long c) {
    // Base value calculation for the row
    long base = ((r - 1) / 2) * 10;

    // Determine if the row is even or odd indexed
    if ((r - 1) % 2 == 0) {
      return base + (c - 1) * 2;
    } else {
      return base + (c - 1) * 2 + 1;
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int r = Integer.parseInt(firstMultipleInput[0]);

    int c = Integer.parseInt(firstMultipleInput[1]);

    long result = Result.strangeGrid(r, c);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
