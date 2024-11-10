// HackerRank Question: https://www.hackerrank.com/challenges/minimum-loss/problem

package solutions.algorithms.Minimum_Loss;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'minimumLoss' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts LONG_INTEGER_ARRAY price as parameter.
   */

  public static int minimumLoss(List<Long> price) {
    // Price and original index pairs stored in a list
    List<Map.Entry<Long, Integer>> priceIndexPairs = new ArrayList<>();

    // Populate the list with price-index pairs
    for (int i = 0; i < price.size(); i++) {
      priceIndexPairs.add(new AbstractMap.SimpleEntry<>(price.get(i), i));
    }

    // Sort the list by price
    priceIndexPairs.sort(Map.Entry.comparingByKey());

    long minLoss = Long.MAX_VALUE;

    // Iterate over sorted prices and check for minimal loss in sorted order
    for (int i = 1; i < priceIndexPairs.size(); i++) {
      long currentPrice = priceIndexPairs.get(i).getKey();
      long previousPrice = priceIndexPairs.get(i - 1).getKey();
      int currentIndex = priceIndexPairs.get(i).getValue();
      int previousIndex = priceIndexPairs.get(i - 1).getValue();

      // Ensure that we are selling after buying (position in original list)
      if (currentIndex < previousIndex) {
        minLoss = Math.min(minLoss, currentPrice - previousPrice);
      }
    }

    return (int) minLoss;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Long> price =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

    int result = Result.minimumLoss(price);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
