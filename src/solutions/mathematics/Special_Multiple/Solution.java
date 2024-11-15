// HackerRank Question: https://www.hackerrank.com/challenges/special-multiple/problem

package solutions.mathematics.Special_Multiple;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER n as parameter.
   */

  public static String solve(int n) {
    // Queue to hold numbers made of 9's and 0's as strings
    Queue<String> queue = new LinkedList<>();
    // Queue to hold remainders
    Queue<Integer> remainderQueue = new LinkedList<>();

    // Start with "9" as the first number
    queue.add("9");
    remainderQueue.add(9 % n);

    // BFS to find the smallest multiple of n
    while (!queue.isEmpty()) {
      String current = queue.poll();
      int remainder = remainderQueue.poll();

      // Check if the current remainder is zero
      if (remainder == 0) {
        return current;
      }

      // Append '0' and '9' to the current string to create new numbers
      String nextZero = current + "0";
      String nextNine = current + "9";

      // Calculate new remainders
      int remainderZero = (remainder * 10) % n;
      int remainderNine = (remainder * 10 + 9) % n;

      // Add the new numbers and their remainders to the queue
      queue.add(nextZero);
      remainderQueue.add(remainderZero);
      queue.add(nextNine);
      remainderQueue.add(remainderNine);
    }

    return ""; // This will never be reached since there is always a solution
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

                String result = Result.solve(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
