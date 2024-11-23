// HackerRank Question: https://www.hackerrank.com/challenges/john-and-gcd-list/problem

package solutions.mathematics.John_and_GCD_list;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static List<Integer> solve(List<Integer> a) {
    List<Integer> b = new ArrayList<>();
    int n = a.size();

    // First element of B
    b.add(a.get(0));

    // Fill intermediate elements based on LCM of consecutive A values
    for (int i = 0; i < n - 1; i++) {
      b.add(lcm(a.get(i), a.get(i + 1)));
    }

    // Last element of B
    b.add(a.get(n - 1));

    return b;
  }

  // Helper method to calculate GCD
  private static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }

  // Helper method to calculate LCM
  private static int lcm(int a, int b) {
    return (a / gcd(a, b)) * b;
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
                int aCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> a =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.solve(a);

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
