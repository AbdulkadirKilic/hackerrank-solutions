// HackerRank Question: https://www.hackerrank.com/challenges/identify-smith-numbers/problem

package solutions.mathematics.Identify_Smith_Numbers;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  public static int solve(int n) {
    // Step 1: Check if the number is composite
    if (n <= 1 || isPrime(n)) {
      return 0; // Not a Smith number
    }

    // Step 2: Calculate the sum of the digits of n
    int sumOfDigits = sumOfDigits(n);

    // Step 3: Find the prime factors of n and calculate the sum of their digits
    List<Integer> primeFactors = findPrimeFactors(n);
    int sumOfPrimeFactorDigits = 0;
    for (int factor : primeFactors) {
      sumOfPrimeFactorDigits += sumOfDigits(factor);
    }

    // Step 4: Compare the two sums
    return sumOfDigits == sumOfPrimeFactorDigits ? 1 : 0;
  }

  // Function to check if a number is prime
  private static boolean isPrime(int num) {
    if (num <= 1) return false;
    if (num <= 3) return true; // 2 and 3 are prime
    if (num % 2 == 0 || num % 3 == 0) return false;
    for (int i = 5; i * i <= num; i += 6) {
      if (num % i == 0 || num % (i + 2) == 0) return false;
    }
    return true;
  }

  // Function to calculate the sum of the digits of a number
  private static int sumOfDigits(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }

  // Function to find all prime factors of a number
  private static List<Integer> findPrimeFactors(int num) {
    List<Integer> factors = new ArrayList<>();
    for (int i = 2; i * i <= num; i++) {
      while (num % i == 0) {
        factors.add(i);
        num /= i;
      }
    }
    if (num > 1) {
      factors.add(num); // Add the remaining prime factor
    }
    return factors;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int result = Result.solve(n);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
