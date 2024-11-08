// HackerRank Question: https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem

package solutions.algorithms.Sherlock_and_The_Beast;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'decentNumber' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  public static void decentNumber(int n) {
    int fives = n;

    // Reduce the number of fives by 5 until divisible by 3
    while (fives % 3 != 0) {
      fives -= 5; // Try replacing some fives with threes
    }

    // Check if a valid number of fives and threes can be formed
    if (fives < 0) {
      System.out.println("-1");
    } else {
      // Create a StringBuilder to build the result
      StringBuilder result = new StringBuilder();

      // Append fives
      for (int i = 0; i < fives; i++) {
        result.append("5");
      }

      // Append threes
      for (int i = 0; i < n - fives; i++) {
        result.append("3");
      }

      System.out.println(result.toString());
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                Result.decentNumber(n);
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
  }
}
