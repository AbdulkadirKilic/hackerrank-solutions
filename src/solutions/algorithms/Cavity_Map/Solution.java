// HackerRank Question: https://www.hackerrank.com/challenges/cavity-map/problem

package solutions.algorithms.Cavity_Map;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'cavityMap' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY grid as parameter.
   */

  public static List<String> cavityMap(List<String> grid) {
    int n = grid.size();
    char[][] resultGrid = new char[n][n];

    // Fill resultGrid with the original grid values
    for (int i = 0; i < n; i++) {
      resultGrid[i] = grid.get(i).toCharArray();
    }

    // Check each cell that is not on the border
    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        int cellDepth = resultGrid[i][j];
        // Check if current cell is deeper than its adjacent cells
        if (cellDepth > resultGrid[i - 1][j]
            && // top
            cellDepth > resultGrid[i + 1][j]
            && // bottom
            cellDepth > resultGrid[i][j - 1]
            && // left
            cellDepth > resultGrid[i][j + 1]) { // right
          resultGrid[i][j] = 'X'; // Mark as cavity
        }
      }
    }

    // Convert resultGrid back to list of strings
    List<String> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      result.add(new String(resultGrid[i]));
    }

    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> grid =
        IntStream.range(0, n)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine();
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .collect(toList());

    List<String> result = Result.cavityMap(grid);

    bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
