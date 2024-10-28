// HackerRank Question: https://www.hackerrank.com/challenges/cats-and-a-mouse/problem

package solutions.algorithms.Cats_and_a_Mouse;

import java.io.*;
import java.util.*;

public class Solution {

  static String catAndMouse(int x, int y, int z) {
    // Calculate distances of Cat A and Cat B from the Mouse
    int distanceCatA = Math.abs(x - z);
    int distanceCatB = Math.abs(y - z);

    // Determine the result based on the distances
    if (distanceCatA < distanceCatB) {
      return "Cat A";
    } else if (distanceCatB < distanceCatA) {
      return "Cat B";
    } else {
      return "Mouse C"; // Both cats reach the mouse at the same time
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String[] xyz = scanner.nextLine().split(" ");

      int x = Integer.parseInt(xyz[0]);

      int y = Integer.parseInt(xyz[1]);

      int z = Integer.parseInt(xyz[2]);

      String result = catAndMouse(x, y, z);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
