// HackerRank Question: https://www.hackerrank.com/challenges/pangrams/problem

package solutions.algorithms.Pangrams;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'pangrams' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String pangrams(String s) {
    // Convert to lowercase to ignore case
    s = s.toLowerCase();

    // Using a HashSet to store unique letters
    Set<Character> letters = new HashSet<>();

    // Add each character to the set if it is a letter
    for (char ch : s.toCharArray()) {
      if (Character.isLetter(ch)) {
        letters.add(ch);
      }
    }

    // Check if all 26 letters are present
    return letters.size() == 26 ? "pangram" : "not pangram";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.pangrams(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
