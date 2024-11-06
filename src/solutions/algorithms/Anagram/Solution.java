// HackerRank Question: https://www.hackerrank.com/challenges/anagram/problem

package solutions.algorithms.Anagram;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'anagram' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int anagram(String s) {
    // If the length is odd, it's impossible to split into two equal halves
    if (s.length() % 2 != 0) {
      return -1;
    }

    int mid = s.length() / 2;
    String firstHalf = s.substring(0, mid);
    String secondHalf = s.substring(mid);

    // Frequency array for characters in the alphabet range
    int[] charCount = new int[26];

    // Count characters in the first half
    for (char c : firstHalf.toCharArray()) {
      charCount[c - 'a']++;
    }

    // Subtract count for characters in the second half
    for (char c : secondHalf.toCharArray()) {
      charCount[c - 'a']--;
    }

    // Calculate the total characters that need to be changed in the first half
    int changes = 0;
    for (int count : charCount) {
      if (count > 0) { // Only excess characters in first half matter
        changes += count;
      }
    }

    return changes;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

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
