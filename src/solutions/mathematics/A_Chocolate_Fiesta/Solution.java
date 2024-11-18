// HackerRank Question: https://www.hackerrank.com/challenges/a-chocolate-fiesta/problem

package solutions.mathematics.A_Chocolate_Fiesta;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static int solve(List<Integer> a) {
    int MOD = 1_000_000_007;

    // Counters for even and odd sum subsets
    long evenCount = 1; // Start with the empty subset
    long oddCount = 0;

    for (int num : a) {
      if (num % 2 == 0) {
        // If the number is even, it only doubles the subsets
        evenCount = (evenCount * 2) % MOD;
        oddCount = (oddCount * 2) % MOD;
      } else {
        // If the number is odd, it swaps contributions
        long newEvenCount = (evenCount + oddCount) % MOD;
        long newOddCount = (evenCount + oddCount) % MOD;
        evenCount = newEvenCount;
        oddCount = newOddCount;
      }
    }

    // Subtract the empty subset
    return (int) ((evenCount - 1 + MOD) % MOD);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int aCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.solve(a);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
