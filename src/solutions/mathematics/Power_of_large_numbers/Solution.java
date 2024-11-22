// HackerRank Question: https://www.hackerrank.com/challenges/power-of-large-numbers/problem

package solutions.mathematics.Power_of_large_numbers;

import java.io.*;
import java.math.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. STRING a
   *  2. STRING b
   */
  private static final int MOD = 1_000_000_007;
  private static final int MOD_EXPONENT = 1_000_000_006; // MOD - 1

  public static int solve(String a, String b) {
    // Step 1: Reduce A modulo MOD
    BigInteger base = new BigInteger(a).mod(BigInteger.valueOf(MOD));

    // Step 2: Reduce B modulo (MOD - 1)
    BigInteger exponent = new BigInteger(b).mod(BigInteger.valueOf(MOD_EXPONENT));

    // Step 3: Compute modular exponentiation
    return modularExponentiation(base, exponent, BigInteger.valueOf(MOD));
  }

  private static int modularExponentiation(BigInteger base, BigInteger exponent, BigInteger mod) {
    BigInteger result = BigInteger.ONE;
    BigInteger two = BigInteger.valueOf(2); // Create a BigInteger for 2

    while (exponent.compareTo(BigInteger.ZERO) > 0) {
      // If exponent is odd, multiply base with result
      if (exponent.mod(two).equals(BigInteger.ONE)) {
        result = result.multiply(base).mod(mod);
      }
      // Square the base and reduce the exponent by half
      base = base.multiply(base).mod(mod);
      exponent = exponent.divide(two);
    }

    return result.intValue();
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

                String a = firstMultipleInput[0];

                String b = firstMultipleInput[1];

                int result = Result.solve(a, b);

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
