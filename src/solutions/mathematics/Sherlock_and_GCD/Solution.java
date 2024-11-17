// HackerRank Question: https://www.hackerrank.com/challenges/sherlock-and-gcd/problem

package solutions.mathematics.Sherlock_and_GCD;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static String solve(List<Integer> a) {
    // Calculate the GCD of all elements in the array
    int gcd = a.get(0); // Start with the first element
    for (int num : a) {
      gcd = gcd(gcd, num); // Update GCD with each element
      if (gcd == 1) {
        return "YES"; // A subset exists if the GCD becomes 1
      }
    }
    return "NO"; // No valid subset if GCD is not 1
  }

  // Helper function to compute the GCD using the Euclidean algorithm
  private static int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
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
                int aCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> a =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.solve(a);

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
