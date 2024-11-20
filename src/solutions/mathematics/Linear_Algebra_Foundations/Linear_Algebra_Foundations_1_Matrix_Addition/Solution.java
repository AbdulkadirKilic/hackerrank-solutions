// HackerRank Question: https://www.hackerrank.com/challenges/linear-algebra-foundations-1/problem

package solutions.mathematics.Linear_Algebra_Foundations.Linear_Algebra_Foundations_1_Matrix_Addition;

public class Solution {

  public static void main(String[] args) {
    // Matrices to be added
    int[][] matrix1 = {
      {1, 2, 3},
      {2, 3, 4},
      {1, 1, 1}
    };

    int[][] matrix2 = {
      {4, 5, 6},
      {7, 8, 9},
      {4, 5, 7}
    };

    // Resultant matrix
    int[][] result = new int[3][3];

    // Perform matrix addition
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        result[i][j] = matrix1[i][j] + matrix2[i][j];
      }
    }

    // Print results
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.println(result[i][j]);
      }
    }
  }
}
