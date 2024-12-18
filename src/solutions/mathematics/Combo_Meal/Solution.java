// HackerRank Question: https://www.hackerrank.com/challenges/combo-meal/problem

package solutions.mathematics.Combo_Meal;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'profit' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER b
   *  2. INTEGER s
   *  3. INTEGER c
   */

  public static int profit(int b, int s, int c) {
    // Calculate the fixed profit using the formula
    return b + s - c;
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
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int b = Integer.parseInt(firstMultipleInput[0]);

                int s = Integer.parseInt(firstMultipleInput[1]);

                int c = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.profit(b, s, c);

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
