// HackerRank Question: https://www.hackerrank.com/challenges/ncr-table/problem

package solutions.mathematics.nCr_table;

import static java.util.stream.Collectors.joining;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER n as parameter.
   */

  private static final int MOD = 1_000_000_000; // Modulo for the last 9 digits

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER n as parameter.
   */
  public static List<Integer> solve(int n) {
    // Pascal's Triangle row calculation using dynamic programming
    List<Integer> row = new ArrayList<>(Collections.nCopies(n + 1, 0));
    row.set(0, 1); // C(n, 0) = 1

    for (int i = 1; i <= n; i++) {
      int prev = 1; // Initialize C(i, 0) = 1
      for (int j = 1; j < i; j++) {
        int current = row.get(j);
        row.set(j, (prev + current) % MOD);
        prev = current;
      }
      row.set(i, 1); // C(n, n) = 1
    }
    return row;
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

                List<Integer> result = Result.solve(n);

                bufferedWriter.write(
                    result.stream().map(Object::toString).collect(joining(" ")) + "\n");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
