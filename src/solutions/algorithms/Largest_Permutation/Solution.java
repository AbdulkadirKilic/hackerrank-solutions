// HackerRank Question: https://www.hackerrank.com/challenges/largest-permutation/problem

package solutions.algorithms.Largest_Permutation;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'largestPermutation' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY arr
   */

  public static List<Integer> largestPermutation(int k, List<Integer> arr) {
    // Map to store the index of each element
    Map<Integer, Integer> indexMap = new HashMap<>();

    // Populate the map with initial indices of elements in arr
    for (int i = 0; i < arr.size(); i++) {
      indexMap.put(arr.get(i), i);
    }

    int n = arr.size();

    // Traverse through the array to make at most k swaps
    for (int i = 0; i < n && k > 0; i++) {
      // The value that should be in the current position to get the largest lexicographical order
      int maxValue = n - i;

      // If the current element is already the maxValue, continue
      if (arr.get(i) == maxValue) {
        continue;
      }

      // Index of the element that should be here
      int maxIndex = indexMap.get(maxValue);

      // Perform the swap
      int temp = arr.get(i);
      arr.set(i, maxValue);
      arr.set(maxIndex, temp);

      // Update the map after the swap
      indexMap.put(temp, maxIndex);
      indexMap.put(maxValue, i);

      // Decrease the number of swaps left
      k--;
    }

    return arr;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.largestPermutation(k, arr);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
