// HackerRank Question: https://www.hackerrank.com/challenges/beautiful-path/problem

package solutions.algorithms.Minimum_Penalty_Path;

import java.io.*;
import java.util.*;

class Result {

  public static int beautifulPath(List<List<Integer>> edges, int A, int B) {
    int n = 1001; // Maximum number of nodes (1 <= N <= 1000)

    // Create adjacency list for the graph
    List<List<int[]>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    // Populate the adjacency list with edges
    for (List<Integer> edge : edges) {
      int u = edge.get(0) - 1; // Convert to 0-based indexing
      int v = edge.get(1) - 1; // Convert to 0-based indexing
      int cost = edge.get(2);
      graph.get(u).add(new int[] {v, cost});
      graph.get(v).add(new int[] {u, cost});
    }

    // Visited matrix to track (node, cumulative cost) combinations
    boolean[][] visited = new boolean[n][1024];

    // BFS queue (node, cumulative cost)
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    queue.add(new int[] {A - 1, 0}); // Convert A to 0-based indexing

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int node = current[0];
      int cost = current[1];

      // If we reach the target node, return the cost
      if (node == B - 1) { // Convert B to 0-based indexing
        return cost;
      }

      // If this (node, cost) combination is already visited, skip
      if (visited[node][cost]) {
        continue;
      }
      visited[node][cost] = true;

      // Process neighbors
      for (int[] neighbor : graph.get(node)) {
        int nextNode = neighbor[0];
        int nextCost = cost | neighbor[1]; // Perform bitwise OR with edge cost
        if (!visited[nextNode][nextCost]) {
          queue.add(new int[] {nextNode, nextCost});
        }
      }
    }

    // If no path exists, return -1
    return -1;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);
    int m = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> edges = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      String[] edgeRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      List<Integer> edgeRowItems = new ArrayList<>();
      for (int j = 0; j < 3; j++) {
        int edgeItem = Integer.parseInt(edgeRowTempItems[j]);
        edgeRowItems.add(edgeItem);
      }

      edges.add(edgeRowItems);
    }

    String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int A = Integer.parseInt(secondMultipleInput[0]);
    int B = Integer.parseInt(secondMultipleInput[1]);

    int result = Result.beautifulPath(edges, A, B);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
