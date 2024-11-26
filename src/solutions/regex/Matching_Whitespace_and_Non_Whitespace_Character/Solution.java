// HackerRank Question:
// https://www.hackerrank.com/challenges/matching-whitespace-non-whitespace-character/problem

package solutions.regex.Matching_Whitespace_and_Non_Whitespace_Character;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Regex_Test tester = new Regex_Test();
    tester.checker("^(?!.*(\\b\\S+\\b)\\s\\1\\s\\1$)\\S+\\s\\S+\\s\\S+$");
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
