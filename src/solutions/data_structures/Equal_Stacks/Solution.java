// HackerRank Question: https://www.hackerrank.com/challenges/equal-stacks/problem

package solutions.data_structures.Equal_Stacks;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'equalStacks' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY h1
   *  2. INTEGER_ARRAY h2
   *  3. INTEGER_ARRAY h3
   */

  public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Calculate cumulative heights for each stack in reverse order
    List<Integer> h1Heights = getCumulativeHeights(h1);
    List<Integer> h2Heights = getCumulativeHeights(h2);
    List<Integer> h3Heights = getCumulativeHeights(h3);

    // Convert cumulative heights of h1 to a set
    Set<Integer> h1Set = new HashSet<>(h1Heights);

    // Find common heights by intersecting with h2 and h3
    h1Set.retainAll(h2Heights);
    h1Set.retainAll(h3Heights);

    // Return the maximum of the common heights or 0 if none
    return h1Set.isEmpty() ? 0 : Collections.max(h1Set);
  }

  // Helper method to calculate cumulative heights
  private static List<Integer> getCumulativeHeights(List<Integer> heights) {
    List<Integer> cumulativeHeights = new ArrayList<>();
    int sum = 0;
    for (int i = heights.size() - 1; i >= 0; i--) {
      sum += heights.get(i);
      cumulativeHeights.add(sum);
    }
    return cumulativeHeights;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n1 = Integer.parseInt(firstMultipleInput[0]);

    int n2 = Integer.parseInt(firstMultipleInput[1]);

    int n3 = Integer.parseInt(firstMultipleInput[2]);

    List<Integer> h1 =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> h2 =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> h3 =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.equalStacks(h1, h2, h3);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
