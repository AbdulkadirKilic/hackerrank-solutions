// HackerRank Question: https://www.hackerrank.com/challenges/journey-to-the-moon/problem

package solutions.algorithms.Journey_to_the_Moon;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'journeyToMoon' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY astronaut
   */

  public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
    // Adjacency list to represent the graph
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    // Build the graph
    for (List<Integer> pair : astronaut) {
      int u = pair.get(0);
      int v = pair.get(1);
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    // Visited array
    boolean[] visited = new boolean[n];

    // To store the size of each connected component
    List<Long> componentSizes = new ArrayList<>();

    // Perform DFS to find all connected components
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        long size = dfs(i, graph, visited);
        componentSizes.add(size);
      }
    }

    // Total number of ways to pick two astronauts
    long totalPairs = (long) n * (n - 1) / 2;

    // Subtract pairs from the same country
    for (long size : componentSizes) {
      totalPairs -= size * (size - 1) / 2;
    }

    return totalPairs;
  }

  private static long dfs(int node, List<List<Integer>> graph, boolean[] visited) {
    Stack<Integer> stack = new Stack<>();
    stack.push(node);
    long size = 0;

    while (!stack.isEmpty()) {
      int current = stack.pop();
      if (!visited[current]) {
        visited[current] = true;
        size++;
        for (int neighbor : graph.get(current)) {
          if (!visited[neighbor]) {
            stack.push(neighbor);
          }
        }
      }
    }

    return size;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);
    int p = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> astronaut = new ArrayList<>();

    for (int i = 0; i < p; i++) {
      String[] astronautRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      List<Integer> astronautRowItems = new ArrayList<>();
      for (int j = 0; j < 2; j++) {
        int astronautItem = Integer.parseInt(astronautRowTempItems[j]);
        astronautRowItems.add(astronautItem);
      }

      astronaut.add(astronautRowItems);
    }

    long result = Result.journeyToMoon(n, astronaut);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
