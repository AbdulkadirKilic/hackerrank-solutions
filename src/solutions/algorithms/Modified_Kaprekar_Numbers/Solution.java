// HackerRank Question: https://www.hackerrank.com/challenges/kaprekar-numbers/problem

package solutions.algorithms.Modified_Kaprekar_Numbers;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'kaprekarNumbers' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER p
   *  2. INTEGER q
   */

  public static void kaprekarNumbers(int p, int q) {
    List<Integer> kaprekarNumbers = new ArrayList<>();

    for (int i = p; i <= q; i++) {
      long square = (long) i * i;
      String strSquare = Long.toString(square);

      int d = Integer.toString(i).length();
      String right = strSquare.substring(strSquare.length() - d);
      String left = strSquare.substring(0, strSquare.length() - d);

      int rightNum = Integer.parseInt(right);
      int leftNum = (left.isEmpty()) ? 0 : Integer.parseInt(left);

      if (rightNum + leftNum == i) {
        kaprekarNumbers.add(i);
      }
    }

    if (kaprekarNumbers.isEmpty()) {
      System.out.println("INVALID RANGE");
    } else {
      for (int num : kaprekarNumbers) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int p = Integer.parseInt(bufferedReader.readLine().trim());

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    Result.kaprekarNumbers(p, q);

    bufferedReader.close();
  }
}
