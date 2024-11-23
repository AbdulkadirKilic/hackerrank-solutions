// HackerRank Question: https://www.hackerrank.com/challenges/prime-sum/problem

package solutions.mathematics.Prime_Sum;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. LONG_INTEGER n
   *  2. LONG_INTEGER k
   */

  public static String solve(long n, long k) {
    // Case 1: If K == 1
    if (k == 1) {
      return isPrime(n) ? "Yes" : "No";
    }

    // Case 2: If K > 1, check if K * 2 > N
    if (k * 2 > n) {
      return "No";
    }

    // Case 3: For K >= 2, check if there are enough prime numbers to form N
    if (k == 2) {
      return (n % 2 == 0 || isPrime(n - 2)) ? "Yes" : "No";
    }

    // If K >= 3, it's always possible if K * 2 <= N
    return "Yes";
  }

  // Helper function to check if a number is prime
  private static boolean isPrime(long n) {
    if (n < 2) {
      return false;
    }
    if (n == 2 || n == 3) {
      return true;
    }
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }
    for (long i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    }
    return true;
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

                long n = Long.parseLong(firstMultipleInput[0]);

                long k = Long.parseLong(firstMultipleInput[1]);

                String result = Result.solve(n, k);

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
