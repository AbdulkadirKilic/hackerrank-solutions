// HackerRank Question: https://www.hackerrank.com/challenges/jim-and-the-jokes/problem

package solutions.mathematics.Jim_and_the_Jokes;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY dates as parameter.
   */

  public static BigInteger solve(List<List<Integer>> dates) {
    Map<Long, Integer> map = new HashMap<>(); // To store the count of unique transformation values
    BigInteger jokeCount = BigInteger.ZERO;

    for (List<Integer> date : dates) {
      int m = date.get(0); // month as the base
      int d = date.get(1); // day to be interpreted in the base

      // Try to interpret d in base m
      Long transformedValue = convertToBase(d, m);

      if (transformedValue != null) {
        // Count the occurrences of each transformed value
        map.put(transformedValue, map.getOrDefault(transformedValue, 0) + 1);
      }
    }

    // Calculate the number of jokes
    for (int count : map.values()) {
      if (count > 1) {
        // If a transformed value has more than one occurrence, we can make jokes
        BigInteger countBig = BigInteger.valueOf(count);
        jokeCount =
            jokeCount.add(
                countBig.multiply(countBig.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2)));
      }
    }

    return jokeCount;
  }

  // Helper function to interpret a number in a given base
  private static Long convertToBase(int number, int base) {
    if (base < 2 || base > 36) return null; // Invalid base range

    long value = 0;
    long multiplier = 1;

    while (number > 0) {
      int digit = number % 10;
      if (digit >= base) {
        return null; // Invalid digit for the specified base
      }
      value += digit * multiplier;
      multiplier *= base;
      number /= 10;
    }

    return value;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> dates = new ArrayList<>();

    IntStream.range(0, n)
        .forEach(
            i -> {
              try {
                dates.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    BigInteger result = Result.solve(dates);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
