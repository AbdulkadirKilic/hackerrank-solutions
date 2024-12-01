// HackerRank Question: https://www.hackerrank.com/challenges/split-number/problem

package solutions.regex.Split_the_Phone_Numbers;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    // Regular expression to capture groups
    String regex = "(\\d{1,3})[\\s-](\\d{1,3})[\\s-](\\d{4,10})";
    Pattern pattern = Pattern.compile(regex);

    for (int i = 0; i < n; i++) {
      String phoneNumber = scanner.nextLine();
      Matcher matcher = pattern.matcher(phoneNumber);

      if (matcher.matches()) {
        String countryCode = matcher.group(1);
        String localAreaCode = matcher.group(2);
        String number = matcher.group(3);

        System.out.println(
            "CountryCode=" + countryCode + ",LocalAreaCode=" + localAreaCode + ",Number=" + number);
      }
    }

    scanner.close();
  }
}
