// HackerRank Question: https://www.hackerrank.com/challenges/java-primality-test/problem

package solutions.java.Java_Primality_Test;

import java.io.*;
import java.math.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String n = bufferedReader.readLine();
    BigInteger number = new BigInteger(n);

    bufferedReader.close();

    if (number.isProbablePrime(10)) {
      System.out.println("prime");
    } else {
      System.out.println("not prime");
    }
  }
}
