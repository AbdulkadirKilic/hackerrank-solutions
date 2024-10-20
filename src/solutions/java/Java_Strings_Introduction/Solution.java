// HackerRank Question: https://www.hackerrank.com/challenges/java-strings-introduction/problem

package solutions.java.Java_Strings_Introduction;

import java.util.*;

public class Solution {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String A = sc.next();
    String B = sc.next();

    int totalLength = A.length() + B.length();
    System.out.println(totalLength);

    if (A.compareTo(B) > 0) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    String capitalizedA = A.substring(0, 1).toUpperCase() + A.substring(1);
    String capitalizedB = B.substring(0, 1).toUpperCase() + B.substring(1);
    System.out.println(capitalizedA + " " + capitalizedB);

    sc.close();
  }
}
