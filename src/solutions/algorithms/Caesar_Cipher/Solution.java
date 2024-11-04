// HackerRank Question: https://www.hackerrank.com/challenges/caesar-cipher-1/problem

package solutions.algorithms.Caesar_Cipher;

import java.io.*;

class Result {

  /*
   * Complete the 'caesarCipher' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER k
   */

  public static String caesarCipher(String s, int k) {
    // Normalize k to ensure it falls within 0-25 range
    k = k % 26;
    StringBuilder result = new StringBuilder();

    // Iterate through each character in the string
    for (char c : s.toCharArray()) {
      if (Character.isLowerCase(c)) {
        // Shift lowercase letters
        char shifted = (char) ('a' + (c - 'a' + k) % 26);
        result.append(shifted);
      } else if (Character.isUpperCase(c)) {
        // Shift uppercase letters
        char shifted = (char) ('A' + (c - 'A' + k) % 26);
        result.append(shifted);
      } else {
        // Append non-alphabetic characters as is
        result.append(c);
      }
    }

    return result.toString();
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String s = bufferedReader.readLine();

    int k = Integer.parseInt(bufferedReader.readLine().trim());

    String result = Result.caesarCipher(s, k);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
