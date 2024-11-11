// HackerRank Question: https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem

package solutions.algorithms.Connected_Cells_in_a_Grid;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'connectedCell' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
   */

  public static int connectedCell(List<List<Integer>> matrix) {
    int n = matrix.size();
    int m = matrix.get(0).size();
    boolean[][] visited = new boolean[n][m];
    int maxRegionSize = 0;

    // Traverse each cell in the matrix
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // Start DFS if the cell is part of a region and not visited
        if (matrix.get(i).get(j) == 1 && !visited[i][j]) {
          int regionSize = dfs(matrix, visited, i, j, n, m);
          maxRegionSize = Math.max(maxRegionSize, regionSize);
        }
      }
    }

    return maxRegionSize;
  }

  // DFS function to calculate the size of a region
  private static int dfs(
      List<List<Integer>> matrix, boolean[][] visited, int i, int j, int n, int m) {
    // If out of bounds or already visited or cell is empty, return 0
    if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || matrix.get(i).get(j) == 0) {
      return 0;
    }

    visited[i][j] = true; // Mark the cell as visited
    int size = 1; // Count this cell

    // Define 8 possible directions (horizontal, vertical, and diagonal)
    int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

    // Explore all 8 directions
    for (int d = 0; d < 8; d++) {
      size += dfs(matrix, visited, i + rowDir[d], j + colDir[d], n, m);
    }

    return size;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int m = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> matrix = new ArrayList<>();

    IntStream.range(0, n)
        .forEach(
            i -> {
              try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    int result = Result.connectedCell(matrix);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
