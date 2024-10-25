// HackerRank Question:
// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem

package solutions.data_structures.Tree_Inorder_Traversal;

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

  /* you only have to complete the function given below.
  Node is defined as

  class Node {
      int data;
      Node left;
      Node right;
  }

  */

  public static void inOrder(Node root) {
    // Base case: if the node is null, return
    if (root == null) {
      return;
    }

    // Recur on left subtree
    inOrder(root.left);

    // Print the current node data
    System.out.print(root.data + " ");

    // Recur on right subtree
    inOrder(root.right);
  }

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
    inOrder(root);
  }
}
