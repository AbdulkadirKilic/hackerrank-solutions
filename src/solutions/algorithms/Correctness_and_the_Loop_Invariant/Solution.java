// HackerRank Question: https://www.hackerrank.com/challenges/correctness-invariant/problem

package solutions.algorithms.Correctness_and_the_Loop_Invariant;

import java.util.*;

public class Solution {

  public static void insertionSort(int[] A) {
    for (int i = 1; i < A.length; i++) {
      int value = A[i];
      int j = i - 1;

      // Shift elements to the right to make space for the value
      while (j >= 0 && A[j] > value) {
        A[j + 1] = A[j];
        j = j - 1;
      }
      A[j + 1] = value; // Insert the value in its correct position
    }

    printArray(A); // Print the fully sorted array
  }

  static void printArray(int[] ar) {
    for (int n : ar) {
      System.out.print(n + " ");
    }
    System.out.println(); // Add a newline for clean output
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for (int i = 0; i < n; i++) {
      ar[i] = in.nextInt();
    }
    in.close();
    insertionSort(ar);
  }
}
