// HackerRank Question: https://www.hackerrank.com/challenges/countingsort4/problem

package solutions.algorithms.The_Full_Counting_Sort;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'countSort' function below.
   *
   * The function accepts 2D_STRING_ARRAY arr as parameter.
   */

  public static void countSort(List<List<String>> arr) {
    int n = arr.size();
    List<List<String>> buckets = new ArrayList<>(100);

    // Initialize buckets for counting sort
    for (int i = 0; i < 100; i++) {
      buckets.add(new ArrayList<>());
    }

    // Populate buckets, replacing strings in the first half with "-"
    for (int i = 0; i < n; i++) {
      int index = Integer.parseInt(arr.get(i).get(0));
      String value = (i < n / 2) ? "-" : arr.get(i).get(1);
      buckets.get(index).add(value);
    }

    // Flatten the result and print it
    StringBuilder result = new StringBuilder();
    for (List<String> bucket : buckets) {
      for (String value : bucket) {
        result.append(value).append(" ");
      }
    }

    // Print the result without the trailing space
    System.out.println(result.toString().trim());
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<String>> arr = new ArrayList<>();

    IntStream.range(0, n)
        .forEach(
            i -> {
              try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    Result.countSort(arr);

    bufferedReader.close();
  }
}
