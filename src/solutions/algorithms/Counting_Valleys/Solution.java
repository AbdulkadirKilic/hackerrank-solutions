// HackerRank Question: https://www.hackerrank.com/challenges/counting-valleys/problem

package solutions.algorithms.Counting_Valleys;

import java.io.*;

class Result {

  /*
   * Complete the 'countingValleys' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER steps
   *  2. STRING path
   */

  public static int countingValleys(int steps, String path) {
    int valleys = 0; // Number of valleys traversed
    int altitude = 0; // Current altitude level

    for (int i = 0; i < steps; i++) {
      char step = path.charAt(i);

      // Track altitude changes
      if (step == 'U') {
        altitude++;
        // Check if we just exited a valley
        if (altitude == 0) {
          valleys++;
        }
      } else if (step == 'D') {
        altitude--;
      }
    }

    return valleys;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int steps = Integer.parseInt(bufferedReader.readLine().trim());

    String path = bufferedReader.readLine();

    int result = Result.countingValleys(steps, path);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
