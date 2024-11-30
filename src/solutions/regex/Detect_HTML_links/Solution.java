// HackerRank Question: https://www.hackerrank.com/challenges/detect-html-links/problem

package solutions.regex.Detect_HTML_links;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine()); // Number of lines of HTML fragments
    StringBuilder htmlInput = new StringBuilder();

    // Read all HTML lines into a single string
    for (int i = 0; i < n; i++) {
      htmlInput.append(scanner.nextLine()).append("\n");
    }

    // Regular expression to match <a> tags and extract href links and text
    String regex = "<a\\s+href=\"(.*?)\".*?>(.*?)</a>";
    Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
    Matcher matcher = pattern.matcher(htmlInput.toString());

    // Process matches
    while (matcher.find()) {
      String link = matcher.group(1).trim();
      String text = matcher.group(2).replaceAll("<.*?>", "").trim(); // Remove nested tags from text
      System.out.println(link + "," + text);
    }
  }
}
