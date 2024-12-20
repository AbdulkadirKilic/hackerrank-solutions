// HackerRank Question: https://www.hackerrank.com/challenges/bon-appetit/problem

package solutions.algorithms.Bill_Division;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'bonAppetit' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY bill
   *  2. INTEGER k
   *  3. INTEGER b
   */

  public static void bonAppetit(List<Integer> bill, int k, int b) {
    // Calculate the total cost without the item Anna didn't eat
    int totalWithoutK = 0;
    for (int i = 0; i < bill.size(); i++) {
      if (i != k) {
        totalWithoutK += bill.get(i);
      }
    }

    // Calculate Anna's share
    int annaShare = totalWithoutK / 2;

    // Check if Brian overcharged
    if (b == annaShare) {
      System.out.println("Bon Appetit");
    } else {
      System.out.println(b - annaShare);
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> bill =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int b = Integer.parseInt(bufferedReader.readLine().trim());

    Result.bonAppetit(bill, k, b);

    bufferedReader.close();
  }
}
