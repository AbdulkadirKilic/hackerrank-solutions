// HackerRank Question: https://www.hackerrank.com/challenges/torque-and-development/problem

package solutions.algorithms.Roads_and_Libraries;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'roadsAndLibraries' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER c_lib
   *  3. INTEGER c_road
   *  4. 2D_INTEGER_ARRAY cities
   */

  public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
    if (c_lib <= c_road) {
      // If building a library is cheaper or equal to a road, build one in every city
      return (long) n * c_lib;
    }

    // Adjacency list representation of the graph
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    // Build the graph
    for (List<Integer> road : cities) {
      int u = road.get(0);
      int v = road.get(1);
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    // Visited array to track visited cities
    boolean[] visited = new boolean[n + 1];
    long totalCost = 0;

    // Find connected components using DFS
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        // Start a new connected component
        int componentSize = dfs(i, graph, visited);
        // One library for the component + (componentSize - 1) roads
        totalCost += c_lib + (componentSize - 1) * c_road;
      }
    }

    return totalCost;
  }

  private static int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
    Stack<Integer> stack = new Stack<>();
    stack.push(node);
    int size = 0;

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
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                String[] firstMultipleInput =
                    bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m)
                    .forEach(
                        i -> {
                          try {
                            cities.add(
                                Stream.of(
                                        bufferedReader
                                            .readLine()
                                            .replaceAll("\\s+$", "")
                                            .split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList()));
                          } catch (IOException ex) {
                            throw new RuntimeException(ex);
                          }
                        });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

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
