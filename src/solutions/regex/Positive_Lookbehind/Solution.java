// HackerRank Question: https://www.hackerrank.com/challenges/positive-lookbehind/problem

package solutions.regex.Positive_Lookbehind;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Regex_Test tester = new Regex_Test();
    tester.checker("(?<=[13579])\\d");
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
