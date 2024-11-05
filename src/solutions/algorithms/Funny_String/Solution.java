// HackerRank Question: https://www.hackerrank.com/challenges/funny-string/problem

package solutions.algorithms.Funny_String;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'funnyString' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String funnyString(String s) {
    int n = s.length();

    // Compare the absolute differences for `s` and its reverse
    for (int i = 1; i < n; i++) {
      int forwardDiff = Math.abs(s.charAt(i) - s.charAt(i - 1));
      int reverseDiff = Math.abs(s.charAt(n - i) - s.charAt(n - i - 1));

      // If any difference does not match, it's "Not Funny"
      if (forwardDiff != reverseDiff) {
        return "Not Funny";
      }
    }

    // If all differences match, it's "Funny"
    return "Funny";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                String s = bufferedReader.readLine();

                String result = Result.funnyString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
