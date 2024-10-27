// HackerRank Question: https://www.hackerrank.com/challenges/between-two-sets/problem

package solutions.algorithms.Between_Two_Sets;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'getTotalX' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY b
   */

  public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Calculate the Least Common Multiple (LCM) of list a
    int lcmA = a.get(0);
    for (int i = 1; i < a.size(); i++) {
      lcmA = lcm(lcmA, a.get(i));
    }

    // Calculate the Greatest Common Divisor (GCD) of list b
    int gcdB = b.get(0);
    for (int i = 1; i < b.size(); i++) {
      gcdB = gcd(gcdB, b.get(i));
    }

    // Count multiples of lcmA that divide gcdB
    int count = 0;
    for (int i = lcmA; i <= gcdB; i += lcmA) {
      if (gcdB % i == 0) {
        count++;
      }
    }

    return count;
  }

  // Helper method to calculate GCD
  private static int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  // Helper method to calculate LCM
  private static int lcm(int a, int b) {
    return a * (b / gcd(a, b));
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> brr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int total = Result.getTotalX(arr, brr);

    bufferedWriter.write(String.valueOf(total));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
