// HackerRank Question: https://www.hackerrank.com/challenges/matching-word-non-word/problem

package solutions.regex.Matching_Word_and_Non_Word_Character;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Regex_Test tester = new Regex_Test();
    tester.checker(
        "^(http:\\/\\/www\\.\\w+\\.\\w+)(\\.http:\\/\\/www\\.\\w+\\.\\w+)*$|^\\w{3}\\W\\w{10}\\W\\w{3}$");
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
