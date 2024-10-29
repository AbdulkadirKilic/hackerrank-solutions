// HackerRank Question: https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem

package solutions.algorithms.Jumping_on_the_Clouds_Revisited;

import java.io.*;
import java.util.*;

public class Solution {

  static int jumpingOnClouds(int[] c, int k) {
    int energy = 100; // Initial energy level
    int n = c.length;
    int position = 0;

    do {
      // Jump to the next position
      position = (position + k) % n;

      // Deduct 1 energy for the jump
      energy -= 1;

      // Deduct an additional 2 energy if it's a thundercloud
      if (c[position] == 1) {
        energy -= 2;
      }
    } while (position != 0); // Continue until we're back to the starting position

    return energy;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[] c = new int[n];

    String[] cItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      c[i] = cItem;
    }

    int result = jumpingOnClouds(c, k);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
