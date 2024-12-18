// HackerRank Question: https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem

package solutions.data_structures.Binary_Search_Tree_Insertion;

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

  public static void preOrder(Node root) {

    if (root == null) return;

    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  /* Node is defined as :
  class Node
     int data;
     Node left;
     Node right;

     */

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data); // create a new root if tree is empty
    }

    if (data < root.data) {
      root.left = insert(root.left, data); // insert in the left subtree
    } else if (data > root.data) {
      root.right = insert(root.right, data); // insert in the right subtree
    }

    return root; // return the unchanged root
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
    preOrder(root);
  }
}
