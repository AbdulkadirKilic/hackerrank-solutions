// HackerRank Question: https://www.hackerrank.com/challenges/minimum-distances/problem

package solutions.algorithms.Minimum_Distances;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'minimumDistances' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static int minimumDistances(List<Integer> a) {
    Map<Integer, Integer> elementIndexMap = new HashMap<>();
    int minDistance = Integer.MAX_VALUE;

    for (int i = 0; i < a.size(); i++) {
      int element = a.get(i);

      if (elementIndexMap.containsKey(element)) {
        int previousIndex = elementIndexMap.get(element);
        int distance = i - previousIndex;
        minDistance = Math.min(minDistance, distance);
      }

      elementIndexMap.put(element, i);
    }

    return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.minimumDistances(a);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
