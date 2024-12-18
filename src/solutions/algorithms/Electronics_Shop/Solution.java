// HackerRank Question: https://www.hackerrank.com/challenges/electronics-shop/problem

package solutions.algorithms.Electronics_Shop;

import java.io.*;
import java.util.*;

public class Solution {

  /*
   * Complete the getMoneySpent function below.
   */
  static int getMoneySpent(int[] keyboards, int[] drives, int b) {
    int maxSpend = -1; // Initialize maxSpend to -1 for cases where no valid pair is found

    // Iterate over each keyboard price
    for (int keyboard : keyboards) {
      // For each keyboard, iterate over each drive price
      for (int drive : drives) {
        int totalCost = keyboard + drive;

        // Check if the combined cost is within budget and is the maximum so far
        if (totalCost <= b && totalCost > maxSpend) {
          maxSpend = totalCost;
        }
      }
    }

    return maxSpend; // Return the maximum spend or -1 if no valid combination
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] bnm = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    int b = Integer.parseInt(bnm[0]);

    int n = Integer.parseInt(bnm[1]);

    int m = Integer.parseInt(bnm[2]);

    int[] keyboards = new int[n];

    String[] keyboardsItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
      int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
      keyboards[keyboardsItr] = keyboardsItem;
    }

    int[] drives = new int[m];

    String[] drivesItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    for (int drivesItr = 0; drivesItr < m; drivesItr++) {
      int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
      drives[drivesItr] = drivesItem;
    }

    /*
     * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
     */

    int moneySpent = getMoneySpent(keyboards, drives, b);

    bufferedWriter.write(String.valueOf(moneySpent));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
