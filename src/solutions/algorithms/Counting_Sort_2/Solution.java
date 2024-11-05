// HackerRank Question: https://www.hackerrank.com/challenges/countingsort2/problem

package solutions.algorithms.Counting_Sort_2;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'countingSort' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> countingSort(List<Integer> arr) {
    // Initialize a frequency array of size 100
    int[] frequency = new int[100];

    // Count occurrences of each integer in `arr`
    for (int num : arr) {
      frequency[num]++;
    }

    // Build the sorted list based on frequency array
    List<Integer> sortedList = new ArrayList<>();
    for (int i = 0; i < frequency.length; i++) {
      for (int j = 0; j < frequency[i]; j++) {
        sortedList.add(i);
      }
    }

    return sortedList;
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

    List<Integer> result = Result.countingSort(arr);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
