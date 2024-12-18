// HackerRank Question: https://www.hackerrank.com/challenges/two-strings/problem

package solutions.algorithms.Two_Strings;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'twoStrings' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING s1
   *  2. STRING s2
   */

  public static String twoStrings(String s1, String s2) {
    // Convert the first string to a set of characters
    Set<Character> charsInS1 = new HashSet<>();
    for (char c : s1.toCharArray()) {
      charsInS1.add(c);
    }

    // Check if any character in s2 exists in the set of characters from s1
    for (char c : s2.toCharArray()) {
      if (charsInS1.contains(c)) {
        return "YES";
      }
    }

    // If no common character was found
    return "NO";
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
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

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
