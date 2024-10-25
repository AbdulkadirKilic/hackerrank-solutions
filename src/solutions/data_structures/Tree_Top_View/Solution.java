// HackerRank Question: https://www.hackerrank.com/challenges/tree-top-view/problem

package solutions.data_structures.Tree_Top_View;

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

  /*

  class Node
      int data;
      Node left;
      Node right;
  */
  public static void topView(Node root) {
    if (root == null) return;

    // Queue to hold pairs of Node and its horizontal distance (HD)
    Queue<Pair> queue = new LinkedList<>();
    // TreeMap to store the first node at each HD (sorted by HD)
    Map<Integer, Integer> topViewMap = new TreeMap<>();

    // Initialize queue with the root node at HD 0
    queue.add(new Pair(root, 0));

    // Perform level order traversal
    while (!queue.isEmpty()) {
      Pair currentPair = queue.poll();
      Node currentNode = currentPair.node;
      int hd = currentPair.hd;

      // If HD is not in the map, it's the first node at this HD for the top view
      topViewMap.putIfAbsent(hd, currentNode.data);

      // Add left and right children to the queue with updated HDs
      if (currentNode.left != null) {
        queue.add(new Pair(currentNode.left, hd - 1));
      }
      if (currentNode.right != null) {
        queue.add(new Pair(currentNode.right, hd + 1));
      }
    }

    // Print top view nodes in order of their horizontal distances
    for (int data : topViewMap.values()) {
      System.out.print(data + " ");
    }
  }

  /* Helper class for storing a node and its horizontal distance */
  static class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
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
    topView(root);
  }
}
