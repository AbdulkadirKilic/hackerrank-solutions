// HackerRank Question: https://www.hackerrank.com/challenges/java-bitset/problem

package solutions.java.Java_BitSet;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int m = scanner.nextInt();

    BitSet B1 = new BitSet(n);
    BitSet B2 = new BitSet(n);

    for (int i = 0; i < m; i++) {
      String operation = scanner.next();
      int arg1 = scanner.nextInt();
      int arg2 = scanner.hasNextInt() ? scanner.nextInt() : -1;
      switch (operation) {
        case "AND":
          if (arg1 == 1) {
            B1.and(B2);
          } else {
            B2.and(B1);
          }
          break;

        case "OR":
          if (arg1 == 1) {
            B1.or(B2);
          } else {
            B2.or(B1);
          }
          break;

        case "XOR":
          if (arg1 == 1) {
            B1.xor(B2);
          } else {
            B2.xor(B1);
          }
          break;

        case "FLIP":
          if (arg1 == 1) {
            B1.flip(arg2);
          } else {
            B2.flip(arg2);
          }
          break;

        case "SET":
          if (arg1 == 1) {
            B1.set(arg2);
          } else {
            B2.set(arg2);
          }
          break;
      }

      System.out.println(B1.cardinality() + " " + B2.cardinality());
    }

    scanner.close();
  }
}
