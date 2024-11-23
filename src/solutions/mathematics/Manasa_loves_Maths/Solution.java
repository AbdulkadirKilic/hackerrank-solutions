// HackerRank Question: https://www.hackerrank.com/challenges/manasa-loves-maths/problem

package solutions.mathematics.Manasa_loves_Maths;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING n as parameter.
   */

  public static String solve(String n) {
    // Check if the number is too small, handle it with brute force
    if (n.length() < 3) {
      List<String> permutations = generatePermutations(n);
      for (String perm : permutations) {
        if (Integer.parseInt(perm) % 8 == 0) {
          return "YES";
        }
      }
      return "NO";
    }

    // Count digits in the number
    int[] digitCount = new int[10];
    for (char digit : n.toCharArray()) {
      digitCount[digit - '0']++;
    }

    // Check for all numbers divisible by 8 up to 999
    for (int i = 0; i < 1000; i += 8) {
      String num = String.format("%03d", i); // Format the number as 3 digits
      int[] requiredCount = new int[10];

      for (char digit : num.toCharArray()) {
        requiredCount[digit - '0']++;
      }

      if (canFormNumber(digitCount, requiredCount)) {
        return "YES";
      }
    }
    return "NO";
  }

  private static List<String> generatePermutations(String s) {
    // Generate all permutations for numbers with fewer than 3 digits
    List<String> result = new ArrayList<>();
    permuteHelper(s.toCharArray(), 0, result);
    return result;
  }

  private static void permuteHelper(char[] chars, int index, List<String> result) {
    if (index == chars.length) {
      result.add(new String(chars));
      return;
    }
    for (int i = index; i < chars.length; i++) {
      swap(chars, i, index);
      permuteHelper(chars, index + 1, result);
      swap(chars, i, index);
    }
  }

  private static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

  private static boolean canFormNumber(int[] digitCount, int[] requiredCount) {
    // Helper function to check if a number can be formed with given digits
    for (int i = 0; i < 10; i++) {
      if (requiredCount[i] > digitCount[i]) {
        return false;
      }
    }
    return true;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                String n = bufferedReader.readLine();

                String result = Result.solve(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
