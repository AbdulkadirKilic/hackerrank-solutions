// HackerRank Question: https://www.hackerrank.com/challenges/java-md5/problem

package solutions.java.Java_MD5;

import java.security.*;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    sc.close();

    try {

      MessageDigest md = MessageDigest.getInstance("MD5");

      byte[] messageDigest = md.digest(input.getBytes());

      StringBuilder hexString = new StringBuilder();
      for (byte b : messageDigest) {
        String hex = Integer.toHexString(0xff & b);
        if (hex.length() == 1) hexString.append('0');
        hexString.append(hex);
      }

      System.out.println(hexString.toString());

    } catch (NoSuchAlgorithmException e) {

      e.printStackTrace();
    }
  }
}
