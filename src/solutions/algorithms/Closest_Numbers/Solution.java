// HackerRank Question: https://www.hackerrank.com/challenges/closest-numbers/problem

package solutions.algorithms.Closest_Numbers;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'closestNumbers' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> closestNumbers(List<Integer> arr) {
    // Sort the array to find consecutive pairs with smallest difference
    Collections.sort(arr);

    List<Integer> result = new ArrayList<>();
    int minDifference = Integer.MAX_VALUE;

    // Find the minimum difference between consecutive elements
    for (int i = 1; i < arr.size(); i++) {
      int diff = arr.get(i) - arr.get(i - 1);
      if (diff < minDifference) {
        minDifference = diff;
      }
    }

    // Collect all pairs with the minimum difference
    for (int i = 1; i < arr.size(); i++) {
      int diff = arr.get(i) - arr.get(i - 1);
      if (diff == minDifference) {
        result.add(arr.get(i - 1));
        result.add(arr.get(i));
      }
    }

    return result;
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

    List<Integer> result = Result.closestNumbers(arr);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
