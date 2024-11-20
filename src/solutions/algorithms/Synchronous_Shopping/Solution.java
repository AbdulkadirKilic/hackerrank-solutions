// HackerRank Question: https://www.hackerrank.com/challenges/synchronous-shopping/problem

package solutions.algorithms.Synchronous_Shopping;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'shop' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER k
   *  3. STRING_ARRAY centers
   *  4. 2D_INTEGER_ARRAY roads
   */

  public static int shop(int n, int k, List<String> centers, List<List<Integer>> roads) {
    // Represent fish species with bitmask
    int[] fishAtCenter = new int[n + 1];
    for (int i = 0; i < n; i++) {
      String[] data = centers.get(i).split(" ");
      int types = Integer.parseInt(data[0]);
      for (int j = 1; j <= types; j++) {
        fishAtCenter[i + 1] |= (1 << (Integer.parseInt(data[j]) - 1));
      }
    }

    // Create the graph
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (List<Integer> road : roads) {
      int u = road.get(0), v = road.get(1), w = road.get(2);
      graph.get(u).add(new int[] {v, w});
      graph.get(v).add(new int[] {u, w});
    }

    // Distance matrix for Dijkstra (node, fish state)
    int[][] dist = new int[n + 1][1 << k];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    dist[1][fishAtCenter[1]] = 0;

    // Dijkstra using PriorityQueue (min-heap)
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    pq.offer(new int[] {0, 1, fishAtCenter[1]}); // {time, node, fish state}

    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int time = current[0];
      int node = current[1];
      int fishMask = current[2];

      if (time > dist[node][fishMask]) continue;

      for (int[] neighbor : graph.get(node)) {
        int nextNode = neighbor[0];
        int travelTime = neighbor[1];
        int nextFishMask = fishMask | fishAtCenter[nextNode];
        int newTime = time + travelTime;

        if (newTime < dist[nextNode][nextFishMask]) {
          dist[nextNode][nextFishMask] = newTime;
          pq.offer(new int[] {newTime, nextNode, nextFishMask});
        }
      }
    }

    // Check the fish status of the two cats for the result
    int fullMask = (1 << k) - 1;
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < (1 << k); i++) {
      for (int j = 0; j < (1 << k); j++) {
        if ((i | j) == fullMask) { // The situation where two cats collected all the fish
          result = Math.min(result, Math.max(dist[n][i], dist[n][j]));
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

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    int k = Integer.parseInt(firstMultipleInput[2]);

    List<String> centers =
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

    List<List<Integer>> roads = new ArrayList<>();

    IntStream.range(0, m)
        .forEach(
            i -> {
              try {
                roads.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    int res = Result.shop(n, k, centers, roads);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
