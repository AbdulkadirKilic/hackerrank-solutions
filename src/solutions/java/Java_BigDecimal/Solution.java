// HackerRank Question: https://www.hackerrank.com/challenges/java-bigdecimal/problem

package solutions.java.Java_BigDecimal;

import java.math.BigDecimal;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] s = new String[n + 2];
    for (int i = 0; i < n; i++) {
      s[i] = sc.next();
    }
    sc.close();

    Arrays.sort(s, 0, n, (a, b) -> new BigDecimal(b).compareTo(new BigDecimal(a)));

    for (int i = 0; i < n; i++) {
      System.out.println(s[i]);
    }
  }
}
