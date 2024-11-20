// HackerRank Question: https://www.hackerrank.com/challenges/red-knights-shortest-path/problem

package solutions.algorithms.Red_Knights_Shortest_Path;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'printShortestPath' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER i_start
   *  3. INTEGER j_start
   *  4. INTEGER i_end
   *  5. INTEGER j_end
   */

  // Directions with corresponding move names
  private static final int[][] DIRECTIONS = {
    {-2, -1}, // UL
    {-2, 1}, // UR
    {0, 2}, // R
    {2, 1}, // LR
    {2, -1}, // LL
    {0, -2} // L
  };

  private static final String[] MOVE_NAMES = {"UL", "UR", "R", "LR", "LL", "L"};

  public static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
    // BFS initialization
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];
    Map<String, String> path = new HashMap<>();

    // Add starting position to the queue
    queue.add(new int[] {i_start, j_start, 0});
    visited[i_start][j_start] = true;

    // BFS loop
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      int distance = current[2];

      // If we reached the destination
      if (x == i_end && y == j_end) {
        System.out.println(distance);
        printPath(path, i_start, j_start, i_end, j_end);
        return;
      }

      // Explore all possible moves
      for (int k = 0; k < DIRECTIONS.length; k++) {
        int newX = x + DIRECTIONS[k][0];
        int newY = y + DIRECTIONS[k][1];

        if (isValid(newX, newY, n) && !visited[newX][newY]) {
          queue.add(new int[] {newX, newY, distance + 1});
          visited[newX][newY] = true;
          path.put(newX + "," + newY, x + "," + y + "," + MOVE_NAMES[k]);
        }
      }
    }

    // If no path is found
    System.out.println("Impossible");
  }

  private static boolean isValid(int x, int y, int n) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }

  private static void printPath(
      Map<String, String> path, int i_start, int j_start, int i_end, int j_end) {
    List<String> moves = new ArrayList<>();
    String current = i_end + "," + j_end;

    while (path.containsKey(current)) {
      String[] info = path.get(current).split(",");
      moves.add(info[2]);
      current = info[0] + "," + info[1];
    }

    Collections.reverse(moves);
    System.out.println(String.join(" ", moves));
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int i_start = Integer.parseInt(firstMultipleInput[0]);

    int j_start = Integer.parseInt(firstMultipleInput[1]);

    int i_end = Integer.parseInt(firstMultipleInput[2]);

    int j_end = Integer.parseInt(firstMultipleInput[3]);

    Result.printShortestPath(n, i_start, j_start, i_end, j_end);

    bufferedReader.close();
  }
}
