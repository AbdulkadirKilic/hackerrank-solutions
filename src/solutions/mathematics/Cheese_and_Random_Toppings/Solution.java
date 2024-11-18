// HackerRank Question: https://www.hackerrank.com/challenges/cheese-and-random-toppings/problem

package solutions.mathematics.Cheese_and_Random_Toppings;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER r
   *  3. INTEGER m
   */

  // Modular inverse using Fermat's Little Theorem (m is prime)
  private static long modInverse(long a, long m) {
    return modPow(a, m - 2, m);
  }

  // Modular exponentiation
  private static long modPow(long base, long exp, long mod) {
    long result = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = (result * base) % mod;
      }
      base = (base * base) % mod;
      exp >>= 1;
    }
    return result;
  }

  // Calculate nCr % p using modular arithmetic
  private static long modCombination(long n, long r, long p) {
    if (r > n) return 0;
    long[] fact = new long[(int) (n + 1)];
    fact[0] = 1;
    for (int i = 1; i <= n; i++) {
      fact[i] = (fact[i - 1] * i) % p;
    }
    long numerator = fact[(int) n];
    long denominator = (fact[(int) r] * fact[(int) (n - r)]) % p;
    return (numerator * modInverse(denominator, p)) % p;
  }

  // Lucas's Theorem for nCr % p
  private static long lucasTheorem(long n, long r, long p) {
    if (r == 0) return 1;
    long ni = n % p;
    long ri = r % p;
    return (lucasTheorem(n / p, r / p, p) * modCombination(ni, ri, p)) % p;
  }

  // Solve function
  public static int solve(int n, int r, int m) {
    List<Integer> primes = primeFactors(m);
    long result = 0;
    long prod = 1;
    List<Long> remainders = new ArrayList<>();
    List<Long> mods = new ArrayList<>();

    // Calculate nCr % p for each prime factor of m
    for (int prime : primes) {
      long modResult = lucasTheorem(n, r, prime);
      remainders.add(modResult);
      mods.add((long) prime);
      prod *= prime;
    }

    // Apply Chinese Remainder Theorem to combine results
    for (int i = 0; i < mods.size(); i++) {
      long pp = prod / mods.get(i);
      result += remainders.get(i) * pp * modInverse(pp, mods.get(i));
      result %= prod;
    }

    return (int) result;
  }

  // Find prime factors of m
  private static List<Integer> primeFactors(int m) {
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i * i <= m; i++) {
      if (m % i == 0) {
        primes.add(i);
        while (m % i == 0) {
          m /= i;
        }
      }
    }
    if (m > 1) {
      primes.add(m);
    }
    return primes;
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

                int r = Integer.parseInt(firstMultipleInput[1]);

                int m = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.solve(n, r, m);

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
