// HackerRank Question: https://www.hackerrank.com/challenges/java-biginteger/problem

package solutions.java.Java_BigInteger;

import java.math.BigInteger;
import java.util.*;

public class Solution {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    String num1 = scan.nextLine();
    String num2 = scan.nextLine();

    BigInteger bigInt1 = new BigInteger(num1);
    BigInteger bigInt2 = new BigInteger(num2);

    BigInteger sum = bigInt1.add(bigInt2);
    BigInteger product = bigInt1.multiply(bigInt2);

    System.out.println(sum);
    System.out.println(product);

    scan.close();
  }
}
