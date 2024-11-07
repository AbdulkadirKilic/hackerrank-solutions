// HackerRank Question: https://www.hackerrank.com/challenges/common-child/problem

package solutions.algorithms.Common_Child;

import java.io.*;

class Result {

  /*
   * Complete the 'commonChild' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. STRING s1
   *  2. STRING s2
   */

  public static int commonChild(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    // Create a 2D DP array to store the length of longest common subsequence
    int[][] dp = new int[n + 1][m + 1];

    // Fill the DP table
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    // The length of the longest common subsequence is in dp[n][m]
    return dp[n][m];
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s1 = bufferedReader.readLine();

    String s2 = bufferedReader.readLine();

    int result = Result.commonChild(s1, s2);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
