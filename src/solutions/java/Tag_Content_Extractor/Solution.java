// HackerRank Question: https://www.hackerrank.com/challenges/tag-content-extractor/problem

package solutions.java.Tag_Content_Extractor;

import java.util.*;
import java.util.regex.*;

public class Solution {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());
    while (testCases > 0) {
      String line = in.nextLine();

      String regex = "<([^>]+)>([^<]+)</\\1>";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(line);

      boolean found = false;

      // Find all matches
      while (matcher.find()) {
        System.out.println(matcher.group(2));
        found = true;
      }

      if (!found) {
        System.out.println("None");
      }

      testCases--;
    }
  }
}
