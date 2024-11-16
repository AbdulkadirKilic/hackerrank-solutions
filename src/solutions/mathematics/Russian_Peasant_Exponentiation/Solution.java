// HackerRank Question: https://www.hackerrank.com/challenges/russian-peasant-exponentiation/problem

package solutions.mathematics.Russian_Peasant_Exponentiation;

import static java.util.stream.Collectors.joining;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER a
   *  2. INTEGER b
   *  3. LONG_INTEGER k
   *  4. INTEGER m
   */

  public static List<Integer> solve(int a, int b, long k, int m) {
    // Initialize the result as (1 + 0i)
    int real = 1; // Real part
    int imag = 0; // Imaginary part

    // Base (a + bi)
    int baseReal = a % m;
    int baseImag = b % m;

    while (k > 0) {
      // If k is odd, multiply the current result with the base
      if ((k & 1) == 1) {
        int newReal = (int) (((long) real * baseReal - (long) imag * baseImag) % m);
        int newImag = (int) (((long) real * baseImag + (long) imag * baseReal) % m);

        // Normalize the results to avoid negative values
        real = (newReal + m) % m;
        imag = (newImag + m) % m;
      }

      // Square the base
      int newBaseReal = (int) (((long) baseReal * baseReal - (long) baseImag * baseImag) % m);
      int newBaseImag = (int) (((long) 2 * baseReal * baseImag) % m);

      baseReal = (newBaseReal + m) % m;
      baseImag = (newBaseImag + m) % m;

      // Halve k
      k /= 2;
    }

    // Return the real and imaginary parts modulo m
    return Arrays.asList(real, imag);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                long k = Long.parseLong(firstMultipleInput[2]);

                int m = Integer.parseInt(firstMultipleInput[3]);

                List<Integer> result = Result.solve(a, b, k, m);

                bufferedWriter.write(
                    result.stream().map(Object::toString).collect(joining(" ")) + "\n");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
