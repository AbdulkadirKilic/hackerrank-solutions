// HackerRank Question: https://www.hackerrank.com/challenges/strange-advertising/problem

package solutions.algorithms.Viral_Advertising;

import java.io.*;

class Result {

  /*
   * Complete the 'viralAdvertising' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  public static int viralAdvertising(int n) {
    int shared = 5;
    int cumulativeLikes = 0;

    for (int day = 1; day <= n; day++) {
      int liked = shared / 2;
      cumulativeLikes += liked;
      shared = liked * 3;
    }

    return cumulativeLikes;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int result = Result.viralAdvertising(n);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
