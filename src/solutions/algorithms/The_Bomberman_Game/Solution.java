// HackerRank Question: https://www.hackerrank.com/challenges/bomber-man/problem

package solutions.algorithms.The_Bomberman_Game;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'bomberMan' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. STRING_ARRAY grid
   */
  private static final char BOMB = 'O';
  private static final char EMPTY = '.';

  public static List<String> bomberMan(int n, List<String> grid) {
    if (n == 1) {
      return grid;
    }

    int rows = grid.size();
    int cols = grid.get(0).length();

    // Full grid with bombs (used for even times, e.g., n = 2, 4, 6...)
    List<String> fullBombGrid = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
      char[] row = new char[cols];
      Arrays.fill(row, BOMB);
      fullBombGrid.add(new String(row));
    }

    if (n % 2 == 0) {
      return fullBombGrid;
    }

    // Initial grid transformation
    char[][] initialExplosion = explodeGrid(grid, rows, cols);

    if ((n - 3) % 4 == 0) {
      return convertToList(initialExplosion);
    }

    // Further grid transformation
    char[][] secondExplosion = explodeGrid(convertToList(initialExplosion), rows, cols);
    return convertToList(secondExplosion);
  }

  private static char[][] explodeGrid(List<String> grid, int rows, int cols) {
    char[][] newGrid = new char[rows][cols];

    // Initialize new grid with bombs
    for (int i = 0; i < rows; i++) {
      Arrays.fill(newGrid[i], BOMB);
    }

    // Apply explosions
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid.get(i).charAt(j) == BOMB) {
          newGrid[i][j] = EMPTY;
          if (i > 0) newGrid[i - 1][j] = EMPTY;
          if (i < rows - 1) newGrid[i + 1][j] = EMPTY;
          if (j > 0) newGrid[i][j - 1] = EMPTY;
          if (j < cols - 1) newGrid[i][j + 1] = EMPTY;
        }
      }
    }

    return newGrid;
  }

  private static List<String> convertToList(char[][] grid) {
    List<String> result = new ArrayList<>();
    for (char[] row : grid) {
      result.add(new String(row));
    }
    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int r = Integer.parseInt(firstMultipleInput[0]);

    int c = Integer.parseInt(firstMultipleInput[1]);

    int n = Integer.parseInt(firstMultipleInput[2]);

    List<String> grid =
        IntStream.range(0, r)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine();
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .collect(toList());

    List<String> result = Result.bomberMan(n, grid);

    bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
