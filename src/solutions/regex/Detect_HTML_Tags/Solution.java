// HackerRank Question: https://www.hackerrank.com/challenges/detect-html-tags/problem

package solutions.regex.Detect_HTML_Tags;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine()); // Number of HTML fragments
    Set<String> tags =
        new TreeSet<>(); // Using TreeSet to automatically sort tags lexicographically

    String regex = "<\\s*(\\w+)(\\s|>)"; // Regex to match tag names (ignores attributes)
    Pattern pattern = Pattern.compile(regex);

    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine();
      Matcher matcher = pattern.matcher(line);

      // Extract and store tag names
      while (matcher.find()) {
        tags.add(matcher.group(1));
      }
    }

    // Join and print tags in lexicographical order
    System.out.println(String.join(";", tags));
  }
}
