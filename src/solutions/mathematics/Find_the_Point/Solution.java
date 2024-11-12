// HackerRank Question: https://www.hackerrank.com/challenges/find-point/problem

package solutions.mathematics.Find_the_Point;

import static java.util.stream.Collectors.joining;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'findPoint' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER px
   *  2. INTEGER py
   *  3. INTEGER qx
   *  4. INTEGER qy
   */

  public static List<Integer> findPoint(int px, int py, int qx, int qy) {
    // Calculate the reflected point coordinates
    int rx = 2 * qx - px;
    int ry = 2 * qy - py;

    // Return the result as a list
    return Arrays.asList(rx, ry);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, n)
        .forEach(
            nItr -> {
              try {
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int px = Integer.parseInt(firstMultipleInput[0]);

                int py = Integer.parseInt(firstMultipleInput[1]);

                int qx = Integer.parseInt(firstMultipleInput[2]);

                int qy = Integer.parseInt(firstMultipleInput[3]);

                List<Integer> result = Result.findPoint(px, py, qx, qy);

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
