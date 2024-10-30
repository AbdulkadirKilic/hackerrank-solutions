// HackerRank Question: https://www.hackerrank.com/challenges/acm-icpc-team/problem

package solutions.algorithms.ACM_ICPC_Team;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'acmTeam' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts STRING_ARRAY topic as parameter.
   */

  public static List<Integer> acmTeam(List<String> topic) {
    int maxTopics = 0;
    int teamCount = 0;
    int n = topic.size();

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int knownTopics = countTopics(topic.get(i), topic.get(j));

        if (knownTopics > maxTopics) {
          maxTopics = knownTopics;
          teamCount = 1;
        } else if (knownTopics == maxTopics) {
          teamCount++;
        }
      }
    }

    return Arrays.asList(maxTopics, teamCount);
  }

  private static int countTopics(String a, String b) {
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == '1' || b.charAt(i) == '1') {
        count++;
      }
    }
    return count;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<String> topic =
        IntStream.range(0, n)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine();
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .collect(toList());

    List<Integer> result = Result.acmTeam(topic);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
