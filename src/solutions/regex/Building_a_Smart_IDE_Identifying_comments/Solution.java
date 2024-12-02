// HackerRank Question: https://www.hackerrank.com/challenges/ide-identifying-comments/problem

package solutions.regex.Building_a_Smart_IDE_Identifying_comments;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder input = new StringBuilder();

    // Read the entire input program
    while (scanner.hasNextLine()) {
      input.append(scanner.nextLine()).append("\n");
    }
    scanner.close();

    // Regex for single-line and multi-line comments
    String commentRegex = "(//.*?$)|(/\\*.*?\\*/)";
    Pattern pattern = Pattern.compile(commentRegex, Pattern.DOTALL | Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(input);

    // Extract and print comments
    while (matcher.find()) {
      String comment = matcher.group().trim();

      // Ensure proper formatting of multi-line comments
      if (comment.startsWith("/*")) {
        comment =
            comment.replaceAll(
                "(?m)^\\s+", ""); // Remove leading spaces for each line in multi-line comments
      }
      System.out.println(comment);
    }
  }
}
