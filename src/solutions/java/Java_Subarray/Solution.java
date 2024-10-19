// HackerRank Question: https://www.hackerrank.com/challenges/java-negative-subarray/problem

package solutions.java.Java_Subarray;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }

    int negativeSubarrays = 0;

    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += arr[j];

        if (sum < 0) {
          negativeSubarrays++;
        }
      }
    }

    System.out.println(negativeSubarrays);

    scan.close();
  }
}
