// HackerRank Question: https://www.hackerrank.com/challenges/difference-and-product/problem

package solutions.mathematics.Difference_and_Product;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER d
   *  2. INTEGER p
   */

  public static int solve(int d, int p) {
    // If D is negative, absolute difference can't exist
    if (d < 0) return 0;

    int count = 0;

    // Case 1: A - B = D
    count += countSolutions(d, p);

    // Case 2: A - B = -D
    if (d != 0) { // To avoid double counting when D = 0
      count += countSolutions(-d, p);
    }

    return count;
  }

  public static int countSolutions(int d, int p) {
    // Calculate discriminant
    long discriminant = (long) d * d + 4L * p;
    if (discriminant < 0) return 0; // No real solutions

    long sqrt = (long) Math.sqrt(discriminant);
    if (sqrt * sqrt != discriminant) return 0; // Discriminant is not a perfect square

    // Calculate possible values of B
    long b1 = (-d + sqrt) / 2;
    long b2 = (-d - sqrt) / 2;

    int count = 0;

    // Check if B1 and B2 are valid solutions
    if (b1 * 2 == -d + sqrt) { // Ensure B1 is an integer
      count++;
    }
    if (b2 * 2 == -d - sqrt && b1 != b2) { // Ensure B2 is an integer and distinct
      count++;
    }

    return count;
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

                int d = Integer.parseInt(firstMultipleInput[0]);

                int p = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.solve(d, p);

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
