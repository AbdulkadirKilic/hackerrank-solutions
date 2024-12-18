// HackerRank Question: https://www.hackerrank.com/challenges/diagonal-difference/problem

package solutions.algorithms.Diagonal_Difference;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'diagonalDifference' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */

  public static int diagonalDifference(List<List<Integer>> arr) {
    int primaryDiagonalSum = 0;
    int secondaryDiagonalSum = 0;
    int n = arr.size();

    for (int i = 0; i < n; i++) {
      primaryDiagonalSum += arr.get(i).get(i); // Primary diagonal element
      secondaryDiagonalSum += arr.get(i).get(n - i - 1); // Secondary diagonal element
    }

    // Calculate the absolute difference
    return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> arr = new ArrayList<>();

    IntStream.range(0, n)
        .forEach(
            i -> {
              try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    int result = Result.diagonalDifference(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
