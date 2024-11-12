// HackerRank Question: https://www.hackerrank.com/challenges/candies/problem

package solutions.algorithms.Candies;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'candies' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY arr
   */

  public static long candies(int n, List<Integer> arr) {
    // Array to store the candies for each child
    int[] candies = new int[n];
    Arrays.fill(candies, 1); // Start by giving 1 candy to each child

    // Left to right pass
    for (int i = 1; i < n; i++) {
      if (arr.get(i) > arr.get(i - 1)) {
        candies[i] = candies[i - 1] + 1;
      }
    }

    // Right to left pass
    for (int i = n - 2; i >= 0; i--) {
      if (arr.get(i) > arr.get(i + 1)) {
        candies[i] = Math.max(candies[i], candies[i + 1] + 1);
      }
    }

    // Sum up the candies for the result
    long totalCandies = 0;
    for (int candy : candies) {
      totalCandies += candy;
    }

    return totalCandies;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr =
        IntStream.range(0, n)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    long result = Result.candies(n, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
