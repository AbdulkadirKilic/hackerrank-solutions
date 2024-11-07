// HackerRank Question: https://www.hackerrank.com/challenges/missing-numbers/problem

package solutions.algorithms.Missing_Numbers;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'missingNumbers' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY arr
   *  2. INTEGER_ARRAY brr
   */

  public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    Map<Integer, Integer> freqArr = new HashMap<>();
    Map<Integer, Integer> freqBrr = new HashMap<>();

    // Count frequency in arr
    for (int num : arr) {
      freqArr.put(num, freqArr.getOrDefault(num, 0) + 1);
    }

    // Count frequency in brr
    for (int num : brr) {
      freqBrr.put(num, freqBrr.getOrDefault(num, 0) + 1);
    }

    List<Integer> result = new ArrayList<>();

    // Find numbers where frequency in arr is less than in brr
    for (Map.Entry<Integer, Integer> entry : freqBrr.entrySet()) {
      int num = entry.getKey();
      int countInBrr = entry.getValue();
      int countInArr = freqArr.getOrDefault(num, 0);

      if (countInArr < countInBrr) {
        result.add(num);
      }
    }

    // Sort result in ascending order
    Collections.sort(result);
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

    int m = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> brr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.missingNumbers(arr, brr);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
