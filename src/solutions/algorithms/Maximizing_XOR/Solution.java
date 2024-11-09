// HackerRank Question: https://www.hackerrank.com/challenges/maximizing-xor/problem

package solutions.algorithms.Maximizing_XOR;

import java.io.*;

class Result {

  /*
   * Complete the 'maximizingXor' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER l
   *  2. INTEGER r
   */

  public static int maximizingXor(int l, int r) {
    // XOR l and r to find the difference
    int xor = l ^ r;

    // Set all bits to 1 from the most significant bit of the XOR result
    int maxXor = 1;
    while (xor > 0) {
      maxXor <<= 1; // Shift left to make room for more bits
      xor >>= 1; // Shift xor right to check next bit
    }

    // Subtract 1 to make all bits below the most significant bit 1
    return maxXor - 1;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int l = Integer.parseInt(bufferedReader.readLine().trim());

    int r = Integer.parseInt(bufferedReader.readLine().trim());

    int result = Result.maximizingXor(l, r);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
