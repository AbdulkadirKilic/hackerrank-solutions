// HackerRank Question: https://www.hackerrank.com/challenges/find-a-word/problem

package solutions.regex.Find_a_Word;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Number of sentences
    int n = Integer.parseInt(scanner.nextLine());
    String[] sentences = new String[n];

    // Read sentences
    for (int i = 0; i < n; i++) {
      sentences[i] = scanner.nextLine();
    }

    // Number of words to search for
    int t = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < t; i++) {
      String word = scanner.nextLine();
      int count = 0;

      // Regex pattern to match the word as a whole word
      String regex = "\\b" + Pattern.quote(word) + "\\b";
      Pattern pattern = Pattern.compile(regex);

      for (String sentence : sentences) {
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
          count++;
        }
      }

      // Output the count of occurrences
      System.out.println(count);
    }
  }
}
