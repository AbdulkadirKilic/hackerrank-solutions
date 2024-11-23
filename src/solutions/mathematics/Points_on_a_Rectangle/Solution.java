// HackerRank Question: https://www.hackerrank.com/challenges/points-on-rectangle/problem

package solutions.mathematics.Points_on_a_Rectangle;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts 2D_INTEGER_ARRAY coordinates as parameter.
   */

  public static String solve(List<List<Integer>> coordinates) {
    int n = coordinates.size();

    // Find the min and max x and y coordinates
    int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

    for (List<Integer> point : coordinates) {
      int x = point.get(0);
      int y = point.get(1);
      minX = Math.min(minX, x);
      maxX = Math.max(maxX, x);
      minY = Math.min(minY, y);
      maxY = Math.max(maxY, y);
    }

    // Check if all points lie on the edges of the rectangle
    for (List<Integer> point : coordinates) {
      int x = point.get(0);
      int y = point.get(1);

      // A point is on the edge if it satisfies one of the conditions:
      // 1. x is either minX or maxX (vertical edges) and y is within [minY, maxY]
      // 2. y is either minY or maxY (horizontal edges) and x is within [minX, maxX]
      if (!((x == minX || x == maxX) && (y >= minY && y <= maxY))
          && !((y == minY || y == maxY) && (x >= minX && x <= maxX))) {
        return "NO";
      }
    }

    return "YES";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> coordinates = new ArrayList<>();

                IntStream.range(0, n)
                    .forEach(
                        i -> {
                          try {
                            coordinates.add(
                                Stream.of(
                                        bufferedReader
                                            .readLine()
                                            .replaceAll("\\s+$", "")
                                            .split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList()));
                          } catch (IOException ex) {
                            throw new RuntimeException(ex);
                          }
                        });

                String result = Result.solve(coordinates);

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
