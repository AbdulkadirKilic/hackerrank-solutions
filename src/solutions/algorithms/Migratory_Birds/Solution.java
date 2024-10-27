// HackerRank Question: https://www.hackerrank.com/challenges/migratory-birds/problem

package solutions.algorithms.Migratory_Birds;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'migratoryBirds' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int migratoryBirds(List<Integer> arr) {
    int[] birdCounts = new int[6]; // Since types are between 1 and 5, we use 6 to index directly

    // Count occurrences of each bird type
    for (int bird : arr) {
      birdCounts[bird]++;
    }

    int maxCount = 0;
    int resultType = 0;

    // Determine the type with the maximum count
    for (int i = 1; i < birdCounts.length; i++) {
      if (birdCounts[i] > maxCount) {
        maxCount = birdCounts[i];
        resultType = i;
      } else if (birdCounts[i] == maxCount && i < resultType) {
        resultType = i; // Choose the smaller id if there's a tie
      }
    }

    return resultType;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.migratoryBirds(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
