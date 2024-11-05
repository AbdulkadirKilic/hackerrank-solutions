// HackerRank Question: https://www.hackerrank.com/challenges/gem-stones/problem

package solutions.algorithms.Gemstones;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'gemstones' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING_ARRAY arr as parameter.
   */

  public static int gemstones(List<String> arr) {
    // Start with a set of characters from the first rock
    Set<Character> gemstoneSet = new HashSet<>();
    for (char mineral : arr.get(0).toCharArray()) {
      gemstoneSet.add(mineral);
    }

    // Intersect this set with sets from each subsequent rock
    for (int i = 1; i < arr.size(); i++) {
      Set<Character> currentSet = new HashSet<>();
      for (char mineral : arr.get(i).toCharArray()) {
        currentSet.add(mineral);
      }
      gemstoneSet.retainAll(currentSet); // Keep only common minerals
    }

    // The size of gemstoneSet now represents the number of gemstones
    return gemstoneSet.size();
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> arr =
        IntStream.range(0, n)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine();
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .collect(toList());

    int result = Result.gemstones(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
