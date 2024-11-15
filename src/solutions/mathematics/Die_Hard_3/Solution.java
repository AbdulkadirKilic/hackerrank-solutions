// HackerRank Question: https://www.hackerrank.com/challenges/die-hard-3/problem

package solutions.mathematics.Die_Hard_3;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER a
   *  2. INTEGER b
   *  3. INTEGER c
   */

  public static String solve(int a, int b, int c) {
    // If c is greater than both capacities, it is impossible
    if (c > Math.max(a, b)) {
      return "NO";
    }

    // If c is a multiple of gcd(a, b), it is possible
    if (c % gcd(a, b) == 0) {
      return "YES";
    }

    return "NO";
  }

  // Helper method to calculate gcd
  private static int gcd(int x, int y) {
    while (y != 0) {
      int temp = y;
      y = x % y;
      x = temp;
    }
    return x;
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

                int c = Integer.parseInt(firstMultipleInput[2]);

                String result = Result.solve(a, b, c);

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
