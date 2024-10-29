// HackerRank Question: https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem

package solutions.algorithms.Beautiful_Days_at_the_Movies;

import java.io.*;

class Result {

  /*
   * Complete the 'beautifulDays' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER i
   *  2. INTEGER j
   *  3. INTEGER k
   */

  public static int beautifulDays(int i, int j, int k) {
    int beautifulDayCount = 0;

    for (int day = i; day <= j; day++) {
      int reversedDay = reverse(day);
      int difference = Math.abs(day - reversedDay);

      if (difference % k == 0) {
        beautifulDayCount++;
      }
    }

    return beautifulDayCount;
  }

  private static int reverse(int num) {
    int reversed = 0;
    while (num > 0) {
      reversed = reversed * 10 + num % 10;
      num /= 10;
    }
    return reversed;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int i = Integer.parseInt(firstMultipleInput[0]);

    int j = Integer.parseInt(firstMultipleInput[1]);

    int k = Integer.parseInt(firstMultipleInput[2]);

    int result = Result.beautifulDays(i, j, k);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
