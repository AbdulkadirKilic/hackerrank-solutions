// HackerRank Question: https://www.hackerrank.com/challenges/rectangular-game/problem

package solutions.mathematics.Rectangular_Game;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY steps as parameter.
   */

  public static long solve(List<List<Integer>> steps) {
    // Initialize min_a and min_b to maximum possible values
    long min_a = Long.MAX_VALUE;
    long min_b = Long.MAX_VALUE;

    // Iterate over each step to find the minimum a and b
    for (List<Integer> step : steps) {
      long a = step.get(0);
      long b = step.get(1);

      min_a = Math.min(min_a, a);
      min_b = Math.min(min_b, b);
    }

    // Return the number of maximum value cells
    return min_a * min_b;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> steps = new ArrayList<>();

    IntStream.range(0, n)
        .forEach(
            i -> {
              try {
                steps.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    long result = Result.solve(steps);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
