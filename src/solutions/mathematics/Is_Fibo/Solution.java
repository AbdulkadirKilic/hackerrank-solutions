// HackerRank Question: https://www.hackerrank.com/challenges/is-fibo/problem

package solutions.mathematics.Is_Fibo;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'isFibo' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts LONG_INTEGER n as parameter.
   */

  // A set to store precomputed Fibonacci numbers up to 10^10
  private static final Set<Long> fibonacciSet = new HashSet<>();

  // Static initializer to populate the Fibonacci set
  static {
    long a = 0;
    long b = 1;
    while (a <= 1_000_000_000_0L) { // Limit to 10^10
      fibonacciSet.add(a);
      long temp = a + b;
      a = b;
      b = temp;
    }
  }

  /*
   * Complete the 'isFibo' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts LONG_INTEGER n as parameter.
   */

  public static String isFibo(long n) {
    // Check if n exists in the precomputed Fibonacci set
    if (fibonacciSet.contains(n)) {
      return "IsFibo";
    } else {
      return "IsNotFibo";
    }
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
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = Result.isFibo(n);

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
