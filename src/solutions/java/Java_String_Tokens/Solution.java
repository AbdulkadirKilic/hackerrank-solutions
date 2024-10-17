// HackerRank Question: https://www.hackerrank.com/challenges/java-string-tokens/problem

package solutions.java.Java_String_Tokens;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();
    scan.close();

    String[] tokens = s.trim().split("[^A-Za-z]+");

    if (tokens.length == 1 && tokens[0].isEmpty()) {
      System.out.println(0);
    } else {
      System.out.println(tokens.length);
      for (String token : tokens) {
        if (!token.isEmpty()) {
          System.out.println(token);
        }
      }
    }
  }
}
