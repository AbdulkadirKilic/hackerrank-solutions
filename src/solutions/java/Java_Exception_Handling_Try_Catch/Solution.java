// HackerRank Question:
// https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem

package solutions.java.Java_Exception_Handling_Try_Catch;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {

      int x = scanner.nextInt();
      int y = scanner.nextInt();

      System.out.println(x / y);
    } catch (InputMismatchException e) {

      System.out.println("java.util.InputMismatchException");
    } catch (ArithmeticException e) {

      System.out.println("java.lang.ArithmeticException: " + e.getMessage());
    } finally {

      scanner.close();
    }
  }
}
