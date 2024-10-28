// HackerRank Question: https://www.hackerrank.com/challenges/sock-merchant/problem

package solutions.algorithms.Sales_by_Match;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'sockMerchant' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY ar
   */

  public static int sockMerchant(int n, List<Integer> ar) {
    // Use a HashMap to count occurrences of each color
    Map<Integer, Integer> colorCount = new HashMap<>();
    int pairs = 0;

    // Count each sock color
    for (int color : ar) {
      colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
    }

    // Calculate pairs for each color
    for (int count : colorCount.values()) {
      pairs += count / 2; // Each pair is made up of two socks
    }

    return pairs;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ar =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.sockMerchant(n, ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
