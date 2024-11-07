// HackerRank Question: https://www.hackerrank.com/challenges/bear-and-steady-gene/problem

package solutions.algorithms.Bear_and_Steady_Gene;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'steadyGene' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING gene as parameter.
   */

  public static int steadyGene(String gene) {
    int n = gene.length();
    int target = n / 4;

    // Frequency map to count occurrences of each nucleotide
    Map<Character, Integer> count = new HashMap<>();
    for (char c : gene.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }

    // Check if already steady
    if (count.getOrDefault('A', 0) <= target
        && count.getOrDefault('C', 0) <= target
        && count.getOrDefault('T', 0) <= target
        && count.getOrDefault('G', 0) <= target) {
      return 0;
    }

    int minLength = n;
    int left = 0;

    // Sliding window with right pointer expanding
    for (int right = 0; right < n; right++) {
      count.put(gene.charAt(right), count.get(gene.charAt(right)) - 1);

      // Shrink the window if condition met
      while (count.getOrDefault('A', 0) <= target
          && count.getOrDefault('C', 0) <= target
          && count.getOrDefault('T', 0) <= target
          && count.getOrDefault('G', 0) <= target) {
        minLength = Math.min(minLength, right - left + 1);

        // Move left pointer
        count.put(gene.charAt(left), count.get(gene.charAt(left)) + 1);
        left++;
      }
    }

    return minLength;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String gene = bufferedReader.readLine();

    int result = Result.steadyGene(gene);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
