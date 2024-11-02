// HackerRank Question: https://www.hackerrank.com/challenges/extra-long-factorials/problem

package solutions.algorithms.Extra_Long_Factorials;

import java.io.*;
import java.math.*;

class Result {

  /*
   * Complete the 'extraLongFactorials' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  public static void extraLongFactorials(int n) {
    BigInteger factorial = BigInteger.ONE; // Initialize BigInteger with 1

    // Calculate factorial using BigInteger
    for (int i = 1; i <= n; i++) {
      factorial = factorial.multiply(BigInteger.valueOf(i));
    }

    System.out.println(factorial);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    Result.extraLongFactorials(n);

    bufferedReader.close();
  }
}
