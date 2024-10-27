// HackerRank Question: https://www.hackerrank.com/challenges/grading/problem

package solutions.algorithms.Grading_Students;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'gradingStudents' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY grades as parameter.
   */

  public static List<Integer> gradingStudents(List<Integer> grades) {
    List<Integer> roundedGrades = new ArrayList<>();

    for (int grade : grades) {
      if (grade >= 38) { // Only consider rounding for grades 38 and above
        int nextMultipleOf5 = ((grade / 5) + 1) * 5;

        if (nextMultipleOf5 - grade < 3) {
          grade = nextMultipleOf5; // Round up to the next multiple of 5
        }
      }
      roundedGrades.add(grade);
    }

    return roundedGrades;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> grades =
        IntStream.range(0, gradesCount)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.gradingStudents(grades);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
