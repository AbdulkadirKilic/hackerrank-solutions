// HackerRank Question: https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

package solutions.data_structures.Tree_Height_of_aBinary_Tree;

import java.util.*;

class Node {
  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class Solution {

  // Function to calculate the height of the binary tree
  public static int getHeight(Node root) {
    if (root == null) {
      return -1; // Base case: if root is null, height is -1 as per definition
    }

    // Recursive call to calculate height of left and right subtrees
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);

    // Height of the tree is the maximum of left or right subtree height plus 1
    return Math.max(leftHeight, rightHeight) + 1;
  }

  // Method to insert a node in the binary search tree
  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    int height = getHeight(root);
    System.out.println(height);
  }
}
