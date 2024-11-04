// HackerRank Question: https://www.hackerrank.com/challenges/two-characters/problem

package solutions.algorithms.Two_Characters;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'alternate' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int alternate(String s) {
    Set<Character> uniqueChars = new HashSet<>();

    // Collect unique characters in the string
    for (char c : s.toCharArray()) {
      uniqueChars.add(c);
    }

    int maxLength = 0;

    // Generate all unique pairs of characters
    List<Character> charList = new ArrayList<>(uniqueChars);
    for (int i = 0; i < charList.size(); i++) {
      for (int j = i + 1; j < charList.size(); j++) {
        char char1 = charList.get(i);
        char char2 = charList.get(j);

        // Filter the string to only include the two characters in the pair
        String filtered = filterString(s, char1, char2);

        // Check if the filtered string is alternating
        if (isAlternating(filtered)) {
          maxLength = Math.max(maxLength, filtered.length());
        }
      }
    }

    return maxLength;
  }

  // Function to filter the string to only include char1 and char2
  private static String filterString(String s, char char1, char char2) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == char1 || c == char2) {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  // Function to check if the string is alternating
  private static boolean isAlternating(String s) {
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        return false;
      }
    }
    return true;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int l = Integer.parseInt(bufferedReader.readLine().trim());

    String s = bufferedReader.readLine();

    int result = Result.alternate(s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
