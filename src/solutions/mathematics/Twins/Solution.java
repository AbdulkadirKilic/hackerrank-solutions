// HackerRank Question: https://www.hackerrank.com/challenges/twins/problem

package solutions.mathematics.Twins;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER m
   */

  public static int solve(int n, int m) {
    // Step 1: Generate all primes up to sqrt(m) using the Sieve of Eratosthenes
    int limit = (int) Math.sqrt(m) + 1;
    boolean[] isPrime = new boolean[limit + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= limit; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= limit; j += i) {
          isPrime[j] = false;
        }
      }
    }

    // Collect all primes up to sqrt(m)
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= limit; i++) {
      if (isPrime[i]) {
        primes.add(i);
      }
    }

    // Step 2: Use segmented sieve to find primes in the range [n, m]
    int range = m - n + 1;
    boolean[] isSegmentPrime = new boolean[range];
    Arrays.fill(isSegmentPrime, true);

    for (int prime : primes) {
      // Find the minimum number in [n, m] that is a multiple of prime
      int start = Math.max(prime * prime, (n + prime - 1) / prime * prime);

      for (int j = start; j <= m; j += prime) {
        isSegmentPrime[j - n] = false;
      }
    }

    // Special case: 1 is not a prime
    if (n == 1) {
      isSegmentPrime[0] = false;
    }

    // Step 3: Count twin primes in the segment
    int twinCount = 0;
    int prevPrime = -1;

    for (int i = 0; i < range; i++) {
      if (isSegmentPrime[i]) {
        int currentPrime = i + n;

        if (prevPrime != -1 && currentPrime - prevPrime == 2) {
          twinCount++;
        }

        prevPrime = currentPrime;
      }
    }

    return twinCount;
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

    int result = Result.solve(n, m);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
