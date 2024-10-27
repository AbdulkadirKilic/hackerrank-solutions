// HackerRank Question: https://www.hackerrank.com/challenges/the-birthday-bar/problem

package solutions.algorithms.Subarray_Division;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'birthday' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY s
   *  2. INTEGER d
   *  3. INTEGER m
   */

  public static int birthday(List<Integer> s, int d, int m) {
    int ways = 0;

    // Iterate through each possible starting point for a segment of length `m`
    for (int i = 0; i <= s.size() - m; i++) {
      int sum = 0;

      // Sum up the segment of length `m`
      for (int j = 0; j < m; j++) {
        sum += s.get(i + j);
      }

      // Check if the segment sum matches Ron's birthday day `d`
      if (sum == d) {
        ways++;
      }
    }

    return ways;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> s =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int d = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    int result = Result.birthday(s, d, m);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
