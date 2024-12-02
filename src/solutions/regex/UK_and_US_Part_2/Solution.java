// HackerRank Question: https://www.hackerrank.com/challenges/uk-and-us-2/problem

package solutions.regex.UK_and_US_Part_2;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    // Input handling
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine()); // Number of lines

    // Store the input lines
    StringBuilder allText = new StringBuilder();
    for (int i = 0; i < n; i++) {
      allText.append(scanner.nextLine()).append(" ");
    }
    String inputText = allText.toString();

    int t = Integer.parseInt(scanner.nextLine()); // Number of test cases

    for (int i = 0; i < t; i++) {
      String ukWord = scanner.nextLine(); // UK variant
      // Replace "our" with "or" to generate the US variant
      String usWord = ukWord.replace("our", "or");

      // Regular expressions to count both UK and US variants
      String regex = "\\b(" + ukWord + "|" + usWord + ")\\b";
      int count = countOccurrences(inputText, regex);

      System.out.println(count);
    }

    scanner.close();
  }

  // Function to count occurrences of a regex pattern in a given text
  private static int countOccurrences(String text, String regex) {
    int count = 0;
    // Compile the regex
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    // Count all matches
    while (matcher.find()) {
      count++;
    }
    return count;
  }
}
