// HackerRank Question: https://www.hackerrank.com/challenges/game-of-thrones/problem

package solutions.algorithms.Game_of_Thrones_I;

import java.io.*;

class Result {

  /*
   * Complete the 'gameOfThrones' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String gameOfThrones(String s) {
    // Step 1: Count the frequency of each character
    int[] frequency = new int[26]; // since s consists of only lowercase letters
    for (char c : s.toCharArray()) {
      frequency[c - 'a']++;
    }

    // Step 2: Count characters with odd frequencies
    int oddCount = 0;
    for (int freq : frequency) {
      if (freq % 2 != 0) {
        oddCount++;
      }
    }

    // Step 3: Determine if the string can be rearranged into a palindrome
    return oddCount > 1 ? "NO" : "YES";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.gameOfThrones(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
