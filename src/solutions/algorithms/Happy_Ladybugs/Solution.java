// HackerRank Question: https://www.hackerrank.com/challenges/happy-ladybugs/problem

package solutions.algorithms.Happy_Ladybugs;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'happyLadybugs' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING b as parameter.
   */

  public static String happyLadybugs(String b) {
    // Check if the board has any empty cell
    boolean hasEmptyCell = b.contains("_");

    // If there are no empty cells, check the current arrangement
    if (!hasEmptyCell) {
      // Check if all ladybugs are happy in the current arrangement
      for (int i = 0; i < b.length(); i++) {
        // Check if a ladybug is unhappy (no same color neighbor)
        if ((i == 0 || b.charAt(i) != b.charAt(i - 1))
            && (i == b.length() - 1 || b.charAt(i) != b.charAt(i + 1))) {
          return "NO"; // Return NO if any ladybug is unhappy
        }
      }
      return "YES";
    }

    // If there are empty cells, check if all ladybugs have pairs
    Map<Character, Integer> frequencyMap = new HashMap<>();
    for (char ch : b.toCharArray()) {
      if (ch != '_') {
        frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
      }
    }

    // Check if any ladybug has only one occurrence
    for (int count : frequencyMap.values()) {
      if (count == 1) {
        return "NO";
      }
    }

    return "YES";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int g = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, g)
        .forEach(
            gItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

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
