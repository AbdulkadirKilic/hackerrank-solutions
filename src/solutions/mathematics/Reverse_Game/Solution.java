// HackerRank Question: https://www.hackerrank.com/challenges/reverse-game/problem

package solutions.mathematics.Reverse_Game;

import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output = new StringBuilder();

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    for (int i = 0; i < t; i++) {
      String[] inputs = bufferedReader.readLine().trim().split(" ");
      int n = Integer.parseInt(inputs[0]);
      int k = Integer.parseInt(inputs[1]);

      // Calculate the final index of ball k
      int result = (k < n / 2) ? (2 * k + 1) : (2 * (n - k - 1));
      output.append(result).append("\n");
    }

    System.out.print(output);
    bufferedReader.close();
  }
}
