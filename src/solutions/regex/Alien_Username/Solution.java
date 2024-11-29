// HackerRank Question: https://www.hackerrank.com/challenges/alien-username/problem

package solutions.regex.Alien_Username;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    String regex = "^[_.][0-9]+[a-zA-Z]*_?$";

    Pattern pattern = Pattern.compile(regex);

    for (int i = 0; i < n; i++) {
      String username = scanner.nextLine();
      Matcher matcher = pattern.matcher(username);

      if (matcher.matches()) {
        System.out.println("VALID");
      } else {
        System.out.println("INVALID");
      }
    }

    scanner.close();
  }
}
