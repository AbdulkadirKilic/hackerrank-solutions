// HackerRank Question: https://www.hackerrank.com/challenges/sha-256/problem

package solutions.java.Java_SHA_256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    scanner.close();

    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");

      byte[] hashBytes = md.digest(input.getBytes());

      StringBuilder hexString = new StringBuilder();
      for (byte b : hashBytes) {
        String hex = String.format("%02x", b);
        hexString.append(hex);
      }

      System.out.println(hexString.toString());

    } catch (NoSuchAlgorithmException e) {
      System.out.println("Error: SHA-256 algorithm not found.");
    }
  }
}
