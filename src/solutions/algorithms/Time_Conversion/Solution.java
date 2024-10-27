// HackerRank Question: https://www.hackerrank.com/challenges/time-conversion/problem

package solutions.algorithms.Time_Conversion;

import java.io.*;

class Result {

  /*
   * Complete the 'timeConversion' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String timeConversion(String s) {
    // Extract the AM/PM part of the time
    String period = s.substring(s.length() - 2);
    // Extract the hour, minute, and second parts
    int hour = Integer.parseInt(s.substring(0, 2));
    String minutesAndSeconds = s.substring(2, s.length() - 2);

    // Convert hour based on AM/PM
    if (period.equals("AM")) {
      if (hour == 12) {
        hour = 0; // Midnight case
      }
    } else { // PM case
      if (hour != 12) {
        hour += 12; // Convert to 24-hour format for PM times except noon
      }
    }

    // Format hour as two digits and return the full time string
    return String.format("%02d", hour) + minutesAndSeconds;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.timeConversion(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
