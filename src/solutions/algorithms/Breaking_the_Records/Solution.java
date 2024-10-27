// HackerRank Question:
// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

package solutions.algorithms.Breaking_the_Records;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'breakingRecords' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY scores as parameter.
   */

  public static List<Integer> breakingRecords(List<Integer> scores) {
    // Initialize counts and the starting records
    int minRecord = scores.get(0);
    int maxRecord = scores.get(0);
    int minBreaks = 0;
    int maxBreaks = 0;

    // Loop through scores starting from the second game
    for (int i = 1; i < scores.size(); i++) {
      int score = scores.get(i);

      // Check if a new maximum record is set
      if (score > maxRecord) {
        maxRecord = score;
        maxBreaks++;
      }
      // Check if a new minimum record is set
      else if (score < minRecord) {
        minRecord = score;
        minBreaks++;
      }
    }

    // Return the count of maximum and minimum record breaks as a list
    return Arrays.asList(maxBreaks, minBreaks);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> scores =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.breakingRecords(scores);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
