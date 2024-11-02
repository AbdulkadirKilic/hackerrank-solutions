// HackerRank Question: https://www.hackerrank.com/challenges/larrys-array/problem

package solutions.algorithms.Larrys_Array;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'larrysArray' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY A as parameter.
   */

  public static String larrysArray(List<Integer> A) {
    int inversions = 0;
    int n = A.size();

    // Calculate inversions in the array
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (A.get(i) > A.get(j)) {
          inversions++;
        }
      }
    }

    // If inversions are even, return "YES", otherwise return "NO"
    return (inversions % 2 == 0) ? "YES" : "NO";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> A =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.larrysArray(A);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
