// HackerRank Question: https://www.hackerrank.com/challenges/manasa-and-stones/problem

package solutions.algorithms.Manasa_and_Stones;

import static java.util.stream.Collectors.joining;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'stones' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER a
   *  3. INTEGER b
   */

  public static List<Integer> stones(int n, int a, int b) {
    Set<Integer> results = new TreeSet<>();

    for (int i = 0; i < n; i++) {
      // Calculate the value of the last stone for this combination
      int lastStone = i * a + (n - 1 - i) * b;
      results.add(lastStone);
    }

    // Convert the TreeSet to a List and return
    return new ArrayList<>(results);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int T = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, T)
        .forEach(
            TItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int a = Integer.parseInt(bufferedReader.readLine().trim());

                int b = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.stones(n, a, b);

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
