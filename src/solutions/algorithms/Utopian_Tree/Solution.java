// HackerRank Question: https://www.hackerrank.com/challenges/utopian-tree/problem

package solutions.algorithms.Utopian_Tree;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'utopianTree' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  public static int utopianTree(int n) {
    int height = 1;

    for (int i = 1; i <= n; i++) {
      if (i % 2 != 0) { // Spring cycle
        height *= 2;
      } else { // Summer cycle
        height += 1;
      }
    }

    return height;
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

                int result = Result.utopianTree(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
