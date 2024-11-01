// HackerRank Question: https://www.hackerrank.com/challenges/bigger-is-greater/problem

package solutions.algorithms.Bigger_is_Greater;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'biggerIsGreater' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING w as parameter.
   */

  public static String biggerIsGreater(String w) {
    char[] chars = w.toCharArray();
    int i = chars.length - 2;

    // Step 1: Find the rightmost character which is smaller than its next character
    while (i >= 0 && chars[i] >= chars[i + 1]) {
      i--;
    }

    // If no such character is found, then we have the largest lexicographical permutation
    if (i == -1) {
      return "no answer";
    }

    // Step 2: Find the rightmost character which is greater than chars[i]
    int j = chars.length - 1;
    while (chars[j] <= chars[i]) {
      j--;
    }

    // Step 3: Swap characters at i and j
    swap(chars, i, j);

    // Step 4: Reverse the sequence from i + 1 to the end
    reverse(chars, i + 1, chars.length - 1);

    return new String(chars);
  }

  // Helper method to swap characters in an array
  private static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

  // Helper method to reverse characters in an array from start to end
  private static void reverse(char[] chars, int start, int end) {
    while (start < end) {
      swap(chars, start, end);
      start++;
      end--;
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int T = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, T)
        .forEach(
            TItr -> {
              try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

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
