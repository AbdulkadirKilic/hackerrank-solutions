// HackerRank Question: https://www.hackerrank.com/challenges/mark-and-toys/problem

package solutions.algorithms.Mark_and_Toys;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'maximumToys' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY prices
   *  2. INTEGER k
   */

  public static int maximumToys(List<Integer> prices, int k) {
    // Sort the prices in ascending order
    Collections.sort(prices);

    int toysCount = 0;
    int totalSpent = 0;

    // Traverse through sorted prices and add toys until the budget is exhausted
    for (int price : prices) {
      if (totalSpent + price > k) {
        break; // Stop if adding the current price exceeds the budget
      }
      totalSpent += price;
      toysCount++;
    }

    return toysCount;
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

    List<Integer> prices =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.maximumToys(prices, k);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
