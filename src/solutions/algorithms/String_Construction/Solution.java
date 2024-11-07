// HackerRank Question: https://www.hackerrank.com/challenges/string-construction/problem

package solutions.algorithms.String_Construction;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'stringConstruction' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int stringConstruction(String s) {
    // Use a HashSet to keep track of unique characters in s
    Set<Character> uniqueChars = new HashSet<>();
    for (char c : s.toCharArray()) {
      uniqueChars.add(c);
    }
    // The cost is the number of unique characters
    return uniqueChars.size();
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
                String s = bufferedReader.readLine();

                int result = Result.stringConstruction(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
