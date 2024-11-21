// HackerRank Question:
// https://www.hackerrank.com/challenges/linear-algebra-foundations-3-matrix-multiplication/problem

package solutions.mathematics.Linear_Algebra_Foundations.Matrix_Multiplication_3;

public class Solution {

  public static void main(String[] args) {
    // Define the two matrices
    int[][] matrix1 = {
      {1, 2},
      {2, 3}
    };

    int[][] matrix2 = {
      {4, 5},
      {7, 8}
    };

    // Resultant matrix
    int[][] result = new int[2][2];

    // Perform matrix multiplication
    result[0][0] = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
    result[0][1] = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
    result[1][0] = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0];
    result[1][1] = matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1];

    // Print the resultant matrix elements
    System.out.println(result[0][0]);
    System.out.println(result[0][1]);
    System.out.println(result[1][0]);
    System.out.println(result[1][1]);
  }
}
