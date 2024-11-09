// HackerRank Question: https://www.hackerrank.com/challenges/sum-vs-xor/problem

package solutions.algorithms.Sum_vs_XOR;

import java.io.*;

class Result {

  /*
   * Complete the 'sumXor' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts LONG_INTEGER n as parameter.
   */

  public static long sumXor(long n) {
    // Count the number of zero bits in the binary representation of n
    int zeroBits = 0;

    while (n > 0) {
      if ((n & 1) == 0) {
        zeroBits++;
      }
      n >>= 1;
    }

    // Return 2 to the power of zeroBits
    return 1L << zeroBits; // 2^zeroBits
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    long n = Long.parseLong(bufferedReader.readLine().trim());

    long result = Result.sumXor(n);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
