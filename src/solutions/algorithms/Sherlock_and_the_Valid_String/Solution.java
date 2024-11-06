// HackerRank Question: https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

package solutions.algorithms.Sherlock_and_the_Valid_String;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'isValid' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String isValid(String s) {
    // Step 1: Calculate the frequency of each character in the string
    Map<Character, Integer> frequencyMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
    }

    // Step 2: Calculate the frequency of the frequencies
    Map<Integer, Integer> freqOfFreqMap = new HashMap<>();
    for (int freq : frequencyMap.values()) {
      freqOfFreqMap.put(freq, freqOfFreqMap.getOrDefault(freq, 0) + 1);
    }

    // Step 3: Determine validity based on the frequency of frequencies
    if (freqOfFreqMap.size() == 1) {
      // All characters have the same frequency
      return "YES";
    } else if (freqOfFreqMap.size() == 2) {
      // Only two different frequencies
      List<Integer> keys = new ArrayList<>(freqOfFreqMap.keySet());
      int freq1 = keys.get(0);
      int freq2 = keys.get(1);
      int count1 = freqOfFreqMap.get(freq1);
      int count2 = freqOfFreqMap.get(freq2);

      // Check the two cases that make the string valid
      if ((count1 == 1 && (freq1 == 1 || freq1 - freq2 == 1))
          || (count2 == 1 && (freq2 == 1 || freq2 - freq1 == 1))) {
        return "YES";
      }
    }

    // If none of the valid conditions are met
    return "NO";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.isValid(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
