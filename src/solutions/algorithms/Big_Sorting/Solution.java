// HackerRank Question: https://www.hackerrank.com/challenges/big-sorting/problem

package solutions.algorithms.Big_Sorting;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'bigSorting' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY unsorted as parameter.
   */

  public static List<String> bigSorting(List<String> unsorted) {
    // Sort by length first, then lexicographically for strings of the same length
    unsorted.sort(
        (a, b) -> {
          if (a.length() != b.length()) {
            return Integer.compare(a.length(), b.length());
          }
          return a.compareTo(b);
        });
    return unsorted;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> unsorted =
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

    List<String> result = Result.bigSorting(unsorted);

    bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
