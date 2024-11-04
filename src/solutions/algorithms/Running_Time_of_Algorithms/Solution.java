// HackerRank Question: https://www.hackerrank.com/challenges/runningtime/problem

package solutions.algorithms.Running_Time_of_Algorithms;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'runningTime' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int runningTime(List<Integer> arr) {
    int shifts = 0;
    int n = arr.size();

    // Insertion sort with shift counting
    for (int i = 1; i < n; i++) {
      int current = arr.get(i);
      int j = i - 1;

      // Shift elements to the right to make space for 'current'
      while (j >= 0 && arr.get(j) > current) {
        arr.set(j + 1, arr.get(j));
        shifts++; // Increment shift counter
        j--;
      }
      // Place 'current' at the correct position
      arr.set(j + 1, current);
    }

    return shifts;
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

    int result = Result.runningTime(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
