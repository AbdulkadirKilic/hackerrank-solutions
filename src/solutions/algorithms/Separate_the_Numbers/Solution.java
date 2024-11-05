// HackerRank Question: https://www.hackerrank.com/challenges/separate-the-numbers/problem

package solutions.algorithms.Separate_the_Numbers;

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'separateNumbers' function below.
   *
   * The function accepts STRING s as parameter.
   */

  public static void separateNumbers(String s) {
    int length = s.length();

    // Try to find a starting number length from 1 up to length/2
    for (int i = 1; i <= length / 2; i++) {
      String firstNumStr = s.substring(0, i);
      long firstNum = Long.parseLong(firstNumStr);
      StringBuilder expectedSequence = new StringBuilder(firstNumStr);

      // Generate the sequence by adding 1 to the previous number
      long nextNum = firstNum;
      while (expectedSequence.length() < length) {
        nextNum++;
        expectedSequence.append(nextNum);
      }

      // Check if the generated sequence matches the input string
      if (expectedSequence.toString().equals(s)) {
        System.out.println("YES " + firstNum);
        return;
      }
    }

    // If no valid sequence is found, print NO
    System.out.println("NO");
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
  }
}
