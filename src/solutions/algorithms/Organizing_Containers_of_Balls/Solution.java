// HackerRank Question: https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem

package solutions.algorithms.Organizing_Containers_of_Balls;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'organizingContainers' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts 2D_INTEGER_ARRAY container as parameter.
   */

  public static String organizingContainers(List<List<Integer>> container) {
    int n = container.size();

    // Calculate total balls in each container
    int[] containerTotals = new int[n];
    // Calculate total balls for each type
    int[] typeTotals = new int[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int balls = container.get(i).get(j);
        containerTotals[i] += balls;
        typeTotals[j] += balls;
      }
    }

    // Sort both arrays to compare if we can rearrange balls accordingly
    Arrays.sort(containerTotals);
    Arrays.sort(typeTotals);

    // Check if each container total matches each type total
    if (Arrays.equals(containerTotals, typeTotals)) {
      return "Possible";
    } else {
      return "Impossible";
    }
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
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n)
                    .forEach(
                        i -> {
                          try {
                            container.add(
                                Stream.of(
                                        bufferedReader
                                            .readLine()
                                            .replaceAll("\\s+$", "")
                                            .split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList()));
                          } catch (IOException ex) {
                            throw new RuntimeException(ex);
                          }
                        });

                String result = Result.organizingContainers(container);

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
