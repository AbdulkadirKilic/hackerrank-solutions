// HackerRank Question: https://www.hackerrank.com/challenges/lisa-workbook/problem

package solutions.algorithms.Lisas_Workbook;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'workbook' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER k
   *  3. INTEGER_ARRAY arr
   */

  public static int workbook(int n, int k, List<Integer> arr) {
    int specialProblems = 0;
    int pageNumber = 1;

    for (int problemsInChapter : arr) {
      for (int problem = 1; problem <= problemsInChapter; problem += k) {
        // Calculate the range of problems on the current page
        int lastProblemOnPage = Math.min(problem + k - 1, problemsInChapter);

        // Check if any problem on this page is a special problem
        if (problem <= pageNumber && pageNumber <= lastProblemOnPage) {
          specialProblems++;
        }

        // Move to the next page
        pageNumber++;
      }
    }

    return specialProblems;
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

    List<Integer> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.workbook(n, k, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
