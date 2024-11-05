// HackerRank Question: https://www.hackerrank.com/challenges/weighted-uniform-string/problem

package solutions.algorithms.Weighted_Uniform_Strings;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'weightedUniformStrings' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER_ARRAY queries
   */

  public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
    Set<Integer> weightsSet = new HashSet<>();
    char prevChar = '\0';
    int currentWeight = 0;

    // Traverse the string to calculate uniform substring weights
    for (char ch : s.toCharArray()) {
      int charWeight = ch - 'a' + 1;
      if (ch == prevChar) {
        currentWeight += charWeight; // Consecutive same character
      } else {
        currentWeight = charWeight; // New character
        prevChar = ch;
      }
      weightsSet.add(currentWeight); // Store the weight
    }

    // Prepare results for each query
    List<String> result = new ArrayList<>();
    for (int query : queries) {
      result.add(weightsSet.contains(query) ? "Yes" : "No");
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

    int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> queries =
        IntStream.range(0, queriesCount)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    List<String> result = Result.weightedUniformStrings(s, queries);

    bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
