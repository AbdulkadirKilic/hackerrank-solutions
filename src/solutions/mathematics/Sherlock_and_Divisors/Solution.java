// HackerRank Question: https://www.hackerrank.com/challenges/sherlock-and-divisors/problem

package solutions.mathematics.Sherlock_and_Divisors;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'divisors' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  public static int divisors(int n) {
    // If n is odd, it has no even divisors
    if (n % 2 != 0) {
      return 0;
    }

    int count = 0;
    // Check each number up to the square root of n
    for (int i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        // Check if the divisor is even
        if (i % 2 == 0) {
          count++;
        }
        // Check the corresponding pair divisor
        if ((n / i) % 2 == 0 && i != n / i) {
          count++;
        }
      }
    }
    return count;
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

                int result = Result.divisors(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
