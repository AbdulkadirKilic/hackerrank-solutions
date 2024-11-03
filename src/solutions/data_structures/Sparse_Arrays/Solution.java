// HackerRank Question: https://www.hackerrank.com/challenges/sparse-arrays/problem

package solutions.data_structures.Sparse_Arrays;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'matchingStrings' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY stringList
   *  2. STRING_ARRAY queries
   */

  public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
    // Create a map to store the frequency of each string in stringList
    Map<String, Integer> frequencyMap = new HashMap<>();

    // Count occurrences of each string in stringList
    for (String str : stringList) {
      frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
    }

    // Prepare the result list based on the frequency of each query string
    List<Integer> result = new ArrayList<>();
    for (String query : queries) {
      result.add(frequencyMap.getOrDefault(query, 0));
    }

    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int stringListCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> stringList =
        IntStream.range(0, stringListCount)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine();
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .collect(toList());

    int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> queries =
        IntStream.range(0, queriesCount)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine();
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .collect(toList());

    List<Integer> res = Result.matchingStrings(stringList, queries);

    bufferedWriter.write(res.stream().map(Object::toString).collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
