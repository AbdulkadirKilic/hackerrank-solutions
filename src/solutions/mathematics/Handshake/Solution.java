// HackerRank Question: https://www.hackerrank.com/challenges/handshake/problem

package solutions.mathematics.Handshake;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'handshake' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  public static int handshake(int n) {
    // If there is only one or no attendee, no handshakes can occur
    if (n <= 1) {
      return 0;
    }
    // Calculate the number of handshakes using the combination formula C(n, 2)
    return n * (n - 1) / 2;
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

                int result = Result.handshake(n);

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
