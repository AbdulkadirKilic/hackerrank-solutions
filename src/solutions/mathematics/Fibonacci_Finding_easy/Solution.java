// HackerRank Question: https://www.hackerrank.com/challenges/fibonacci-finding-easy/problem

package solutions.mathematics.Fibonacci_Finding_easy;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER a
   *  2. INTEGER b
   *  3. INTEGER n
   */

  private static final int MOD = 1000000007;

  public static int solve(int a, int b, int n) {
    if (n == 0) return a % MOD; // Base case: F_0 = A
    if (n == 1) return b % MOD; // Base case: F_1 = B

    // Define the transformation matrix
    int[][] matrix = {
      {1, 1},
      {1, 0}
    };

    // Compute M^(n-1)
    int[][] resultMatrix = matrixExponentiation(matrix, n - 1);

    // Compute F_n = resultMatrix[0][0] * B + resultMatrix[0][1] * A
    long fn = (resultMatrix[0][0] * 1L * b % MOD + resultMatrix[0][1] * 1L * a % MOD) % MOD;
    return (int) fn;
  }

  // Function to compute matrix exponentiation
  private static int[][] matrixExponentiation(int[][] matrix, int exp) {
    int size = matrix.length;
    int[][] result = new int[size][size];

    // Initialize result as the identity matrix
    for (int i = 0; i < size; i++) {
      result[i][i] = 1;
    }

    // Perform matrix exponentiation
    int[][] base = matrix;
    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = multiplyMatrices(result, base);
      }
      base = multiplyMatrices(base, base);
      exp >>= 1; // Divide exp by 2
    }
    return result;
  }

  // Function to multiply two matrices modulo MOD
  private static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
    int size = mat1.length;
    int[][] result = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        for (int k = 0; k < size; k++) {
          result[i][j] = (int) ((result[i][j] + mat1[i][k] * 1L * mat2[k][j]) % MOD);
        }
      }
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

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int n = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.solve(a, b, n);

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
