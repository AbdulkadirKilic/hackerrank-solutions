// HackerRank Question: https://www.hackerrank.com/challenges/halloween-party/problem

package solutions.mathematics.Halloween_party;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'halloweenParty' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts INTEGER k as parameter.
   */

  public static long halloweenParty(int k) {
    // Maximize chocolate pieces by splitting cuts between horizontal and vertical
    long half1 = k / 2;
    long half2 = k - half1;
    return half1 * half2;
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
                int k = Integer.parseInt(bufferedReader.readLine().trim());

                long result = Result.halloweenParty(k);

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
