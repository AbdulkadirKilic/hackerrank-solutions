// HackerRank Question: https://www.hackerrank.com/challenges/leonardo-and-prime/problem

package solutions.mathematics.Leonardos_Prime_Factors;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'primeCount' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts LONG_INTEGER n as parameter.
   */

  public static int primeCount(long n) {
    // Generate prime numbers up to a reasonable limit
    int[] primes = generatePrimesUpTo(100); // We can generate more primes if needed

    int count = 0;
    BigInteger product = BigInteger.ONE;
    BigInteger limit = BigInteger.valueOf(n);

    // Multiply primes until product exceeds n
    for (int prime : primes) {
      BigInteger nextProduct = product.multiply(BigInteger.valueOf(prime));
      if (nextProduct.compareTo(limit) > 0) {
        break;
      }
      product = nextProduct;
      count++;
    }

    return count;
  }

  // Helper function to generate prime numbers up to a limit
  private static int[] generatePrimesUpTo(int limit) {
    List<Integer> primes = new ArrayList<>();
    boolean[] isPrime = new boolean[limit + 1];

    for (int i = 2; i <= limit; i++) {
      isPrime[i] = true;
    }

    for (int p = 2; p * p <= limit; p++) {
      if (isPrime[p]) {
        for (int i = p * p; i <= limit; i += p) {
          isPrime[i] = false;
        }
      }
    }

    for (int i = 2; i <= limit; i++) {
      if (isPrime[i]) {
        primes.add(i);
      }
    }

    return primes.stream().mapToInt(Integer::intValue).toArray();
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
