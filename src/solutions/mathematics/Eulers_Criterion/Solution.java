// HackerRank Question: https://www.hackerrank.com/challenges/eulers-criterion/problem

package solutions.mathematics.Eulers_Criterion;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER a
   *  2. INTEGER m
   */

  public static String solve(int a, int m) {
    if (a == 0) {
      return "YES"; // 0 is always a quadratic residue
    }

    // Compute A^((M-1)/2) % M using modular exponentiation
    int exponent = (m - 1) / 2;
    int result = modularExponentiation(a, exponent, m);

    // If result is 1, it's a quadratic residue
    return result == 1 ? "YES" : "NO";
  }

  // Function for modular exponentiation: (base^exp) % mod
  private static int modularExponentiation(int base, int exp, int mod) {
    long result = 1;
    long baseMod = base % mod;

    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = (result * baseMod) % mod;
      }
      baseMod = (baseMod * baseMod) % mod;
      exp >>= 1; // Divide exp by 2
    }
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
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                String result = Result.solve(a, m);

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
