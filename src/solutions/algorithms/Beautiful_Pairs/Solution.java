// HackerRank Question: https://www.hackerrank.com/challenges/beautiful-pairs/problem

package solutions.algorithms.Beautiful_Pairs;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'beautifulPairs' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY A
   *  2. INTEGER_ARRAY B
   */

  public static int beautifulPairs(List<Integer> A, List<Integer> B) {
    // Count the occurrences of each number in A and B
    Map<Integer, Integer> countA = new HashMap<>();
    Map<Integer, Integer> countB = new HashMap<>();

    // Fill counts for A
    for (int num : A) {
      countA.put(num, countA.getOrDefault(num, 0) + 1);
    }

    // Fill counts for B
    for (int num : B) {
      countB.put(num, countB.getOrDefault(num, 0) + 1);
    }

    int beautifulPairsCount = 0;

    // Calculate initial beautiful pairs based on minimum frequency in A and B
    for (int num : countA.keySet()) {
      if (countB.containsKey(num)) {
        beautifulPairsCount += Math.min(countA.get(num), countB.get(num));
      }
    }

    // If beautiful pairs are equal to the size of A, reduce by 1 as one change is mandatory
    if (beautifulPairsCount == A.size()) {
      return beautifulPairsCount - 1;
    }

    // Otherwise, we can increase the count by 1 by changing one element in A
    return beautifulPairsCount + 1;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> A =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> B =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.beautifulPairs(A, B);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
