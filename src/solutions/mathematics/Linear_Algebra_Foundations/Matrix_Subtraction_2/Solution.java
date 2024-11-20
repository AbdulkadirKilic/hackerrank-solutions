// HackerRank Question:
// https://www.hackerrank.com/challenges/linear-algebra-foundations-1-matrix-subtraction/problem

package solutions.mathematics.Linear_Algebra_Foundations.Matrix_Subtraction_2;

public class Solution {

  public static void main(String[] args) {
    // Define the two matrices
    int[][] matrix1 = {
      {1, 2, 3},
      {2, 3, 4},
      {1, 1, 1}
    };

    int[][] matrix2 = {
      {4, 5, 6},
      {7, 8, 9},
      {4, 5, 0}
    };

    // Resultant matrix
    int[][] result = new int[3][3];

    // Perform matrix subtraction
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        result[i][j] = matrix1[i][j] - matrix2[i][j];
      }
    }

    // Print the resultant matrix elements row by row
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.println(result[i][j]);
      }
    }
  }
}
