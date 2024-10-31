// HackerRank Question: https://www.hackerrank.com/challenges/halloween-sale/problem

package solutions.algorithms.Halloween_Sale;

import java.io.*;

class Result {

  /*
   * Complete the 'howManyGames' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER p
   *  2. INTEGER d
   *  3. INTEGER m
   *  4. INTEGER s
   */

  public static int howManyGames(int p, int d, int m, int s) {
    int currentPrice = p;
    int gamesCount = 0;
    int totalSpent = 0;

    // If the first game costs more than the budget, return 0
    if (currentPrice > s) {
      return 0;
    }
    if (totalSpent + currentPrice <= s && totalSpent + currentPrice + (currentPrice - d) > s) {
      return 1;
    }

    // Buy games while the price is decreasing to minimum m
    while (currentPrice > m && totalSpent + currentPrice <= s) {
      totalSpent += currentPrice;
      gamesCount++;
      currentPrice -= d;
    }

    // Check if we can buy exactly one game at price m
    if (totalSpent + m > s && gamesCount == 0) {
      return 1;
    }

    // Once the price reaches m, buy as many games as possible at price m
    while (totalSpent + m <= s) {
      totalSpent += m;
      gamesCount++;
    }

    return gamesCount;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int p = Integer.parseInt(firstMultipleInput[0]);

    int d = Integer.parseInt(firstMultipleInput[1]);

    int m = Integer.parseInt(firstMultipleInput[2]);

    int s = Integer.parseInt(firstMultipleInput[3]);

    int answer = Result.howManyGames(p, d, m, s);

    bufferedWriter.write(String.valueOf(answer));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
