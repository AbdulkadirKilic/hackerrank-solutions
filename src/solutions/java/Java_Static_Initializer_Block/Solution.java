// HackerRank Question: https://www.hackerrank.com/challenges/java-static-initializer-block/problem

package solutions.java.Java_Static_Initializer_Block;

import java.util.*;

public class Solution {
  static int breadth;
  static int height;
  static boolean flag = true;

  static {
    Scanner scanner = new Scanner(System.in);
    breadth = scanner.nextInt();
    height = scanner.nextInt();

    if (breadth <= 0 || height <= 0) {
      flag = false;
      System.out.println("java.lang.Exception: Breadth and height must be positive");
    }
    scanner.close();
  }

  public static void main(String[] args) {

    if (flag) {
      int area = breadth * height;
      System.out.println(area);
    }
  }
}
