// HackerRank Question: https://www.hackerrank.com/challenges/picking-numbers/problem

package solutions.algorithms.Picking_Numbers;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'pickingNumbers' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static int pickingNumbers(List<Integer> a) {
    // Frequency array to count occurrences of each integer
    int[] freq = new int[100];

    // Populate the frequency array
    for (int num : a) {
      freq[num]++;
    }

    int maxLength = 0;

    // Find the longest subarray where the absolute difference is at most 1
    for (int i = 0; i < freq.length - 1; i++) {
      maxLength = Math.max(maxLength, freq[i] + freq[i + 1]);
    }

    return maxLength;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.pickingNumbers(a);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
