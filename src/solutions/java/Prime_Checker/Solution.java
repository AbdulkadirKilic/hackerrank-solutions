// HackerRank Question: https://www.hackerrank.com/challenges/prime-checker/problem

package solutions.java.Prime_Checker;

import java.io.*;

class Prime {
  public void checkPrime(int... numbers) {
    for (int num : numbers) {
      if (isPrime(num)) {
        System.out.print(num + " ");
      }
    }
    System.out.println();
  }

  private boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Prime prime = new Prime();

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());
    int d = Integer.parseInt(br.readLine());
    int e = Integer.parseInt(br.readLine());

    prime.checkPrime(a);
    prime.checkPrime(a, b);
    prime.checkPrime(a, b, c);
    prime.checkPrime(a, b, c, d, e);
  }
}
