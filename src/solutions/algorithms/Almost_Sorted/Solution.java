// HackerRank Question: https://www.hackerrank.com/challenges/almost-sorted/problem

package solutions.algorithms.Almost_Sorted;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'almostSorted' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static void almostSorted(List<Integer> arr) {
    int n = arr.size();

    // Identify the indices where the order is violated
    int left = -1;
    int right = -1;
    for (int i = 0; i < n - 1; i++) {
      if (arr.get(i) > arr.get(i + 1)) {
        if (left == -1) {
          left = i;
        }
        right = i + 1;
      }
    }

    // Case when the array is already sorted
    if (left == -1) {
      System.out.println("yes");
      return;
    }

    // Try swap
    Collections.swap(arr, left, right);
    if (isSorted(arr)) {
      System.out.println("yes");
      System.out.println("swap " + (left + 1) + " " + (right + 1));
      return;
    }
    // Undo the swap
    Collections.swap(arr, left, right);

    // Try reverse
    List<Integer> subList = arr.subList(left, right + 1);
    Collections.reverse(subList);
    if (isSorted(arr)) {
      System.out.println("yes");
      System.out.println("reverse " + (left + 1) + " " + (right + 1));
      return;
    }

    // If neither swap nor reverse works
    System.out.println("no");
  }

  // Helper function to check if a list is sorted
  private static boolean isSorted(List<Integer> arr) {
    for (int i = 0; i < arr.size() - 1; i++) {
      if (arr.get(i) > arr.get(i + 1)) {
        return false;
      }
    }
    return true;
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

    Result.almostSorted(arr);

    bufferedReader.close();
  }
}
