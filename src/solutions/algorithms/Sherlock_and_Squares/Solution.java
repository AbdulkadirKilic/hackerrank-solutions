// HackerRank Question: https://www.hackerrank.com/challenges/sherlock-and-squares/problem

package solutions.algorithms.Sherlock_and_Squares;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'squares' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER a
   *  2. INTEGER b
   */

  public static int squares(int a, int b) {
    // Calculate the smallest integer whose square is >= a
    int lowerBound = (int) Math.ceil(Math.sqrt(a));
    // Calculate the largest integer whose square is <= b
    int upperBound = (int) Math.floor(Math.sqrt(b));

    // If lowerBound > upperBound, there are no squares in the range
    return (lowerBound > upperBound) ? 0 : (upperBound - lowerBound + 1);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.squares(a, b);

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
