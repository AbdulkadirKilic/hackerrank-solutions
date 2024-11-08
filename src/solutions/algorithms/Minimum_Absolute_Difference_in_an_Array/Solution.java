// HackerRank Question:
// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem

package solutions.algorithms.Minimum_Absolute_Difference_in_an_Array;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'minimumAbsoluteDifference' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int minimumAbsoluteDifference(List<Integer> arr) {
    Collections.sort(arr);
    int minDifference = Integer.MAX_VALUE;
    for (int i = 1; i < arr.size(); i++) {
      int difference = Math.abs(arr.get(i) - arr.get(i - 1));
      if (difference < minDifference) {
        minDifference = difference;
      }
    }
    return minDifference;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.minimumAbsoluteDifference(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
