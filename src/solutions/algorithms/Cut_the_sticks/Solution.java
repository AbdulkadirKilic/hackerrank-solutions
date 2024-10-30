// HackerRank Question: https://www.hackerrank.com/challenges/cut-the-sticks/problem

package solutions.algorithms.Cut_the_sticks;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'cutTheSticks' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> cutTheSticks(List<Integer> arr) {
    List<Integer> result = new ArrayList<>();

    // Sort the array to make finding the shortest stick easy
    Collections.sort(arr);

    int n = arr.size();
    int i = 0;

    while (i < n) {
      // Add the current number of sticks left
      result.add(n - i);

      // Skip all elements of the current shortest length
      int currentLength = arr.get(i);
      while (i < n && arr.get(i) == currentLength) {
        i++;
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

    List<Integer> result = Result.cutTheSticks(arr);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
