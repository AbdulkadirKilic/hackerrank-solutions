// HackerRank Question: https://www.hackerrank.com/challenges/encryption/problem

package solutions.algorithms.Encryption;

import java.io.*;

class Result {

  /*
   * Complete the 'encryption' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String encryption(String s) {
    // Remove spaces from the string
    s = s.replace(" ", "");

    // Calculate grid size
    int L = s.length();
    int rows = (int) Math.floor(Math.sqrt(L));
    int cols = (int) Math.ceil(Math.sqrt(L));

    // If rows * cols is less than L, increase rows
    if (rows * cols < L) {
      rows = cols;
    }

    // Create a list of StringBuilder to store each column
    StringBuilder[] encoded = new StringBuilder[cols];
    for (int i = 0; i < cols; i++) {
      encoded[i] = new StringBuilder();
    }

    // Populate each column
    for (int i = 0; i < L; i++) {
      encoded[i % cols].append(s.charAt(i));
    }

    // Join all columns with spaces
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < cols; i++) {
      result.append(encoded[i]);
      if (i < cols - 1) {
        result.append(" ");
      }
    }

    return result.toString();
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.encryption(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
