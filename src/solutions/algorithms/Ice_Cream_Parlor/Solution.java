// HackerRank Question: https://www.hackerrank.com/challenges/icecream-parlor/problem

package solutions.algorithms.Ice_Cream_Parlor;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'icecreamParlor' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER m
   *  2. INTEGER_ARRAY arr
   */

  public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
    Map<Integer, Integer> costIndexMap = new HashMap<>(); // Map to store cost and index

    for (int i = 0; i < arr.size(); i++) {
      int cost = arr.get(i);
      int complement = m - cost;

      // Check if the complement is already in the map
      if (costIndexMap.containsKey(complement)) {
        // Return the 1-based indices of the two flavors
        return Arrays.asList(costIndexMap.get(complement) + 1, i + 1);
      }

      // Add current cost to the map with its index
      costIndexMap.put(cost, i);
    }

    return Collections.emptyList(); // Should never reach here due to unique solution constraint
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.icecreamParlor(m, arr);

                bufferedWriter.write(
                    result.stream().map(Object::toString).collect(joining(" ")) + "\n");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
