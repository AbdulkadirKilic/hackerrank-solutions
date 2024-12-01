// HackerRank Question: https://www.hackerrank.com/challenges/saying-hi/problem

package solutions.regex.Saying_Hi;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    // Regular Expression:
    // 1. Starts with 'H' or 'h' -> [Hh]
    // 2. Followed by 'I' or 'i' -> [Ii]
    // 3. Followed by a space -> \s
    // 4. Not followed by 'D' or 'd' as the next character -> [^Dd]
    String regex = "^[Hh][Ii]\\s[^Dd].*";

    for (int i = 0; i < n; i++) {
      String sentence = scanner.nextLine().trim();
      if (sentence.matches(regex)) {
        System.out.println(sentence);
      }
    }

    scanner.close();
  }
}
