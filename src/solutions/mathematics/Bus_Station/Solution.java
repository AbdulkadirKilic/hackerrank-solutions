// HackerRank Question: https://www.hackerrank.com/challenges/bus-station/problem

package solutions.mathematics.Bus_Station;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static List<Integer> solve(List<Integer> a) {
    List<Integer> result = new ArrayList<>();
    int totalSum = 0;

    // Calculate the total number of people
    for (int num : a) {
      totalSum += num;
    }

    // Check all divisors of totalSum
    for (int x = 1; x <= totalSum; x++) {
      if (totalSum % x != 0) continue; // x must divide totalSum

      int currentSum = 0;
      boolean valid = true;

      // Simulate groups boarding the bus
      for (int num : a) {
        currentSum += num;
        if (currentSum > x) {
          valid = false; // Bus capacity exceeded
          break;
        } else if (currentSum == x) {
          currentSum = 0; // Bus trip completed
        }
      }

      // If valid configuration, add x to the result
      if (valid && currentSum == 0) {
        result.add(x);
      }
    }

    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int aCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.solve(a);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
