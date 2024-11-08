// HackerRank Question: https://www.hackerrank.com/challenges/jim-and-the-orders/problem

package solutions.algorithms.Jim_and_the_Orders;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'jimOrders' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts 2D_INTEGER_ARRAY orders as parameter.
   */

  public static List<Integer> jimOrders(List<List<Integer>> orders) {
    // Create a list to store (delivery time, customer index)
    List<int[]> deliveryTimes = new ArrayList<>();

    // Calculate delivery times and store them with customer indices
    for (int i = 0; i < orders.size(); i++) {
      int orderNumber = orders.get(i).get(0);
      int prepTime = orders.get(i).get(1);
      int deliveryTime = orderNumber + prepTime;
      deliveryTimes.add(new int[] {deliveryTime, i + 1}); // i+1 for 1-based index
    }

    // Sort by delivery time, and by customer index in case of tie
    deliveryTimes.sort(
        (a, b) -> {
          if (a[0] != b[0]) {
            return Integer.compare(a[0], b[0]); // Sort by delivery time
          } else {
            return Integer.compare(a[1], b[1]); // Sort by customer index if times are equal
          }
        });

    // Extract sorted customer indices
    List<Integer> result = new ArrayList<>();
    for (int[] pair : deliveryTimes) {
      result.add(pair[1]);
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

    List<List<Integer>> orders = new ArrayList<>();

    IntStream.range(0, n)
        .forEach(
            i -> {
              try {
                orders.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    List<Integer> result = Result.jimOrders(orders);

    bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
