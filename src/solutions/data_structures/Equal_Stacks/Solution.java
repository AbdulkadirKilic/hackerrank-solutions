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
    // Calculate the initial heights of each stack
    int height1 = h1.stream().mapToInt(Integer::intValue).sum();
    int height2 = h2.stream().mapToInt(Integer::intValue).sum();
    int height3 = h3.stream().mapToInt(Integer::intValue).sum();

    // Initialize indices for the top of each stack
    int index1 = 0, index2 = 0, index3 = 0;

    // Adjust heights to find the maximum common height
    while (!(height1 == height2 && height2 == height3)) {
      // Remove from the tallest stack
      if (height1 >= height2 && height1 >= height3) {
        height1 -= h1.get(index1++);
      } else if (height2 >= height1 && height2 >= height3) {
        height2 -= h2.get(index2++);
      } else if (height3 >= height1 && height3 >= height2) {
        height3 -= h3.get(index3++);
      }
    }

    return height1; // height1 == height2 == height3 at this point
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
