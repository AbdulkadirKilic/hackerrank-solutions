// HackerRank Question: https://www.hackerrank.com/challenges/diwali-lights/problem

package solutions.mathematics.Diwali_Lights;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'lights' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  public static long lights(int n) {
    int MOD = 100000;
    // Calculate 2^N - 1 % MOD
    long result = (powerOfTwo(n, MOD) - 1 + MOD) % MOD;
    return result;
  }

  // Helper function to calculate (2^N) % MOD efficiently
  private static long powerOfTwo(int n, int mod) {
    long result = 1;
    long base = 2;

    while (n > 0) {
      if (n % 2 == 1) {
        result = (result * base) % mod;
      }
      base = (base * base) % mod;
      n /= 2;
    }

    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                long result = Result.lights(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
