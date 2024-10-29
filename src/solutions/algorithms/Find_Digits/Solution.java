// HackerRank Question: https://www.hackerrank.com/challenges/find-digits/problem

package solutions.algorithms.Find_Digits;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'findDigits' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  public static int findDigits(int n) {
    int originalNumber = n;
    int count = 0;

    while (n > 0) {
      int digit = n % 10; // Get the last digit
      if (digit != 0 && originalNumber % digit == 0) {
        count++;
      }
      n /= 10; // Remove the last digit
    }

    return count;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
