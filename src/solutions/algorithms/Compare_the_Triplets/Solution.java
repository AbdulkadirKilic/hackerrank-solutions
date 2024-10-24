// HackerRank Question: https://www.hackerrank.com/challenges/compare-the-triplets/problem

package solutions.algorithms.Compare_the_Triplets;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    int aliceScore = 0;
    int bobScore = 0;

    for (int i = 0; i < 3; i++) {
      if (a.get(i) > b.get(i)) {
        aliceScore++;
      } else if (a.get(i) < b.get(i)) {
        bobScore++;
      }
    }

    return Arrays.asList(aliceScore, bobScore);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    List<Integer> a =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> b =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.compareTriplets(a, b);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}