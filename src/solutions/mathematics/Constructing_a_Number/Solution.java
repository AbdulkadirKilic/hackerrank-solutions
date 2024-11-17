// HackerRank Question: https://www.hackerrank.com/challenges/constructing-a-number/problem

package solutions.mathematics.Constructing_a_Number;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'canConstruct' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static String canConstruct(List<Integer> a) {
    // Initialize the total sum of digits
    int totalSum = 0;

    // Iterate over each number in the array
    for (int num : a) {
      // Extract digits and add them to totalSum
      while (num > 0) {
        totalSum += num % 10; // Add the last digit
        num /= 10; // Remove the last digit
      }
    }

    // Check if the sum of digits is divisible by 3
    return totalSum % 3 == 0 ? "Yes" : "No";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> a =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.canConstruct(a);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
