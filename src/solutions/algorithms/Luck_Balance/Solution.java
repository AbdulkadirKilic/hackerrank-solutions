// HackerRank Question: https://www.hackerrank.com/challenges/luck-balance/problem

package solutions.algorithms.Luck_Balance;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'luckBalance' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. 2D_INTEGER_ARRAY contests
   */

  public static int luckBalance(int k, List<List<Integer>> contests) {
    int luckBalance = 0;
    List<Integer> importantContests = new ArrayList<>();

    for (List<Integer> contest : contests) {
      int luck = contest.get(0);
      int importance = contest.get(1);

      if (importance == 1) {
        importantContests.add(luck); // Add important contests to the list
      } else {
        luckBalance += luck; // Add unimportant contests' luck directly
      }
    }

    // Sort important contests in descending order of luck
    Collections.sort(importantContests, Collections.reverseOrder());

    // Add the highest k important contests to lose
    for (int i = 0; i < importantContests.size(); i++) {
      if (i < k) {
        luckBalance += importantContests.get(i); // Lose these contests
      } else {
        luckBalance -= importantContests.get(i); // Win these contests
      }
    }

    return luckBalance;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> contests = new ArrayList<>();

    IntStream.range(0, n)
        .forEach(
            i -> {
              try {
                contests.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    int result = Result.luckBalance(k, contests);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
