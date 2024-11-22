// HackerRank Question: https://www.hackerrank.com/challenges/k-candy-store/problem

package solutions.mathematics.K_Candy_Store;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER k
   */

  private static final int MOD = 1_000_000_000; // Modulo for the last 9 digits

  public static int solve(int n, int k) {
    int size = n + k - 1; // Total slots for combinations
    int[][] dp = new int[size + 1][k + 1]; // Pascal's Triangle DP table

    // Base cases
    for (int i = 0; i <= size; i++) {
      dp[i][0] = 1; // C(i, 0) = 1
    }

    // Compute Pascal's Triangle values mod MOD
    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= Math.min(i, k); j++) {
        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
      }
    }

    return dp[size][k]; // C(N + K - 1, K) % MOD
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

                int k = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.solve(n, k);
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
