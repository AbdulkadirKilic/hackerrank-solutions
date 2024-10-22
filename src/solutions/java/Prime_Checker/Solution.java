// HackerRank Question: https://www.hackerrank.com/challenges/prime-checker/problem

package solutions.java.Prime_Checker;

class Prime {

  void checkPrime(int... numbers) {
    for (int num : numbers) {
      if (isPrime(num)) {
        System.out.print(num + " ");
      }
    }
    System.out.println();
  }

  private boolean isPrime(int num) {
    if (num <= 1) return false;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
    }
    return true;
  }
}

public class Solution {

  public static void main(String[] args) {
    Prime prime = new Prime();

    prime.checkPrime(2);
    prime.checkPrime(2, 1);
    prime.checkPrime(2, 3);
    prime.checkPrime(2, 3, 4, 5);
  }
}
