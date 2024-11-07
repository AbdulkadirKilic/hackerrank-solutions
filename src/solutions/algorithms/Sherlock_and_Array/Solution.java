// HackerRank Question: https://www.hackerrank.com/challenges/sherlock-and-array/problem

package solutions.algorithms.Sherlock_and_Array;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'balancedSums' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static String balancedSums(List<Integer> arr) {
    int totalSum = arr.stream().mapToInt(Integer::intValue).sum();
    int leftSum = 0;

    for (int num : arr) {
      // Check if the current element is the "balance point"
      if (leftSum == totalSum - leftSum - num) {
        return "YES";
      }
      leftSum += num;
    }

    return "NO";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int T = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, T)
        .forEach(
            TItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
