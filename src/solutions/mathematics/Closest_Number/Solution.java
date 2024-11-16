// HackerRank Question: https://www.hackerrank.com/challenges/closest-number/problem

package solutions.mathematics.Closest_Number;

import java.io.*;
import java.math.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'closestNumber' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER a
   *  2. INTEGER b
   *  3. INTEGER x
   */

  public static int closestNumber(int a, int b, int x) {
    // Handle special case where b is 0
    if (b == 0) {
      return 0; // Any number to the power of 0 is 1, and the closest multiple of x is 0.
    }

    // Calculate a^b using BigInteger
    BigInteger base = BigInteger.valueOf(a);
    BigInteger exponent = BigInteger.valueOf(Math.abs(b));
    BigInteger power = base.pow(exponent.intValue());

    // If b is negative, compute 1 / a^b
    if (b < 0) {
      power = BigInteger.ONE.divide(power);
    }

    // Convert power to a long for further calculations
    long target = power.longValue();

    // Find the closest multiples
    long lowerMultiple = (target / x) * x;
    long upperMultiple = lowerMultiple + x;

    // Determine which is closer to target
    if (Math.abs(target - lowerMultiple) <= Math.abs(target - upperMultiple)) {
      return (int) lowerMultiple;
    } else {
      return (int) upperMultiple;
    }
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

                int x = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.closestNumber(a, b, x);

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
