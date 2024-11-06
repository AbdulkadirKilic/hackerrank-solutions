// HackerRank Question: https://www.hackerrank.com/challenges/making-anagrams/problem

package solutions.algorithms.Making_Anagrams;

import java.io.*;

class Result {

  /*
   * Complete the 'makingAnagrams' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. STRING s1
   *  2. STRING s2
   */

  public static int makingAnagrams(String s1, String s2) {
    // Array to store character counts for each string
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];

    // Fill frequency array for s1
    for (char c : s1.toCharArray()) {
      freq1[c - 'a']++;
    }

    // Fill frequency array for s2
    for (char c : s2.toCharArray()) {
      freq2[c - 'a']++;
    }

    // Calculate total deletions needed
    int deletions = 0;
    for (int i = 0; i < 26; i++) {
      deletions += Math.abs(freq1[i] - freq2[i]);
    }

    return deletions;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s1 = bufferedReader.readLine();

    String s2 = bufferedReader.readLine();

    int result = Result.makingAnagrams(s1, s2);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
