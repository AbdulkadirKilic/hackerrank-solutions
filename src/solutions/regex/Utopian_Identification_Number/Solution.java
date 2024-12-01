// HackerRank Question: https://www.hackerrank.com/challenges/utopian-identification-number/problem

package solutions.regex.Utopian_Identification_Number;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    // Regular expression to validate the identification number
    String regex = "^[a-z]{0,3}\\d{2,8}[A-Z]{3,}$";

    for (int i = 0; i < n; i++) {
      String input = scanner.nextLine(); // Read each identification number
      if (input.matches(regex)) {
        System.out.println("VALID"); // Print VALID if it matches the regex
      } else {
        System.out.println("INVALID"); // Print INVALID otherwise
      }
    }

    scanner.close();
  }
}
