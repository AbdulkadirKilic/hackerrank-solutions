// HackerRank Question: https://www.hackerrank.com/challenges/two-pluses/problem

package solutions.algorithms.Emas_Supercomputer;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'twoPluses' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING_ARRAY grid as parameter.
   */

  public static int twoPluses(List<String> grid) {
    int n = grid.size();
    int m = grid.get(0).length();

    int[][] maxLengths = new int[n][m];

    // Calculate maximum lengths of `+` arms for each cell
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid.get(i).charAt(j) == 'G') {
          int length = 0;
          while (isValidPlus(grid, i, j, length)) {
            maxLengths[i][j] = length;
            length++;
          }
        }
      }
    }

    List<Integer> areas = new ArrayList<>();
    List<List<int[]>> pluses = new ArrayList<>();

    // Collect all possible pluses with their areas
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int maxPlusLength = maxLengths[i][j];
        for (int l = 0; l <= maxPlusLength; l++) {
          int area = 4 * l + 1;
          areas.add(area);
          pluses.add(generatePlus(i, j, l));
        }
      }
    }

    int maxProduct = 0;

    // Check all combinations of two pluses
    for (int i = 0; i < areas.size(); i++) {
      for (int j = i + 1; j < areas.size(); j++) {
        if (!overlaps(pluses.get(i), pluses.get(j))) {
          int product = areas.get(i) * areas.get(j);
          maxProduct = Math.max(maxProduct, product);
        }
      }
    }

    return maxProduct;
  }

  private static boolean isValidPlus(List<String> grid, int i, int j, int length) {
    int n = grid.size();
    int m = grid.get(0).length();

    if (i - length < 0 || i + length >= n || j - length < 0 || j + length >= m) {
      return false;
    }

    return grid.get(i - length).charAt(j) == 'G'
        && grid.get(i + length).charAt(j) == 'G'
        && grid.get(i).charAt(j - length) == 'G'
        && grid.get(i).charAt(j + length) == 'G';
  }

  private static List<int[]> generatePlus(int i, int j, int length) {
    List<int[]> cells = new ArrayList<>();
    cells.add(new int[] {i, j});
    for (int l = 1; l <= length; l++) {
      cells.add(new int[] {i - l, j});
      cells.add(new int[] {i + l, j});
      cells.add(new int[] {i, j - l});
      cells.add(new int[] {i, j + l});
    }
    return cells;
  }

  private static boolean overlaps(List<int[]> plus1, List<int[]> plus2) {
    Set<String> set = new HashSet<>();
    for (int[] cell : plus1) {
      set.add(cell[0] + "," + cell[1]);
    }
    for (int[] cell : plus2) {
      if (set.contains(cell[0] + "," + cell[1])) {
        return true;
      }
    }
    return false;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

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

    int result = Result.twoPluses(grid);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
