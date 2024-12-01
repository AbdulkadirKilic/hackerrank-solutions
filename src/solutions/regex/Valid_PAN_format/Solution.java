// HackerRank Question: https://www.hackerrank.com/challenges/valid-pan-format/problem

package solutions.regex.Valid_PAN_format;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    // Regular expression to validate PAN format
    String regex = "^[A-Z]{5}\\d{4}[A-Z]$";

    for (int i = 0; i < n; i++) {
      String pan = scanner.nextLine();
      if (pan.matches(regex)) {
        System.out.println("YES"); // If valid PAN, print YES
      } else {
        System.out.println("NO"); // If invalid PAN, print NO
      }
    }

    scanner.close();
  }
}
