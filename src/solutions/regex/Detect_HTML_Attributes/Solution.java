// HackerRank Question: https://www.hackerrank.com/challenges/html-attributes/problem

package solutions.regex.Detect_HTML_Attributes;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    // Map to store tags and their corresponding attributes
    Map<String, TreeSet<String>> tagAttributes = new TreeMap<>();

    // Regular expression to extract tags and their attributes
    String tagPattern = "<(\\w+)([^>]*)>"; // Matches the tag name and attributes
    String attributePattern =
        "(\\w+)\\s*=\\s*['\"][^'\"]*['\"]"; // Matches each attribute inside a tag

    Pattern tagRegex = Pattern.compile(tagPattern);
    Pattern attributeRegex = Pattern.compile(attributePattern);

    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine();
      Matcher tagMatcher = tagRegex.matcher(line);

      while (tagMatcher.find()) {
        String tagName = tagMatcher.group(1); // Extract tag name
        String attributesSection = tagMatcher.group(2); // Extract attribute section

        // Initialize the set of attributes for this tag if not already present
        tagAttributes.putIfAbsent(tagName, new TreeSet<>());

        // Match all attributes within the current tag
        Matcher attrMatcher = attributeRegex.matcher(attributesSection);
        while (attrMatcher.find()) {
          tagAttributes.get(tagName).add(attrMatcher.group(1)); // Add the attribute name
        }
      }
    }

    scanner.close();

    // Print the output in the desired format
    for (Map.Entry<String, TreeSet<String>> entry : tagAttributes.entrySet()) {
      System.out.print(entry.getKey() + ":");
      System.out.println(String.join(",", entry.getValue()));
    }
  }
}
