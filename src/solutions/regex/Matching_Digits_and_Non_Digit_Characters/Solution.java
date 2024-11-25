// HackerRank Question:
// https://www.hackerrank.com/challenges/matching-digits-non-digit-character/problem

package solutions.regex.Matching_Digits_and_Non_Digit_Characters;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Regex_Test tester = new Regex_Test();
    tester.checker("^\\d\\d\\D\\d\\d(\\.\\d{6,}|-\\d{4})$");
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
