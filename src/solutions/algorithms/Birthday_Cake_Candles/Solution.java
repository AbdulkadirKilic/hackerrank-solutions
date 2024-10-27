// HackerRank Question: https://www.hackerrank.com/challenges/birthday-cake-candles/problem

package solutions.algorithms.Birthday_Cake_Candles;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'birthdayCakeCandles' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY candles as parameter.
   */

  public static int birthdayCakeCandles(List<Integer> candles) {
    // Find the maximum height of the candles
    int maxCandleHeight = Collections.max(candles);

    // Count how many candles have the maximum height
    int count = 0;
    for (int height : candles) {
      if (height == maxCandleHeight) {
        count++;
      }
    }

    return count;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> candles =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.birthdayCakeCandles(candles);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
