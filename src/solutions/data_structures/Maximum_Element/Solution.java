// HackerRank Question: https://www.hackerrank.com/challenges/maximum-element/problem

package solutions.data_structures.Maximum_Element;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'getMax' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts STRING_ARRAY operations as parameter.
   */

  public static List<Integer> getMax(List<String> operations) {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    List<Integer> result = new ArrayList<>();

    for (String operation : operations) {
      String[] parts = operation.split(" ");
      int type = Integer.parseInt(parts[0]);

      if (type == 1) {

        int value = Integer.parseInt(parts[1]);
        stack.push(value);

        if (maxStack.isEmpty() || value >= maxStack.peek()) {
          maxStack.push(value);
        }
      } else if (type == 2) {

        if (!stack.isEmpty()) {
          int removed = stack.pop();
          if (removed == maxStack.peek()) {
            maxStack.pop();
          }
        }
      } else if (type == 3) {

        if (!maxStack.isEmpty()) {
          result.add(maxStack.peek());
        }
      }
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

    List<String> ops =
        IntStream.range(0, n)
            .mapToObj(
                i -> {
                  try {
                    return bufferedReader.readLine();
                  } catch (IOException ex) {
                    throw new RuntimeException(ex);
                  }
                })
            .collect(toList());

    List<Integer> res = Result.getMax(ops);

    bufferedWriter.write(res.stream().map(Object::toString).collect(joining("\n")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
