// HackerRank Question: https://www.hackerrank.com/challenges/java-2d-array/problem

package solutions.java.Java_2D_Array;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    List<List<Integer>> arr = new ArrayList<>();

    IntStream.range(0, 6)
        .forEach(
            i -> {
              try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();

    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i <= 3; i++) {
      for (int j = 0; j <= 3; j++) {

        int currentSum =
            arr.get(i).get(j)
                + arr.get(i).get(j + 1)
                + arr.get(i).get(j + 2)
                + arr.get(i + 1).get(j + 1)
                + arr.get(i + 2).get(j)
                + arr.get(i + 2).get(j + 1)
                + arr.get(i + 2).get(j + 2);

        if (currentSum > maxSum) {
          maxSum = currentSum;
        }
      }
    }

    System.out.println(maxSum);
  }
}
