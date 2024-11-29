// HackerRank Question: https://www.hackerrank.com/challenges/hackerrank-tweets/problem

package solutions.regex.HackerRank_Tweets;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    int count = 0;

    // Regex pattern for matching "hackerrank" case insensitive
    String regex = "(?i).*hackerrank.*";

    for (int i = 0; i < n; i++) {
      String tweet = scanner.nextLine();
      if (tweet.matches(regex)) {
        count++;
      }
    }

    System.out.println(count);

    scanner.close();
  }
}
