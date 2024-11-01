// HackerRank Question: https://www.hackerrank.com/challenges/strange-code/problem

package solutions.algorithms.Strange_Counter;

import java.io.*;

class Result {

  /*
   * Complete the 'strangeCounter' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts LONG_INTEGER t as parameter.
   */

  public static long strangeCounter(long t) {
    long cycleStart = 3; // Initial cycle starts with value 3

    // Find the correct cycle where time t falls
    while (t > cycleStart) {
      t -= cycleStart; // Move to the next cycle by subtracting the current cycle length
      cycleStart *= 2; // Each new cycle length doubles
    }

    // Calculate the value at time t in the identified cycle
    return cycleStart - t + 1;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    long t = Long.parseLong(bufferedReader.readLine().trim());

    long result = Result.strangeCounter(t);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
