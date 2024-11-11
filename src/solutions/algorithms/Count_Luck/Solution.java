// HackerRank Question: https://www.hackerrank.com/challenges/count-luck/problem

package solutions.algorithms.Count_Luck;

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'countLuck' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING_ARRAY matrix
   *  2. INTEGER k
   */

  private static final int[] rowDir = {
    -1, 1, 0, 0
  }; // Directions for row movement: Up, Down, Left, Right
  private static final int[] colDir = {
    0, 0, -1, 1
  }; // Directions for column movement: Up, Down, Left, Right

  public static String countLuck(List<String> matrix, int k) {
    int n = matrix.size();
    int m = matrix.get(0).length();
    int startRow = -1, startCol = -1;

    // Locate the starting position ('M') in the matrix
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix.get(i).charAt(j) == 'M') {
          startRow = i;
          startCol = j;
        }
      }
    }

    // Count the decision points required to reach the target
    int decisionPoints = bfs(matrix, startRow, startCol, n, m);

    // Compare decision points with k and return the result
    return (decisionPoints == k) ? "Impressed" : "Oops!";
  }

  // Breadth-First Search (BFS) function to explore the matrix and count decision points
  private static int bfs(List<String> matrix, int startRow, int startCol, int n, int m) {
    boolean[][] visited = new boolean[n][m];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {startRow, startCol, 0}); // {row, col, decision points count}
    visited[startRow][startCol] = true;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int row = current[0];
      int col = current[1];
      int decisions = current[2];

      // If the target '*' is reached, return the number of decision points
      if (matrix.get(row).charAt(col) == '*') {
        return decisions;
      }

      // Explore all possible directions and count the valid moves
      int validMoves = 0;
      for (int d = 0; d < 4; d++) {
        int newRow = row + rowDir[d];
        int newCol = col + colDir[d];
        if (isValidMove(matrix, newRow, newCol, visited, n, m)) {
          validMoves++;
        }
      }

      // If there are multiple valid moves, increment the decision count
      if (validMoves > 1) {
        decisions++;
      }

      // Add all valid moves to the queue
      for (int d = 0; d < 4; d++) {
        int newRow = row + rowDir[d];
        int newCol = col + colDir[d];
        if (isValidMove(matrix, newRow, newCol, visited, n, m)) {
          visited[newRow][newCol] = true;
          queue.add(new int[] {newRow, newCol, decisions});
        }
      }
    }
    return -1; // In case the target '*' is not reachable, though the problem guarantees a solution
  }

  // Helper function to check if the move is within bounds and not blocked or already visited
  private static boolean isValidMove(
      List<String> matrix, int row, int col, boolean[][] visited, int n, int m) {
    return row >= 0
        && row < n
        && col >= 0
        && col < m
        && matrix.get(row).charAt(col) != 'X'
        && !visited[row][col];
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    for (int tItr = 0; tItr < t; tItr++) {
      String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      int n = Integer.parseInt(firstMultipleInput[0]);
      int m = Integer.parseInt(firstMultipleInput[1]);

      List<String> matrix = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        String row = bufferedReader.readLine();
        matrix.add(row);
      }

      int k = Integer.parseInt(bufferedReader.readLine().trim());

      String result = Result.countLuck(matrix, k);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedReader.close();
    bufferedWriter.close();
  }
}
