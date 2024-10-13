// HackerRank Question: https://www.hackerrank.com/challenges/java-anagrams/problem

package solutions.java.easy.Java_Anagrams;

import java.util.Scanner;

public class Solution {

  static boolean isAnagram(String a, String b) {
    // Convert both strings to lowercase for case-insensitive comparison
    a = a.toLowerCase();
    b = b.toLowerCase();

    // Check if lengths are equal; if not, they cannot be anagrams
    if (a.length() != b.length()) {
      return false;
    }

    // Array to store frequency of each character (26 letters in the alphabet)
    int[] charCount = new int[26];

    // Increment for each character in 'a' and decrement for each in 'b'
    for (int i = 0; i < a.length(); i++) {
      charCount[a.charAt(i) - 'a']++;
      charCount[b.charAt(i) - 'a']--;
    }

    // Check if all counts are zero; if so, 'a' and 'b' are anagrams
    for (int count : charCount) {
      if (count != 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String a = scan.next();
    String b = scan.next();
    scan.close();
    boolean ret = isAnagram(a, b);
    System.out.println((ret) ? "Anagrams" : "Not Anagrams");
  }
}
