// HackerRank Question: https://www.hackerrank.com/challenges/primitive-problem/problem

package solutions.mathematics.Primitive_Problem;

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int p = Integer.parseInt(bufferedReader.readLine().trim());
    bufferedReader.close();

    // Step 1: Find all prime factors of (p - 1)
    int phi = p - 1;
    List<Integer> factors = findPrimeFactors(phi);

    // Step 2: Find the smallest primitive root
    int smallestPrimitiveRoot = -1;
    for (int g = 2; g < p; g++) {
      if (isPrimitiveRoot(g, p, phi, factors)) {
        smallestPrimitiveRoot = g;
        break;
      }
    }

    // Step 3: Count total primitive roots
    int totalPrimitiveRoots = phiTotient(phi);

    System.out.println(smallestPrimitiveRoot + " " + totalPrimitiveRoots);
  }

  // Function to check if g is a primitive root of p
  private static boolean isPrimitiveRoot(int g, int p, int phi, List<Integer> factors) {
    for (int factor : factors) {
      // Compute g^(phi / factor) % p
      if (modularExponentiation(g, phi / factor, p) == 1) {
        return false; // Not a primitive root
      }
    }
    return true; // Passed all tests, g is a primitive root
  }

  // Function to compute modular exponentiation: (base^exp) % mod
  private static int modularExponentiation(int base, int exp, int mod) {
    long result = 1;
    long baseMod = base % mod;
    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = (result * baseMod) % mod;
      }
      baseMod = (baseMod * baseMod) % mod;
      exp >>= 1; // Divide exp by 2
    }
    return (int) result;
  }

  // Function to find all prime factors of n
  private static List<Integer> findPrimeFactors(int n) {
    List<Integer> factors = new ArrayList<>();
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        factors.add(i);
        while (n % i == 0) {
          n /= i;
        }
      }
    }
    if (n > 1) {
      factors.add(n);
    }
    return factors;
  }

  // Function to calculate the Euler's Totient function for n
  private static int phiTotient(int n) {
    int result = n;
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        while (n % i == 0) {
          n /= i;
        }
        result -= result / i;
      }
    }
    if (n > 1) {
      result -= result / n;
    }
    return result;
  }
}
