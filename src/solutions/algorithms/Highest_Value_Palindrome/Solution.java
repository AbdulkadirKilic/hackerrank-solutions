// HackerRank Question: https://www.hackerrank.com/challenges/game-of-thrones/problem

package solutions.algorithms.Highest_Value_Palindrome;

import java.io.*;

class Result {

  /*
   * Complete the 'highestValuePalindrome' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER n
   *  3. INTEGER k
   */

  public static String highestValuePalindrome(String s, int n, int k) {
    char[] chars = s.toCharArray();
    boolean[] changed = new boolean[n];
    int changesNeeded = 0;

    // Step 1: Make it a palindrome
    for (int i = 0; i < n / 2; i++) {
      int j = n - 1 - i;
      if (chars[i] != chars[j]) {
        // Change the smaller character to the larger one
        chars[i] = chars[j] = (char) Math.max(chars[i], chars[j]);
        changed[i] = true; // Mark this position as changed
        changesNeeded++;
      }
    }

    // If we need more changes than allowed, return -1
    if (changesNeeded > k) {
      return "-1";
    }

    // Step 2: Maximize the palindrome
    int remainingChanges = k - changesNeeded;

    for (int i = 0; i < n / 2; i++) {
      int j = n - 1 - i;
      if (chars[i] != '9') {
        // If this position was changed before, we need only 1 change to make both '9'
        // Otherwise, we need 2 changes to make both '9'
        if (changed[i] && remainingChanges > 0) {
          chars[i] = chars[j] = '9';
          remainingChanges--;
        } else if (remainingChanges > 1) {
          chars[i] = chars[j] = '9';
          remainingChanges -= 2;
        }
      }
    }

    // Special case for odd-length strings: maximize the middle character if there's a change left
    if (n % 2 == 1 && remainingChanges > 0) {
      chars[n / 2] = '9';
    }

    return new String(chars);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    String s = bufferedReader.readLine();

    String result = Result.highestValuePalindrome(s, n, k);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
