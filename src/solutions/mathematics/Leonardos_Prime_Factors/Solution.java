// HackerRank Question: https://www.hackerrank.com/challenges/leonardo-and-prime/problem

package solutions.mathematics.Leonardos_Prime_Factors;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'primeCount' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts LONG_INTEGER n as parameter.
   */

  public static int primeCount(long n) {
    // Array of the first few prime numbers
    int[] primes = {
      2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
    };

    long product = 1;
    int count = 0;

    // Multiply primes sequentially until product exceeds n
    for (int prime : primes) {
      product *= prime;
      if (product > n) {
        break;
      }
      count++;
    }

    return count;
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
                long n = Long.parseLong(bufferedReader.readLine().trim());

                int result = Result.primeCount(n);

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
