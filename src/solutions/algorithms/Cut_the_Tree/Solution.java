// HackerRank Question: https://www.hackerrank.com/challenges/cut-the-tree/problem

package solutions.algorithms.Cut_the_Tree;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'cutTheTree' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY data
   *  2. 2D_INTEGER_ARRAY edges
   */

  public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
    int n = data.size();

    // Total sum of all nodes' data
    int totalSum = data.stream().mapToInt(Integer::intValue).sum();

    // Create an adjacency list for the tree
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    // Build the adjacency list from edges
    for (List<Integer> edge : edges) {
      int u = edge.get(0) - 1;
      int v = edge.get(1) - 1;
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    // Array to store the subtree sums
    int[] subtreeSum = new int[n];
    boolean[] visited = new boolean[n];

    // Calculate subtree sums using DFS
    dfs(0, data, adj, visited, subtreeSum);

    // Calculate the minimum difference
    int minDifference = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      int partSum = subtreeSum[i];
      int diff = Math.abs(totalSum - 2 * partSum);
      minDifference = Math.min(minDifference, diff);
    }

    return minDifference;
  }

  // Depth First Search to calculate subtree sums
  private static int dfs(
      int node, List<Integer> data, List<List<Integer>> adj, boolean[] visited, int[] subtreeSum) {
    visited[node] = true;
    subtreeSum[node] = data.get(node);

    for (int neighbor : adj.get(node)) {
      if (!visited[neighbor]) {
        subtreeSum[node] += dfs(neighbor, data, adj, visited, subtreeSum);
      }
    }

    return subtreeSum[node];
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> data =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<List<Integer>> edges = new ArrayList<>();

    IntStream.range(0, n - 1)
        .forEach(
            i -> {
              try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    int result = Result.cutTheTree(data, edges);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
