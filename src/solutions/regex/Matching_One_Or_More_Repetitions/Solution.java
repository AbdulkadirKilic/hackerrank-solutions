// HackerRank Question:
// https://www.hackerrank.com/challenges/matching-one-or-more-repititions/problem

package solutions.regex.Matching_One_Or_More_Repetitions;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Regex_Test tester = new Regex_Test();
    tester.checker("^[0-9]+[A-Z]+[a-z]+$");
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
