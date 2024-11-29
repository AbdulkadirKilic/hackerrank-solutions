// HackerRank Question: https://www.hackerrank.com/challenges/ip-address-validation/problem

package solutions.regex.IP_Address_Validation;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    String ipv4Pattern = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])(\\.|$)){4}$";
    String ipv6Pattern = "^(([0-9a-fA-F]{1,4})(:|$)){8}$";

    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine().trim();

      if (line.matches(ipv4Pattern)) {
        System.out.println("IPv4");
      } else if (line.matches(ipv6Pattern)) {
        System.out.println("IPv6");
      } else {
        System.out.println("Neither");
      }
    }

    scanner.close();
  }
}
