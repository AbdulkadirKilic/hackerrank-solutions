// HackerRank Question: https://www.hackerrank.com/challenges/lilys-homework/problem

package solutions.algorithms.Lilys_Homework;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'lilysHomework' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int lilysHomework(List<Integer> arr) {
    // Calculate minimum swaps needed for ascending and descending sorted orders
    int ascendingSwaps = calculateSwaps(new ArrayList<>(arr), true);
    int descendingSwaps = calculateSwaps(new ArrayList<>(arr), false);

    // Return the minimum of the two swaps
    return Math.min(ascendingSwaps, descendingSwaps);
  }

  // Helper function to calculate swaps for sorting in ascending or descending order
  private static int calculateSwaps(List<Integer> arr, boolean ascending) {
    // Create a sorted version of the array
    List<Integer> sortedArr = new ArrayList<>(arr);

    // Sort array in either ascending or descending order
    if (ascending) {
      Collections.sort(sortedArr);
    } else {
      sortedArr.sort(Collections.reverseOrder());
    }

    // Mapping from original value to its index
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < arr.size(); i++) {
      indexMap.put(arr.get(i), i);
    }

    int swaps = 0;
    // Traverse through each element in original array to arrange it in sorted order
    for (int i = 0; i < arr.size(); i++) {
      int correctValue = sortedArr.get(i);

      // Check if the current element is at the correct position
      if (!arr.get(i).equals(correctValue)) {
        // Swap current element with the element at the correct position
        swaps++;

        // Get the index of the element that should be here
        int toSwapIdx = indexMap.get(correctValue);

        // Update the map after swap
        indexMap.put(arr.get(i), toSwapIdx);
        indexMap.put(correctValue, i);

        // Perform the swap in the array
        Collections.swap(arr, i, toSwapIdx);
      }
    }

    return swaps;
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

    int result = Result.lilysHomework(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
