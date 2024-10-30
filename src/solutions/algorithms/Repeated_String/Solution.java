// HackerRank Question: https://www.hackerrank.com/challenges/repeated-string/problem

package solutions.algorithms.Repeated_String;

import java.io.*;

class Result {

  /*
   * Complete the 'repeatedString' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. LONG_INTEGER n
   */

  public static long repeatedString(String s, long n) {
    // Count 'a' in the original string
    long countOfAInS = s.chars().filter(c -> c == 'a').count();

    // Calculate the number of full repetitions of s within n characters
    long fullRepetitions = n / s.length();

    // Calculate the number of 'a's in full repetitions
    long totalAs = countOfAInS * fullRepetitions;

    // Calculate remaining characters after full repetitions
    long remainingCharacters = n % s.length();

    // Count 'a's in the remaining part of the string
    for (int i = 0; i < remainingCharacters; i++) {
      if (s.charAt(i) == 'a') {
        totalAs++;
      }
    }

    return totalAs;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    long n = Long.parseLong(bufferedReader.readLine().trim());

    long result = Result.repeatedString(s, n);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
