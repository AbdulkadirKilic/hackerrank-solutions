// HackerRank Question: https://www.hackerrank.com/challenges/plus-minus/problem

package solutions.algorithms.Plus_Minus;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'plusMinus' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static void plusMinus(List<Integer> arr) {
    int n = arr.size();
    int positives = 0, negatives = 0, zeros = 0;

    // Count positives, negatives, and zeros
    for (int number : arr) {
      if (number > 0) {
        positives++;
      } else if (number < 0) {
        negatives++;
      } else {
        zeros++;
      }
    }

    // Calculate proportions and print them formatted to six decimal places
    System.out.printf("%.6f%n", (double) positives / n);
    System.out.printf("%.6f%n", (double) negatives / n);
    System.out.printf("%.6f%n", (double) zeros / n);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    Result.plusMinus(arr);

    bufferedReader.close();
  }
}
