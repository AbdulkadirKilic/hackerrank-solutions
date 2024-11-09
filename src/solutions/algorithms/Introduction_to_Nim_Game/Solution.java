// HackerRank Question: https://www.hackerrank.com/challenges/nim-game-1/problem

package solutions.algorithms.Introduction_to_Nim_Game;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'nimGame' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY pile as parameter.
   */

  public static String nimGame(List<Integer> pile) {
    int xorSum = 0;
    for (int stones : pile) {
      xorSum ^= stones;
    }
    return xorSum == 0 ? "Second" : "First";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int g = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, g)
        .forEach(
            gItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> pile =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.nimGame(pile);

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
