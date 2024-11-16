// HackerRank Question: https://www.hackerrank.com/challenges/filling-jars/problem

package solutions.mathematics.Filling_Jars;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY operations
   */

  public static BigInteger solve(int n, List<List<Integer>> operations) {
    long[] diffArray = new long[n + 1]; // Difference array, size n+1 to handle boundary cases

    // Apply all operations
    for (List<Integer> operation : operations) {
      int a = operation.get(0);
      int b = operation.get(1);
      int k = operation.get(2);

      // Update the difference array
      diffArray[a - 1] += k; // Add k at the start index (converted to 0-based index)
      if (b < n) {
        diffArray[b] -= k; // Subtract k at the index after the end
      }
    }

    // Calculate the total sum using the prefix sum of the difference array
    BigInteger totalCandies = BigInteger.ZERO;
    long current = 0;
    for (int i = 0; i < n; i++) {
      current += diffArray[i]; // Calculate the prefix sum
      totalCandies = totalCandies.add(BigInteger.valueOf(current)); // Add to the total candies
    }

    // Calculate the floor of the average
    return totalCandies.divide(BigInteger.valueOf(n));
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> operations = new ArrayList<>();

    IntStream.range(0, m)
        .forEach(
            i -> {
              try {
                operations.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    BigInteger result = Result.solve(n, operations);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
