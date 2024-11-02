// HackerRank Question: https://www.hackerrank.com/challenges/3d-surface-area/problem

package solutions.algorithms.three_D_Surface_Area;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'surfaceArea' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY A as parameter.
   */

  public static int surfaceArea(List<List<Integer>> A) {
    int H = A.size();
    int W = A.get(0).size();

    int surfaceArea = 0;

    // Loop over each cell in the board
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        int height = A.get(i).get(j);

        // Top and bottom faces for each stack of cubes
        surfaceArea += 2;

        // Check the four sides and calculate the surface area based on neighbors
        // Left side
        if (j == 0) {
          surfaceArea += height;
        } else {
          surfaceArea += Math.max(height - A.get(i).get(j - 1), 0);
        }

        // Right side
        if (j == W - 1) {
          surfaceArea += height;
        } else {
          surfaceArea += Math.max(height - A.get(i).get(j + 1), 0);
        }

        // Front side
        if (i == 0) {
          surfaceArea += height;
        } else {
          surfaceArea += Math.max(height - A.get(i - 1).get(j), 0);
        }

        // Back side
        if (i == H - 1) {
          surfaceArea += height;
        } else {
          surfaceArea += Math.max(height - A.get(i + 1).get(j), 0);
        }
      }
    }

    return surfaceArea;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int H = Integer.parseInt(firstMultipleInput[0]);

    int W = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> A = new ArrayList<>();

    IntStream.range(0, H)
        .forEach(
            i -> {
              try {
                A.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    int result = Result.surfaceArea(A);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
