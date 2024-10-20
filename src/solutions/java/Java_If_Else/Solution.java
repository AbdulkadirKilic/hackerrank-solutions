// HackerRank Question: https://www.hackerrank.com/challenges/java-if-else/problem

package solutions.java.Java_If_Else;

import java.util.*;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int N = scanner.nextInt();
    scanner.close();

    if (N % 2 != 0) {

      System.out.println("Weird");
    } else {

      if (N >= 2 && N <= 5) {
        System.out.println("Not Weird");
      } else if (N >= 6 && N <= 20) {
        System.out.println("Weird");
      } else if (N > 20) {
        System.out.println("Not Weird");
      }
    }
  }
}
