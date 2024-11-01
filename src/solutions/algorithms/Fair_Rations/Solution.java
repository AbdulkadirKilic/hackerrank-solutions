// HackerRank Question: https://www.hackerrank.com/challenges/fair-rations/problem

package solutions.algorithms.Fair_Rations;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'fairRations' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY B as parameter.
   */

  public static String fairRations(List<Integer> B) {
    int loafCount = 0;

    for (int i = 0; i < B.size() - 1; i++) {
      if (B.get(i) % 2 != 0) { // Check if current person has an odd number of loaves
        B.set(i, B.get(i) + 1); // Give a loaf to this person
        B.set(i + 1, B.get(i + 1) + 1); // Give a loaf to the next person
        loafCount += 2; // Increment total loaf count by 2
      }
    }

    // If the last person has an odd number of loaves, return "NO"
    return (B.get(B.size() - 1) % 2 == 0) ? String.valueOf(loafCount) : "NO";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int N = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> B =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    String result = Result.fairRations(B);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
