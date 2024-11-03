// HackerRank Question: https://www.hackerrank.com/challenges/reduced-string/problem

package solutions.algorithms.Super_Reduced_String;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'superReducedString' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String superReducedString(String s) {
    // Stack to store characters for processing
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      // If stack is not empty and the top of the stack is the same as the current character, pop
      // the stack
      if (!stack.isEmpty() && stack.peek() == c) {
        stack.pop();
      } else {
        // Otherwise, push the current character onto the stack
        stack.push(c);
      }
    }

    // If the stack is empty, return "Empty String"
    if (stack.isEmpty()) {
      return "Empty String";
    }

    // Otherwise, build the reduced string from the characters in the stack
    StringBuilder reducedString = new StringBuilder();
    for (char c : stack) {
      reducedString.append(c);
    }

    return reducedString.toString();
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.superReducedString(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
