// HackerRank Question: https://www.hackerrank.com/challenges/tutorial-intro/problem

package solutions.algorithms.Intro_to_Tutorial_Challenges;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'introTutorial' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER V
   *  2. INTEGER_ARRAY arr
   */

  public static int introTutorial(int V, List<Integer> arr) {
    // Iterate through the list to find the index of V
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) == V) {
        return i; // Return the index once found
      }
    }
    return -1; // Return -1 if V is not found (assuming this never happens based on problem
    // constraints)
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int V = Integer.parseInt(bufferedReader.readLine().trim());

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.introTutorial(V, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
