// HackerRank Question: https://www.hackerrank.com/challenges/append-and-delete/problem

package solutions.algorithms.Append_and_Delete;

import java.io.*;

class Result {

  /*
   * Complete the 'appendAndDelete' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. STRING t
   *  3. INTEGER k
   */

  public static String appendAndDelete(String s, String t, int k) {
    // Step 1: Find the longest common prefix length
    int commonLength = 0;
    while (commonLength < s.length()
        && commonLength < t.length()
        && s.charAt(commonLength) == t.charAt(commonLength)) {
      commonLength++;
    }

    // Step 2: Calculate the number of deletions and additions needed
    int deletions = s.length() - commonLength;
    int additions = t.length() - commonLength;
    int minOperations = deletions + additions;

    // Step 3: Determine if exactly k operations can achieve the result
    if (minOperations == k) {
      return "Yes";
    } else if (minOperations < k) {
      // Check if we can perform exactly k operations by over-deleting
      if ((k - minOperations) % 2 == 0 || k >= s.length() + t.length()) {
        return "Yes";
      }
    }

    return "No";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String t = bufferedReader.readLine();

    int k = Integer.parseInt(bufferedReader.readLine().trim());

    String result = Result.appendAndDelete(s, t, k);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
