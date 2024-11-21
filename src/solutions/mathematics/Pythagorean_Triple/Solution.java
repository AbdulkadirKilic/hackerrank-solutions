// HackerRank Question: https://www.hackerrank.com/challenges/pythagorean-triple/problem

package solutions.mathematics.Pythagorean_Triple;

import static java.util.stream.Collectors.joining;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'pythagoreanTriple' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER a as parameter.
   */

  public static List<Long> pythagoreanTriple(int a) {
    List<Long> result = new ArrayList<>();

    // Convert a to long to handle large calculations
    long aLong = (long) a;

    // Case 1: If a is odd
    if (a % 2 != 0) {
      long b = (aLong * aLong - 1) / 2; // Calculate b
      long c = (aLong * aLong + 1) / 2; // Calculate c
      result.add(aLong);
      result.add(b);
      result.add(c);
    }
    // Case 2: If a is even
    else {
      long m = aLong / 2;
      long n = 1;
      long b = m * m - n * n; // Calculate b
      long c = m * m + n * n; // Calculate c
      result.add(aLong);
      result.add(b);
      result.add(c);
    }

    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int a = Integer.parseInt(bufferedReader.readLine().trim());

    List<Long> triple = Result.pythagoreanTriple(a);

    bufferedWriter.write(triple.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
