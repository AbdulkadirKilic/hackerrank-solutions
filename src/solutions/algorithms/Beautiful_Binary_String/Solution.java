// HackerRank Question: https://www.hackerrank.com/challenges/beautiful-binary-string/problem

package solutions.algorithms.Beautiful_Binary_String;

import java.io.*;

class Result {

  /*
   * Complete the 'beautifulBinaryString' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING b as parameter.
   */

  public static int beautifulBinaryString(String b) {
    int changes = 0;
    int i = 0;

    while (i <= b.length() - 3) {
      // Check for the "010" pattern
      if (b.substring(i, i + 3).equals("010")) {
        changes++; // Increment changes for this occurrence
        i += 3; // Move past this "010" to avoid overlapping
      } else {
        i++; // Move one step forward
      }
    }

    return changes;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String b = bufferedReader.readLine();

    int result = Result.beautifulBinaryString(b);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
