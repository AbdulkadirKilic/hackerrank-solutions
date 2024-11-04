// HackerRank Question: https://www.hackerrank.com/challenges/quicksort1/problem

package solutions.algorithms.Quicksort_1_Partition;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'quickSort' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> quickSort(List<Integer> arr) {
    int pivot = arr.get(0);

    List<Integer> left = new ArrayList<>();
    List<Integer> equal = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    // Partitioning step
    for (int num : arr) {
      if (num < pivot) {
        left.add(num);
      } else if (num > pivot) {
        right.add(num);
      } else {
        equal.add(num);
      }
    }

    // Combine all partitions
    List<Integer> sortedList = new ArrayList<>();
    sortedList.addAll(left);
    sortedList.addAll(equal);
    sortedList.addAll(right);

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

    List<Integer> result = Result.quickSort(arr);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
