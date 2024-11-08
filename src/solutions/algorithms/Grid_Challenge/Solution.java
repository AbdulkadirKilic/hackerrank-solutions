// HackerRank Question: https://www.hackerrank.com/challenges/grid-challenge/problem

package solutions.algorithms.Grid_Challenge;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'gridChallenge' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING_ARRAY grid as parameter.
   */

  public static String gridChallenge(List<String> grid) {
    // Sort each row of the grid alphabetically
    for (int i = 0; i < grid.size(); i++) {
      char[] rowChars = grid.get(i).toCharArray();
      Arrays.sort(rowChars);
      grid.set(i, new String(rowChars));
    }

    // Check each column to ensure it's in alphabetical order
    for (int col = 0; col < grid.get(0).length(); col++) {
      for (int row = 1; row < grid.size(); row++) {
        // If the current character is less than the character above, return NO
        if (grid.get(row).charAt(col) < grid.get(row - 1).charAt(col)) {
          return "NO";
        }
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

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
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

                String result = Result.gridChallenge(grid);

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
