// HackerRank Question: https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem

package solutions.algorithms.HackerRank_in_a_String;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'hackerrankInString' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String hackerrankInString(String s) {
    String target = "hackerrank";
    int targetIndex = 0;

    // Traverse through the input string
    for (int i = 0; i < s.length(); i++) {
      // Check if the current character matches the current target character
      if (s.charAt(i) == target.charAt(targetIndex)) {
        targetIndex++;
      }
      // If we have matched all characters of "hackerrank", return "YES"
      if (targetIndex == target.length()) {
        return "YES";
      }
    }

    // If we finish the loop without matching "hackerrank", return "NO"
    return "NO";
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

                String result = Result.hackerrankInString(s);

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
