// HackerRank Question: https://www.hackerrank.com/challenges/mini-max-sum/problem

package solutions.algorithms.Mini_Max_Sum;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'miniMaxSum' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static void miniMaxSum(List<Integer> arr) {
    // Convert to long to handle large sums
    long totalSum = 0;

    // Calculate the sum of all elements
    for (int num : arr) {
      totalSum += num;
    }

    // Calculate minimum and maximum sum by excluding one element each time
    long minSum = totalSum - Collections.max(arr); // Exclude the maximum element
    long maxSum = totalSum - Collections.min(arr); // Exclude the minimum element

    System.out.println(minSum + " " + maxSum);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    Result.miniMaxSum(arr);

    bufferedReader.close();
  }
}
