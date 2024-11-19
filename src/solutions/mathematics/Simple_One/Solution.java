// HackerRank Question: https://www.hackerrank.com/challenges/simple-one/problem

package solutions.mathematics.Simple_One;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER p
   *  2. INTEGER q
   *  3. INTEGER n
   */

  private static final int MOD = 1_000_000_007;

  public static int solve(int p, int q, int n) {
    if (n == 1) {
      return (int) ((long) p * modInverse(q, MOD) % MOD);
    }

    // Transition matrix
    long[][] matrix = {
      {q, p},
      {-p, q}
    };

    // Base vector
    long[] base = {p, q};

    // Perform matrix exponentiation
    long[][] resultMatrix = matrixExponentiation(matrix, n - 1);

    // Multiply result matrix with base vector
    long Pn = (resultMatrix[0][0] * base[0] + resultMatrix[0][1] * base[1]) % MOD;
    long Qn = (resultMatrix[1][0] * base[0] + resultMatrix[1][1] * base[1]) % MOD;

    // Handle negatives
    if (Pn < 0) Pn += MOD;
    if (Qn < 0) Qn += MOD;

    // Calculate result using modular inverse of Qn
    return (int) ((Pn * modInverse(Qn, MOD)) % MOD);
  }

  // Matrix exponentiation
  private static long[][] matrixExponentiation(long[][] matrix, int exp) {
    int size = matrix.length;
    long[][] result = new long[size][size];

    // Initialize result as identity matrix
    for (int i = 0; i < size; i++) {
      result[i][i] = 1;
    }

    long[][] base = matrix;

    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = multiplyMatrices(result, base);
      }
      base = multiplyMatrices(base, base);
      exp >>= 1;
    }

    return result;
  }

  // Matrix multiplication
  private static long[][] multiplyMatrices(long[][] a, long[][] b) {
    int size = a.length;
    long[][] result = new long[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        for (int k = 0; k < size; k++) {
          result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD;
        }
      }
    }

    return result;
  }

  // Modular inverse using modular exponentiation
  private static long modInverse(long a, int mod) {
    return modExp(a, mod - 2, mod);
  }

  // Modular exponentiation
  private static long modExp(long base, long exp, int mod) {
    long result = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = (result * base) % mod;
      }
      base = (base * base) % mod;
      exp >>= 1;
    }
    return result;
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

                int p = Integer.parseInt(firstMultipleInput[0]);

                int q = Integer.parseInt(firstMultipleInput[1]);

                int n = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.solve(p, q, n);

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
