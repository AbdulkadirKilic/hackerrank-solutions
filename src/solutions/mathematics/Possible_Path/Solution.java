// HackerRank Question: https://www.hackerrank.com/challenges/possible-path/problem

package solutions.mathematics.Possible_Path;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. LONG_INTEGER a
   *  2. LONG_INTEGER b
   *  3. LONG_INTEGER x
   *  4. LONG_INTEGER y
   */

  public static String solve(long a, long b, long x, long y) {
    // Compute GCD of (a, b) and (x, y)
    long g1 = gcd(Math.abs(a), Math.abs(b));
    long g2 = gcd(Math.abs(x), Math.abs(y));

    // If GCDs are equal, the path is possible
    return (g1 == g2) ? "YES" : "NO";
  }

  // Helper function to calculate GCD using Euclid's algorithm
  private static long gcd(long a, long b) {
    while (b != 0) {
      long temp = b;
      b = a % b;
      a = temp;
    }
    return a;
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

                long a = Long.parseLong(firstMultipleInput[0]);

                long b = Long.parseLong(firstMultipleInput[1]);

                long x = Long.parseLong(firstMultipleInput[2]);

                long y = Long.parseLong(firstMultipleInput[3]);

                String result = Result.solve(a, b, x, y);

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
