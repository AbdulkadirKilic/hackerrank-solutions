// HackerRank Question: https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

package solutions.algorithms.Sherlock_and_Anagrams;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'sherlockAndAnagrams' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int sherlockAndAnagrams(String s) {
    // Map to store frequency of sorted substring patterns
    Map<String, Integer> map = new HashMap<>();

    // Generate all possible substrings
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        String substring = s.substring(i, j);

        // Sort the substring to identify anagrammatic patterns
        char[] chars = substring.toCharArray();
        Arrays.sort(chars);
        String sortedSubstring = new String(chars);

        // Increment the count of the sorted substring in the map
        map.put(sortedSubstring, map.getOrDefault(sortedSubstring, 0) + 1);
      }
    }

    int anagramPairs = 0;

    // Calculate number of anagrammatic pairs from frequencies
    for (int freq : map.values()) {
      if (freq > 1) {
        anagramPairs += freq * (freq - 1) / 2;
      }
    }

    return anagramPairs;
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

                int result = Result.sherlockAndAnagrams(s);

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
