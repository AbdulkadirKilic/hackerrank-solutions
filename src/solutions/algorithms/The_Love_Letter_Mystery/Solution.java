// HackerRank Question: https://www.hackerrank.com/challenges/the-love-letter-mystery/problem

package solutions.algorithms.The_Love_Letter_Mystery;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'theLoveLetterMystery' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int theLoveLetterMystery(String s) {
    int operations = 0;
    int length = s.length();

    // Loop through half of the string and compare with the opposite side
    for (int i = 0; i < length / 2; i++) {
      char startChar = s.charAt(i);
      char endChar = s.charAt(length - i - 1);
      // Calculate the operations needed to make startChar and endChar the same
      operations += Math.abs(startChar - endChar);
    }

    return operations;
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
                String s = bufferedReader.readLine();

                int result = Result.theLoveLetterMystery(s);

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
