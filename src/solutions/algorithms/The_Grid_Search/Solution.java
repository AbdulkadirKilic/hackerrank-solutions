// HackerRank Question: https://www.hackerrank.com/challenges/the-grid-search/problem

package solutions.algorithms.The_Grid_Search;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'gridSearch' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING_ARRAY G
   *  2. STRING_ARRAY P
   */

  public static String gridSearch(List<String> G, List<String> P) {
    int R = G.size(); // Grid row count
    int C = G.get(0).length(); // Grid column count
    int r = P.size(); // Pattern row count
    int c = P.get(0).length(); // Pattern column count

    // Traverse the grid
    for (int i = 0; i <= R - r; i++) {
      for (int j = 0; j <= C - c; j++) {
        // Check if pattern matches at this position
        boolean found = true;
        for (int x = 0; x < r; x++) {
          if (!G.get(i + x).substring(j, j + c).equals(P.get(x))) {
            found = false;
            break;
          }
        }
        if (found) {
          return "YES";
        }
      }
    }
    return "NO";
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

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G =
                    IntStream.range(0, R)
                        .mapToObj(
                            i -> {
                              try {
                                return bufferedReader.readLine();
                              } catch (IOException ex) {
                                throw new RuntimeException(ex);
                              }
                            })
                        .collect(toList());

                String[] secondMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P =
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

                String result = Result.gridSearch(G, P);

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
