// HackerRank Question: https://www.hackerrank.com/challenges/two-arrays/problem

package solutions.algorithms.Permuting_Two_Arrays;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'twoArrays' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY A
   *  3. INTEGER_ARRAY B
   */

  public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
    // Sort A in ascending order
    Collections.sort(A);

    // Sort B in descending order
    Collections.sort(B, Collections.reverseOrder());

    // Check each pair (A[i], B[i])
    for (int i = 0; i < A.size(); i++) {
      if (A.get(i) + B.get(i) < k) {
        return "NO";
      }
    }

    return "YES";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> A =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> B =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.twoArrays(k, A, B);

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
