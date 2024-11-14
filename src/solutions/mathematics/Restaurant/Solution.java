// HackerRank Question: https://www.hackerrank.com/challenges/restaurant/problem

package solutions.mathematics.Restaurant;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'restaurant' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER l
   *  2. INTEGER b
   */

  public static int restaurant(int l, int b) {
    // Find the greatest common divisor (GCD) of l and b
    int gcd = gcd(l, b);

    // Calculate the number of squares of side length gcd that fit into the rectangle
    return (l * b) / (gcd * gcd);
  }

  // Helper function to calculate the GCD using Euclidean algorithm
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

                int l = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.restaurant(l, b);

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
