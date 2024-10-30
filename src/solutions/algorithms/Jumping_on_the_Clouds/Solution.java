// HackerRank Question: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

package solutions.algorithms.Jumping_on_the_Clouds;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'jumpingOnClouds' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY c as parameter.
   */

  public static int jumpingOnClouds(List<Integer> c) {
    int jumps = 0;
    int index = 0;

    while (index < c.size() - 1) {
      // Check if a double jump is possible
      if (index + 2 < c.size() && c.get(index + 2) == 0) {
        index += 2;
      } else {
        index += 1;
      }
      jumps++;
    }

    return jumps;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> c =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.jumpingOnClouds(c);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
