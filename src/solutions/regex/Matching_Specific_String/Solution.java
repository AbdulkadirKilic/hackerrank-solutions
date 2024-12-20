// HackerRank Question: https://www.hackerrank.com/challenges/matching-specific-string/problem

package solutions.regex.Matching_Specific_String;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Regex_Test tester = new Regex_Test();
    tester.checker("hackerrank");
  }
}

class Regex_Test {

  public void checker(String Regex_Pattern) {

    Scanner Input = new Scanner(System.in);
    String Test_String = Input.nextLine();
    Pattern p = Pattern.compile(Regex_Pattern);
    Matcher m = p.matcher(Test_String);
    int Count = 0;
    while (m.find()) {
      Count += 1;
    }
    System.out.format("Number of matches : %d", Count);
  }
}
