// HackerRank Question: https://www.hackerrank.com/challenges/excluding-specific-characters/problem

package solutions.regex.Excluding_Specific_Characters;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Regex_Test tester = new Regex_Test();
    tester.checker("^[^0-9][^aeiou][^bcdf][^\\s][^AEIOU][^.,]$");
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
