// HackerRank Question: https://www.hackerrank.com/challenges/absolute-permutation/problem

package solutions.algorithms.Absolute_Permutation;

import static java.util.stream.Collectors.joining;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'absolutePermutation' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER k
   */

  public static List<Integer> absolutePermutation(int n, int k) {
    List<Integer> result = new ArrayList<>();

    if (k == 0) {
      // k is 0, so the permutation is simply the natural order from 1 to n
      for (int i = 1; i <= n; i++) {
        result.add(i);
      }
      return result;
    }

    // Check if n is divisible by 2 * k
    if (n % (2 * k) != 0) {
      return Arrays.asList(-1);
    }

    // Construct the permutation
    boolean addK = true;
    for (int i = 1; i <= n; i++) {
      if (addK) {
        result.add(i + k);
      } else {
        result.add(i - k);
      }

      // Toggle addK every k elements
      if (i % k == 0) {
        addK = !addK;
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

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result.absolutePermutation(n, k);

                bufferedWriter.write(
                    result.stream().map(Object::toString).collect(joining(" ")) + "\n");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
