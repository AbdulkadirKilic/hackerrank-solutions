// HackerRank Question: https://www.hackerrank.com/challenges/number-groups/problem

package solutions.mathematics.Number_Groups;

import java.io.*;

class Result {

  /*
   * Complete the 'sumOfGroup' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts INTEGER k as parameter.
   */

  public static long sumOfGroup(int k) {
    // Calculate the start and end indices of the k-th group
    long start = (long) (k - 1) * k / 2 + 1; // Starting index
    long end = (long) k * (k + 1) / 2; // Ending index

    // Sum of the k-th group
    return end * end - (start - 1) * (start - 1);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int k = Integer.parseInt(bufferedReader.readLine().trim());

    long answer = Result.sumOfGroup(k);

    bufferedWriter.write(String.valueOf(answer));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
