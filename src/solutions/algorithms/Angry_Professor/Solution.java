// HackerRank Question: https://www.hackerrank.com/challenges/angry-professor/problem

package solutions.algorithms.Angry_Professor;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'angryProfessor' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY a
   */

  public static String angryProfessor(int k, List<Integer> a) {
    // Count the number of students who arrived on time
    long onTimeCount = a.stream().filter(time -> time <= 0).count();

    // Check if the number of on-time students meets or exceeds the threshold
    return onTimeCount < k ? "YES" : "NO";
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> a =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.angryProfessor(k, a);

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
