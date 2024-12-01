// HackerRank Question: https://www.hackerrank.com/challenges/find-hackerrank/problem

package solutions.regex.Find_HackerRank;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine().trim();

      if (line.matches("^hackerrank$")) { // Matches exactly "hackerrank"
        System.out.println(0);
      } else if (line.matches("^hackerrank.*")) { // Starts with "hackerrank"
        System.out.println(1);
      } else if (line.matches(".*hackerrank$")) { // Ends with "hackerrank"
        System.out.println(2);
      } else { // Does not meet any condition
        System.out.println(-1);
      }
    }

    scanner.close();
  }
}
