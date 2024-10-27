// HackerRank Question: https://www.hackerrank.com/challenges/day-of-the-programmer/problem

package solutions.algorithms.Day_of_the_Programmer;

import java.io.*;

class Result {

  /*
   * Complete the 'dayOfProgrammer' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER year as parameter.
   */

  public static String dayOfProgrammer(int year) {
    // Handle the transition year 1918
    if (year == 1918) {
      return "26.09.1918"; // 256th day after February 14
    }

    // Check for leap years in Julian and Gregorian calendars
    boolean isLeap;
    if (year < 1918) { // Julian calendar
      isLeap = year % 4 == 0;
    } else { // Gregorian calendar
      isLeap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Determine the 256th day in September
    if (isLeap) {
      return "12.09." + year;
    } else {
      return "13.09." + year;
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int year = Integer.parseInt(bufferedReader.readLine().trim());

    String result = Result.dayOfProgrammer(year);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
