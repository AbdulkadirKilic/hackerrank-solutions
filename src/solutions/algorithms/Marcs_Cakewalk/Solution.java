// HackerRank Question: https://www.hackerrank.com/challenges/marcs-cakewalk/problem

package solutions.algorithms.Marcs_Cakewalk;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'marcsCakewalk' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts INTEGER_ARRAY calorie as parameter.
   */

  public static long marcsCakewalk(List<Integer> calorie) {
    // Sort calories in descending order
    calorie.sort(Collections.reverseOrder());

    long miles = 0;

    // Calculate the minimum miles Marc has to walk
    for (int i = 0; i < calorie.size(); i++) {
      miles += (long) calorie.get(i) * (1L << i); // Equivalent to calorie[i] * 2^i
    }

    return miles;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> calorie =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    long result = Result.marcsCakewalk(calorie);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
