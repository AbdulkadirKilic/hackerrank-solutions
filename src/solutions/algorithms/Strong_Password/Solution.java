// HackerRank Question: https://www.hackerrank.com/challenges/strong-password/problem

package solutions.algorithms.Strong_Password;

import java.io.*;

class Result {

  /*
   * Complete the 'minimumNumber' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. STRING password
   */

  public static int minimumNumber(int n, String password) {
    // Flags to check if each type of character is present
    boolean hasDigit = false;
    boolean hasLower = false;
    boolean hasUpper = false;
    boolean hasSpecial = false;

    // Special characters defined by the problem
    String specialCharacters = "!@#$%^&*()-+";

    // Check each character in the password to see if it meets any criteria
    for (char ch : password.toCharArray()) {
      if (Character.isDigit(ch)) hasDigit = true;
      else if (Character.isLowerCase(ch)) hasLower = true;
      else if (Character.isUpperCase(ch)) hasUpper = true;
      else if (specialCharacters.indexOf(ch) != -1) hasSpecial = true;
    }

    // Count how many types are missing
    int missingTypes = 0;
    if (!hasDigit) missingTypes++;
    if (!hasLower) missingTypes++;
    if (!hasUpper) missingTypes++;
    if (!hasSpecial) missingTypes++;

    // Determine the minimum number of characters to add
    return Math.max(missingTypes, 6 - n);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String password = bufferedReader.readLine();

    int answer = Result.minimumNumber(n, password);

    bufferedWriter.write(String.valueOf(answer));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
