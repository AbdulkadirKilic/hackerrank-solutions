// HackerRank Question: https://www.hackerrank.com/challenges/crush/problem

package solutions.data_structures.Array_Manipulation;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'arrayManipulation' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY queries
   */

  public static long arrayManipulation(int n, List<List<Integer>> queries) {
    long[] arr = new long[n + 1]; // Initialize an array of size n+1

    // Apply the difference array approach for each query
    for (List<Integer> query : queries) {
      int a = query.get(0) - 1; // zero-indexed for easier manipulation
      int b = query.get(1) - 1;
      int k = query.get(2);

      arr[a] += k; // Start adding k from index a
      if (b + 1 < n) arr[b + 1] -= k; // Subtract k just after index b
    }

    // Calculate the prefix sum and find the maximum value
    long max = 0;
    long current = 0;
    for (int i = 0; i < n; i++) {
      current += arr[i];
      max = Math.max(max, current);
    }

    return max;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, m)
        .forEach(
            i -> {
              try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    long result = Result.arrayManipulation(n, queries);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
