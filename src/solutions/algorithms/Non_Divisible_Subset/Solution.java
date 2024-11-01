// HackerRank Question: https://www.hackerrank.com/challenges/non-divisible-subset/problem

package solutions.algorithms.Non_Divisible_Subset;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'nonDivisibleSubset' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY s
   */

  public static int nonDivisibleSubset(int k, List<Integer> s) {
    // Array to store counts of remainders when divided by k
    int[] remainderCounts = new int[k];

    // Count frequencies of each remainder
    for (int num : s) {
      remainderCounts[num % k]++;
    }

    // Initialize result (if there are numbers with remainder 0, pick only one)
    int result = Math.min(remainderCounts[0], 1);

    // Process each remainder pair
    for (int i = 1; i <= k / 2; i++) {
      if (i == k - i) { // If i is exactly half of k, add only one element
        result += Math.min(remainderCounts[i], 1);
      } else {
        result += Math.max(remainderCounts[i], remainderCounts[k - i]);
      }
    }

    return result;
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

    List<Integer> s =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.nonDivisibleSubset(k, s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
