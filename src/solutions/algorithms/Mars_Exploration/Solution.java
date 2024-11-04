// HackerRank Question: https://www.hackerrank.com/challenges/mars-exploration/problem

package solutions.algorithms.Mars_Exploration;

import java.io.*;

class Result {

  /*
   * Complete the 'marsExploration' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int marsExploration(String s) {
    // Define the pattern we expect in each "SOS" message
    String expected = "SOS";
    int alteredCount = 0;

    // Loop through each character and compare it to the expected pattern
    for (int i = 0; i < s.length(); i++) {
      // Compare the character with the expected pattern in "SOS"
      if (s.charAt(i) != expected.charAt(i % 3)) {
        alteredCount++;
      }
    }

    return alteredCount;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    int result = Result.marsExploration(s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
