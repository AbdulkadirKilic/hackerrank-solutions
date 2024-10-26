// HackerRank Question: https://www.hackerrank.com/challenges/jesse-and-cookies/problem

package solutions.data_structures.Jesse_and_Cookies;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'cookies' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY A
   */

  public static int cookies(int k, List<Integer> A) {
    // Initialize a priority queue (min-heap)
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
    int operations = 0;

    // Keep combining the two least sweet cookies until we meet the threshold k
    while (minHeap.size() > 1 && minHeap.peek() < k) {
      // Extract the two least sweet cookies
      int leastSweet = minHeap.poll();
      int secondLeastSweet = minHeap.poll();

      // Combine the two cookies into a new sweetness level
      int newSweetness = leastSweet + 2 * secondLeastSweet;
      minHeap.add(newSweetness);
      operations++;
    }

    // Check if the resulting minimum sweetness meets the threshold
    return minHeap.peek() >= k ? operations : -1;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> A =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.cookies(k, A);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
