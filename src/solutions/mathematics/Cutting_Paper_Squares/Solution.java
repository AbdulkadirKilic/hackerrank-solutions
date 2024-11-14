// HackerRank Question: https://www.hackerrank.com/challenges/p1-paper-cutting/problem

package solutions.mathematics.Cutting_Paper_Squares;

import java.io.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER m
   */

  public static long solve(int n, int m) {
    // Calculate the minimum number of cuts needed
    return (long) n * m - 1;
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

    long result = Result.solve(n, m);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
