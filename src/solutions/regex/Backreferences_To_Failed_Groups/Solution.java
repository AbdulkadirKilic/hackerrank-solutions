// HackerRank Question:
// https://www.hackerrank.com/challenges/backreferences-to-failed-groups/problem

package solutions.regex.Backreferences_To_Failed_Groups;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Regex_Test tester = new Regex_Test();
    tester.checker("^(\\d{2}-){3}\\d{2}$|^\\d{8}$");
  }
}

class Regex_Test {

  public void checker(String Regex_Pattern) {

    Scanner Input = new Scanner(System.in);
    String Test_String = Input.nextLine();
    Pattern p = Pattern.compile(Regex_Pattern);
    Matcher m = p.matcher(Test_String);
    System.out.println(m.find());
  }
}
