// HackerRank Question: https://www.hackerrank.com/challenges/palindrome-index/problem

package solutions.algorithms.Palindrome_Index;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'palindromeIndex' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int palindromeIndex(String s) {
    int left = 0;
    int right = s.length() - 1;

    // Check if the string is already a palindrome or find the first mismatch
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        // Check if removing the character at 'left' or 'right' makes it a palindrome
        if (isPalindrome(s, left + 1, right)) {
          return left;
        } else if (isPalindrome(s, left, right - 1)) {
          return right;
        } else {
          return -1; // No single removal can make it a palindrome
        }
      }
      left++;
      right--;
    }
    return -1; // Already a palindrome
  }

  // Helper function to check if a substring is a palindrome
  private static boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
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

                int result = Result.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
