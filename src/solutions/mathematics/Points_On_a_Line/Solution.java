// HackerRank Question: https://www.hackerrank.com/challenges/points-on-a-line/problem

package solutions.mathematics.Points_On_a_Line;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int[] xCoords = new int[n];
    int[] yCoords = new int[n];

    // Read input coordinates
    for (int i = 0; i < n; i++) {
      xCoords[i] = scanner.nextInt();
      yCoords[i] = scanner.nextInt();
    }

    scanner.close();

    // Check if all x-coordinates are the same
    boolean sameX = true;
    for (int i = 1; i < n; i++) {
      if (xCoords[i] != xCoords[0]) {
        sameX = false;
        break;
      }
    }

    // Check if all y-coordinates are the same
    boolean sameY = true;
    for (int i = 1; i < n; i++) {
      if (yCoords[i] != yCoords[0]) {
        sameY = false;
        break;
      }
    }

    // If either all x-coordinates or all y-coordinates are the same, print YES
    if (sameX || sameY) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
