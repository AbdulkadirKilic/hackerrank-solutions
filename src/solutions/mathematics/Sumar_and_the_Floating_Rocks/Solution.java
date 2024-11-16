// HackerRank Question:
// https://www.hackerrank.com/challenges/harry-potter-and-the-floating-rocks/problem

package solutions.mathematics.Sumar_and_the_Floating_Rocks;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER x1
   *  2. INTEGER y1
   *  3. INTEGER x2
   *  4. INTEGER y2
   */

  public static int solve(int x1, int y1, int x2, int y2) {
    // Calculate the differences in x and y
    int dx = Math.abs(x2 - x1);
    int dy = Math.abs(y2 - y1);

    // Find the GCD of the differences
    return gcd(dx, dy) - 1; // Subtract 1 to exclude P1 and P2
  }

  // Helper function to calculate GCD using the Euclidean algorithm
  private static int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
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

                int x1 = Integer.parseInt(firstMultipleInput[0]);

                int y1 = Integer.parseInt(firstMultipleInput[1]);

                int x2 = Integer.parseInt(firstMultipleInput[2]);

                int y2 = Integer.parseInt(firstMultipleInput[3]);

                int result = Result.solve(x1, y1, x2, y2);

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
