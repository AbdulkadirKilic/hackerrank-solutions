// HackerRank Question: https://www.hackerrank.com/challenges/knightl-on-chessboard/problem

package solutions.algorithms.KnightL_on_a_Chessboard;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'knightlOnAChessboard' function below.
   *
   * The function is expected to return a 2D_INTEGER_ARRAY.
   * The function accepts INTEGER n as parameter.
   */

  public static List<List<Integer>> knightlOnAChessboard(int n) {
    List<List<Integer>> result = new ArrayList<>();

    // Iterate over each possible (a, b) pair
    for (int a = 1; a < n; a++) {
      List<Integer> row = new ArrayList<>();
      for (int b = 1; b < n; b++) {
        int moves = bfs(n, a, b);
        row.add(moves);
      }
      result.add(row);
    }

    return result;
  }

  // BFS function to find the minimum moves from (0, 0) to (n-1, n-1)
  private static int bfs(int n, int a, int b) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];

    // Possible moves for a knight with (a, b) movement
    int[][] directions = {
      {a, b}, {a, -b}, {-a, b}, {-a, -b},
      {b, a}, {b, -a}, {-b, a}, {-b, -a}
    };

    queue.offer(new int[] {0, 0, 0}); // {x, y, moves}
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      int moves = current[2];

      // Check if we've reached the target
      if (x == n - 1 && y == n - 1) {
        return moves;
      }

      // Explore all possible moves
      for (int[] direction : directions) {
        int newX = x + direction[0];
        int newY = y + direction[1];

        // Check if the new position is within bounds and not visited
        if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
          visited[newX][newY] = true;
          queue.offer(new int[] {newX, newY, moves + 1});
        }
      }
    }

    // If (n-1, n-1) is not reachable, return -1
    return -1;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> result = Result.knightlOnAChessboard(n);

    result.stream()
        .map(r -> r.stream().map(Object::toString).collect(joining(" ")))
        .map(r -> r + "\n")
        .collect(toList())
        .forEach(
            e -> {
              try {
                bufferedWriter.write(e);
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
