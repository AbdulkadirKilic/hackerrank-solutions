// HackerRank Question: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

package solutions.algorithms.Climbing_the_Leaderboard;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'climbingLeaderboard' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY ranked
   *  2. INTEGER_ARRAY player
   */

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

    List<Integer> distinctRanks = ranked.stream().distinct().collect(Collectors.toList());

    List<Integer> result = new ArrayList<>();
    int index = distinctRanks.size() - 1;

    for (int score : player) {

      while (index >= 0 && score >= distinctRanks.get(index)) {
        index--;
      }

      result.add(index + 2);
    }

    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ranked =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> player =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.climbingLeaderboard(ranked, player);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
