// HackerRank Question: https://www.hackerrank.com/challenges/camelcase/problem

package solutions.algorithms.CamelCase;

import java.io.*;

class Result {

  /*
   * Complete the 'camelcase' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int camelcase(String s) {
    int wordCount =
        1; // Start with 1 since the first word is lowercase and has no leading uppercase

    for (char ch : s.toCharArray()) {
      if (Character.isUpperCase(ch)) {
        wordCount++; // Increment for each uppercase letter, indicating a new word
      }
    }

    return wordCount;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    int result = Result.camelcase(s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
