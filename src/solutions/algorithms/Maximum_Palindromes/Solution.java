// HackerRank Question: https://www.hackerrank.com/challenges/maximum-palindromes/problem

package solutions.algorithms.Maximum_Palindromes;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'initialize' function below.
   *
   * The function accepts STRING s as parameter.
   */

  static final int MOD = 1000000007;
  static int[] factorial, inverseFactorial;
  static int[][] prefixFrequency;

  // Precompute factorials and their inverses up to a maximum limit
  private static void precomputeFactorials(int max) {
    factorial = new int[max + 1];
    inverseFactorial = new int[max + 1];

    factorial[0] = factorial[1] = 1;
    for (int i = 2; i <= max; i++) {
      factorial[i] = (int) ((long) factorial[i - 1] * i % MOD);
    }

    inverseFactorial[max] = modInverse(factorial[max]);
    for (int i = max - 1; i >= 0; i--) {
      inverseFactorial[i] = (int) ((long) inverseFactorial[i + 1] * (i + 1) % MOD);
    }
  }

  // Helper function to calculate modular inverse
  private static int modInverse(int x) {
    return modPower(x, MOD - 2);
  }

  // Modular exponentiation
  private static int modPower(int base, int exp) {
    int result = 1;
    while (exp > 0) {
      if ((exp & 1) != 0) result = (int) ((long) result * base % MOD);
      base = (int) ((long) base * base % MOD);
      exp >>= 1;
    }
    return result;
  }

  // Initialization of precomputed data structures
  public static void initialize(String s) {
    int n = s.length();
    precomputeFactorials(n);

    // Initialize prefix frequency for 26 lowercase letters
    prefixFrequency = new int[n + 1][26];
    for (int i = 0; i < n; i++) {
      int charIndex = s.charAt(i) - 'a';
      for (int j = 0; j < 26; j++) {
        prefixFrequency[i + 1][j] = prefixFrequency[i][j];
      }
      prefixFrequency[i + 1][charIndex]++;
    }
  }

  public static int answerQuery(int l, int r) {
    // Convert 1-based indexing to 0-based for our arrays
    l--;
    r--;

    // Calculate character frequencies in range [l, r]
    int[] freq = new int[26];
    for (int i = 0; i < 26; i++) {
      freq[i] = prefixFrequency[r + 1][i] - prefixFrequency[l][i];
    }

    // Calculate pairs and single middle character
    int pairs = 0, oddCount = 0;
    for (int f : freq) {
      pairs += f / 2;
      if (f % 2 == 1) oddCount++;
    }

    // Calculate palindrome count
    int result = factorial[pairs];
    for (int f : freq) {
      if (f / 2 > 0) {
        result = (int) ((long) result * inverseFactorial[f / 2] % MOD);
      }
    }

    // If there are odd characters, we can place one in the center
    if (oddCount > 0) {
      result = (int) ((long) result * oddCount % MOD);
    }

    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    Result.initialize(s);

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.answerQuery(l, r);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
