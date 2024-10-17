// HackerRank Question: https://www.hackerrank.com/challenges/java-end-of-file/problem

package solutions.java.Java_End_Of_File;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int count = 1;

    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      System.out.println(count + " " + line);
      count++;
    }

    scanner.close();
  }
}
