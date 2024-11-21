// HackerRank Question: https://www.hackerrank.com/challenges/sherlock-and-planes/problem

package solutions.mathematics.Sherlock_and_Planes;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts 2D_INTEGER_ARRAY points as parameter.
   */

  public static String solve(List<List<Integer>> points) {
    int[] p1 = points.get(0).stream().mapToInt(i -> i).toArray();
    int[] p2 = points.get(1).stream().mapToInt(i -> i).toArray();
    int[] p3 = points.get(2).stream().mapToInt(i -> i).toArray();
    int[] p4 = points.get(3).stream().mapToInt(i -> i).toArray();

    int[] v1 = {p2[0] - p1[0], p2[1] - p1[1], p2[2] - p1[2]};
    int[] v2 = {p3[0] - p1[0], p3[1] - p1[1], p3[2] - p1[2]};
    int[] v3 = {p4[0] - p1[0], p4[1] - p1[1], p4[2] - p1[2]};

    int determinant =
        v1[0] * (v2[1] * v3[2] - v2[2] * v3[1])
            - v1[1] * (v2[0] * v3[2] - v2[2] * v3[0])
            + v1[2] * (v2[0] * v3[1] - v2[1] * v3[0]);

    return determinant == 0 ? "YES" : "NO";
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

                List<List<Integer>> points = new ArrayList<>();

                IntStream.range(0, 4)
                    .forEach(
                        i -> {
                          try {
                            points.add(
                                Stream.of(
                                        bufferedReader
                                            .readLine()
                                            .replaceAll("\\s+$", "")
                                            .split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList()));
                          } catch (IOException ex) {
                            throw new RuntimeException(ex);
                          }
                        });

                String result = Result.solve(points);

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
