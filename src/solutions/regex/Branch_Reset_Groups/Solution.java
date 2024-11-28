// HackerRank Question: https://www.hackerrank.com/challenges/branch-reset-groups/problem

package solutions.regex.Branch_Reset_Groups;

import java.util.Scanner;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    String regexPattern = "^(\\d{2})(-|-{3}|\\.|:{1,3})\\d{2}\\2\\d{2}\\2\\d{2}$";

    Pattern pattern = Pattern.compile(regexPattern);
    Matcher matcher = pattern.matcher(input);

    System.out.println(matcher.matches());
  }
}
