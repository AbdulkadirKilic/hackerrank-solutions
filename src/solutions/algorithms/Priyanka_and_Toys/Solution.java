// HackerRank Question: https://www.hackerrank.com/challenges/priyanka-and-toys/problem

package solutions.algorithms.Priyanka_and_Toys;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'toys' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY w as parameter.
   */

  public static int toys(List<Integer> w) {
    // Sort weights in ascending order
    Collections.sort(w);

    int containers = 0;
    int i = 0;

    // Traverse through sorted weights
    while (i < w.size()) {
      int minWeight = w.get(i);
      containers++; // Start a new container

      // Move to the next toy that exceeds the current container's weight limit
      while (i < w.size() && w.get(i) <= minWeight + 4) {
        i++;
      }
    }

    return containers;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> w =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.toys(w);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
