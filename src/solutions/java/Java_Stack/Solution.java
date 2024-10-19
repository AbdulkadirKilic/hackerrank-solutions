// HackerRank Question: https://www.hackerrank.com/challenges/java-stack/problem

package solutions.java.Java_Stack;

import java.util.*;

class Solution {

  public static boolean isBalanced(String input) {
    Stack<Character> stack = new Stack<>();

    for (char ch : input.toCharArray()) {

      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
      } else if (ch == ')' || ch == '}' || ch == ']') {
        if (stack.isEmpty()) {
          return false;
        }
        char top = stack.pop();
        if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      String input = sc.next();

      System.out.println(isBalanced(input));
    }

    sc.close();
  }
}
