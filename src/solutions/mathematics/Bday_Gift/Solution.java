// HackerRank Question: https://www.hackerrank.com/challenges/bday-gift/problem

package solutions.mathematics.Bday_Gift;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a DOUBLE.
   * The function accepts INTEGER_ARRAY balls as parameter.
   */

  public static double solve(List<Integer> balls) {
    // Calculate the expected value
    double expectedValue = 0.0;
    for (int ball : balls) {
      // Each ball contributes half its value to the expected value
      expectedValue += ball * 0.5;
    }
    return expectedValue;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int ballsCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> balls =
        IntStream.range(0, ballsCount)
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

    double result = Result.solve(balls);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
