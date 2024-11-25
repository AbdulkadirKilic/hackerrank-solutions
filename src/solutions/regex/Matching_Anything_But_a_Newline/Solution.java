// HackerRank Question: https://www.hackerrank.com/challenges/matching-anything-but-new-line/problem

package solutions.regex.Matching_Anything_But_a_Newline;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Tester tester = new Tester();
    tester.check("^...\\....\\....\\....$");
  }
}

class Tester {

  public void check(String pattern) {

    Scanner scanner = new Scanner(System.in);
    String testString = scanner.nextLine();
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(testString);
    boolean match = m.matches();

    System.out.format("%s", match);
  }
}
