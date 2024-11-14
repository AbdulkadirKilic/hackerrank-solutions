// HackerRank Question: https://www.hackerrank.com/challenges/best-divisor/problem

package solutions.mathematics.Best_Divisor;

import java.io.*;

public class Solution {
  // Helper function to calculate the sum of digits of a number
  public static int sumOfDigits(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine().trim());
    bufferedReader.close();

    int bestDivisor = 1;
    int maxDigitSum = 0;

    // Find all divisors and select the best one
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) { // i is a divisor
        int digitSum = sumOfDigits(i); // Sum of digits of the divisor
        // Update the best divisor based on the conditions
        if (digitSum > maxDigitSum || (digitSum == maxDigitSum && i < bestDivisor)) {
          bestDivisor = i;
          maxDigitSum = digitSum;
        }
      }
    }

    System.out.println(bestDivisor);
  }
}
