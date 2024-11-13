// HackerRank Question: https://www.hackerrank.com/challenges/summing-the-n-series/problem

package solutions.mathematics.Summing_the_N_series;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'summingSeries' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts LONG_INTEGER n as parameter.
   */

  private static final int MOD = 1000000007;

  public static int summingSeries(long n) {
    // Directly calculate (n^2) % MOD
    long result = (n % MOD) * (n % MOD) % MOD;
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
                long n = Long.parseLong(bufferedReader.readLine().trim());

                int result = Result.summingSeries(n);

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
