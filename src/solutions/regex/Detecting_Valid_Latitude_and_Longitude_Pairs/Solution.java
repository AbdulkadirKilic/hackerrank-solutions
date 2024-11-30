// HackerRank Question:
// https://www.hackerrank.com/challenges/detecting-valid-latitude-and-longitude/problem

package solutions.regex.Detecting_Valid_Latitude_and_Longitude_Pairs;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    String regex =
        "^\\(([-+]?(?:90(?:\\.0+)?|[1-8]?\\d(?:\\.\\d+)?)), ([-+]?(?:180(?:\\.0+)?|1[0-7]\\d(?:\\.\\d+)?|[0-9]{1,2}(?:\\.\\d+)?))\\)$";

    for (int i = 0; i < n; i++) {
      String input = scanner.nextLine();
      if (input.matches(regex)) {
        System.out.println("Valid");
      } else {
        System.out.println("Invalid");
      }
    }

    scanner.close();
  }
}
