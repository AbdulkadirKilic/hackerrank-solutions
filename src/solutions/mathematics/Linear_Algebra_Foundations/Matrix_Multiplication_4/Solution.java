// HackerRank Question:
// https://www.hackerrank.com/challenges/linear-algebra-foundations-4-matrix-multiplication/problem

package solutions.mathematics.Linear_Algebra_Foundations.Matrix_Multiplication_4;

public class Solution {

  public static void main(String[] args) {
    // Define the first matrix (Matrix A)
    int[][] matrixA = {
      {1, 2, 3},
      {2, 3, 4},
      {1, 1, 1}
    };

    // Define the second matrix (Matrix B)
    int[][] matrixB = {
      {4, 5, 6},
      {7, 8, 9},
      {4, 5, 7}
    };

    // Initialize the result matrix to store the product of A and B
    int[][] result = new int[3][3];

    // Perform matrix multiplication
    for (int i = 0; i < 3; i++) { // Loop through rows of Matrix A
      for (int j = 0; j < 3; j++) { // Loop through columns of Matrix B
        result[i][j] = 0; // Initialize the current cell to 0
        for (int k = 0; k < 3; k++) { // Loop through common dimensions
          result[i][j] += matrixA[i][k] * matrixB[k][j]; // Multiply and accumulate
        }
      }
    }

    // Print the result matrix in the required format
    for (int i = 0; i < 3; i++) { // Loop through rows of the result matrix
      for (int j = 0; j < 3; j++) { // Loop through columns of the result matrix
        System.out.println(result[i][j]);
      }
    }
  }
}
