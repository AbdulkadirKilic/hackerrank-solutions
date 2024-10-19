// HackerRank Question: https://www.hackerrank.com/challenges/java-date-and-time/problem

package solutions.java.Java_Date_And_Time;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

class Result {

  public static String findDay(int month, int day, int year) {

    LocalDate date = LocalDate.of(year, month, day);
    DayOfWeek dayOfWeek = date.getDayOfWeek();

    return dayOfWeek.toString();
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int month = Integer.parseInt(firstMultipleInput[0]);

    int day = Integer.parseInt(firstMultipleInput[1]);

    int year = Integer.parseInt(firstMultipleInput[2]);

    String res = Result.findDay(month, day, year);

    bufferedWriter.write(res);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
