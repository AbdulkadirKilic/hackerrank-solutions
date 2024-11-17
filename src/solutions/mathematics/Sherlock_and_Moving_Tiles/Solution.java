// HackerRank Question: https://www.hackerrank.com/challenges/sherlock-and-moving-tiles/problem

package solutions.mathematics.Sherlock_and_Moving_Tiles;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'movingTiles' function below.
   *
   * The function is expected to return a DOUBLE_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER l
   *  2. INTEGER s1
   *  3. INTEGER s2
   *  4. INTEGER_ARRAY queries
   */

  public static List<Double> movingTiles(int l, int s1, int s2, List<Long> queries) {
    List<Double> results = new ArrayList<>();

    // Precompute the constant factors
    double sqrt2 = Math.sqrt(2); // Square root of 2
    double velocityDifference = Math.abs(s1 - s2); // Absolute velocity difference

    // Process each query
    for (long q : queries) {
      // Calculate the time for the query using the formula
      double time = sqrt2 * (l - Math.sqrt(q)) / velocityDifference;
      results.add(time);
    }

    return results;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int l = Integer.parseInt(firstMultipleInput[0]);
    int s1 = Integer.parseInt(firstMultipleInput[1]);
    int s2 = Integer.parseInt(firstMultipleInput[2]);

    int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Long> queries =
        IntStream.range(0, queriesCount)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .map(Long::parseLong)
            .collect(Collectors.toList());

    List<Double> result = Result.movingTiles(l, s1, s2, queries);

    for (Double r : result) {
      // Format the result to 6 decimal places
      bufferedWriter.write(String.format("%.6f", r));
      bufferedWriter.newLine();
    }

    bufferedReader.close();
    bufferedWriter.close();
  }
}
