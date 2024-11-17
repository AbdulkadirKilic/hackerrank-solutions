// HackerRank Question: https://www.hackerrank.com/challenges/most-distant/problem

package solutions.mathematics.Most_Distant;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a DOUBLE.
   * The function accepts 2D_INTEGER_ARRAY coordinates as parameter.
   */

  public static double solve(List<List<Integer>> coordinates) {
    // Initialize max and min values for x and y
    int xMax = Integer.MIN_VALUE, xMin = Integer.MAX_VALUE;
    int yMax = Integer.MIN_VALUE, yMin = Integer.MAX_VALUE;

    // Loop through all points to find extrema
    for (List<Integer> point : coordinates) {
      int x = point.get(0), y = point.get(1);

      if (x == 0) { // y-coordinate matters
        yMax = Math.max(yMax, y);
        yMin = Math.min(yMin, y);
      } else { // x-coordinate matters
        xMax = Math.max(xMax, x);
        xMin = Math.min(xMin, x);
      }
    }

    // Compute possible distances
    double distX = Math.abs(xMax - xMin); // Max distance along x-axis
    double distY = Math.abs(yMax - yMin); // Max distance along y-axis
    double distDiag1 = Math.sqrt(Math.pow(xMax, 2) + Math.pow(yMax, 2)); // Diagonal top-right
    double distDiag2 = Math.sqrt(Math.pow(xMin, 2) + Math.pow(yMin, 2)); // Diagonal bottom-left

    // Return the maximum distance
    return Math.max(Math.max(distX, distY), Math.max(distDiag1, distDiag2));
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> coordinates = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] point = bufferedReader.readLine().split(" ");
      coordinates.add(Arrays.asList(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
    }

    double result = Result.solve(coordinates);

    // Print the result with 6 decimal precision
    bufferedWriter.write(String.format("%.6f", result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
