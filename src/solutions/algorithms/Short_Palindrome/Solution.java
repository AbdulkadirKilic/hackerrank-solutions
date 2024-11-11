// HackerRank Question: https://www.hackerrank.com/challenges/short-palindrome/problem

package solutions.algorithms.Short_Palindrome;

import java.io.*;

class Result {

  /*
   * Complete the 'shortPalindrome' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  private static final int MOD = 1000000007;

  public static int shortPalindrome(String s) {
    int[] countSingle = new int[26]; // Counts of single letters
    int[][] countPair = new int[26][26]; // Counts of letter pairs
    int[] countTriple = new int[26]; // Counts of triplets ending with specific letters
    int countQuadruple = 0; // Counts of quadruples (valid palindromic tuples)

    for (char ch : s.toCharArray()) {
      int index = ch - 'a';

      // Add to quadruple count, as all triples ending with the current letter can form valid
      // palindromes
      countQuadruple = (countQuadruple + countTriple[index]) % MOD;

      // Update triple counts for all pairs that can extend to the current letter
      for (int i = 0; i < 26; i++) {
        countTriple[i] = (countTriple[i] + countPair[i][index]) % MOD;
      }

      // Update pair counts with the current letter
      for (int i = 0; i < 26; i++) {
        countPair[i][index] = (countPair[i][index] + countSingle[i]) % MOD;
      }

      // Increment single letter count for the current letter
      countSingle[index] = (countSingle[index] + 1) % MOD;
    }

    return countQuadruple;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    int result = Result.shortPalindrome(s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
