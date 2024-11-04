// HackerRank Question: https://www.hackerrank.com/challenges/insertionsort1/problem

package solutions.algorithms.Insertion_Sort_Part_1;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

  /*
   * Complete the 'insertionSort1' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY arr
   */

  public static void insertionSort1(int n, List<Integer> arr) {
    int valueToInsert = arr.get(n - 1); // The value to be inserted
    int i = n - 2;

    // Shift elements to the right until we find the correct position for valueToInsert
    while (i >= 0 && arr.get(i) > valueToInsert) {
      arr.set(i + 1, arr.get(i)); // Shift element to the right
      printArray(arr);
      i--;
    }

    // Place the valueToInsert in its correct position
    arr.set(i + 1, valueToInsert);
    printArray(arr); // Print the final sorted array
  }

  // Utility function to print the list in the required format
  private static void printArray(List<Integer> arr) {
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

    Result.insertionSort1(n, arr);

    bufferedReader.close();
  }
}
