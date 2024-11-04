// HackerRank Question: https://www.hackerrank.com/challenges/insertionsort2/problem

package solutions.algorithms.Insertion_Sort_Part_2;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'insertionSort2' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY arr
   */

  public static void insertionSort2(int n, List<Integer> arr) {
    for (int i = 1; i < n; i++) {
      int key = arr.get(i); // Current element to be inserted in sorted part
      int j = i - 1;

      // Shift elements in sorted part to the right if they are greater than key
      while (j >= 0 && arr.get(j) > key) {
        arr.set(j + 1, arr.get(j));
        j--;
      }
      arr.set(j + 1, key); // Insert key in its correct position

      printArray(arr); // Print current state after each insertion
    }
  }

  private static void printArray(List<Integer> arr) {
    // Convert list to space-separated string and print
    System.out.println(arr.stream().map(String::valueOf).collect(Collectors.joining(" ")));
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

    Result.insertionSort2(n, arr);

    bufferedReader.close();
  }
}
