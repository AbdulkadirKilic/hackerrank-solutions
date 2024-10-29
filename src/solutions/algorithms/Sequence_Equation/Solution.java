// HackerRank Question: https://www.hackerrank.com/challenges/permutation-equation/problem

package solutions.algorithms.Sequence_Equation;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'permutationEquation' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY p as parameter.
   */

  public static List<Integer> permutationEquation(List<Integer> p) {
    int n = p.size();
    List<Integer> result = new ArrayList<>(n);

    // Creating a lookup array to store the index of each value in p.
    int[] position = new int[n + 1];

    // Fill the position array where position[value] gives the index of that value in p.
    for (int i = 0; i < n; i++) {
      position[p.get(i)] = i + 1;
    }

    // For each x from 1 to n, find y such that p(p(y)) = x.
    for (int x = 1; x <= n; x++) {
      int posX = position[x];
      int y = position[posX];
      result.add(y);
    }

    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> p =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.permutationEquation(p);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
