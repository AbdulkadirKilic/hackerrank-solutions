// HackerRank Question: https://www.hackerrank.com/challenges/java-vistor-pattern/problem

package solutions.java.Java_Visitor_Pattern;

import java.util.*;

enum Color {
  RED,
  GREEN
}

abstract class Tree {
  private int value;
  private Color color;
  private int depth;

  public Tree(int value, Color color, int depth) {
    this.value = value;
    this.color = color;
    this.depth = depth;
  }

  public int getValue() {
    return value;
  }

  public Color getColor() {
    return color;
  }

  public int getDepth() {
    return depth;
  }

  public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
  private List<Tree> children = new ArrayList<>();

  public TreeNode(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitNode(this);
    for (Tree child : children) {
      child.accept(visitor);
    }
  }

  public void addChild(Tree child) {
    children.add(child);
  }
}

class TreeLeaf extends Tree {
  public TreeLeaf(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitLeaf(this);
  }
}

abstract class TreeVis {
  public abstract int getResult();

  public abstract void visitNode(TreeNode node);

  public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {
  private int sum = 0;

  public int getResult() {
    return sum;
  }

  public void visitNode(TreeNode node) {
    // Nothing to do for non-leaf nodes
  }

  public void visitLeaf(TreeLeaf leaf) {
    sum += leaf.getValue();
  }
}

class ProductRedNodesVisitor extends TreeVis {
  private long product = 1;
  private final int MOD = 1000000007;

  public int getResult() {
    return (int) product;
  }

  public void visitNode(TreeNode node) {
    if (node.getColor() == Color.RED) {
      product = (product * node.getValue()) % MOD;
    }
  }

  public void visitLeaf(TreeLeaf leaf) {
    if (leaf.getColor() == Color.RED) {
      product = (product * leaf.getValue()) % MOD;
    }
  }
}

class FancyVisitor extends TreeVis {
  private int nonLeafEvenDepthSum = 0;
  private int greenLeafSum = 0;

  public int getResult() {
    return Math.abs(nonLeafEvenDepthSum - greenLeafSum);
  }

  public void visitNode(TreeNode node) {
    if (node.getDepth() % 2 == 0) {
      nonLeafEvenDepthSum += node.getValue();
    }
  }

  public void visitLeaf(TreeLeaf leaf) {
    if (leaf.getColor() == Color.GREEN) {
      greenLeafSum += leaf.getValue();
    }
  }
}

public class Solution {
  private static int[] values;
  private static Color[] colors;
  private static Map<Integer, List<Integer>> edges = new HashMap<>();

  public static Tree solve() {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    values = new int[n];
    colors = new Color[n];

    for (int i = 0; i < n; i++) {
      values[i] = scanner.nextInt();
    }

    for (int i = 0; i < n; i++) {
      colors[i] = scanner.nextInt() == 0 ? Color.RED : Color.GREEN;
    }

    for (int i = 0; i < n - 1; i++) {
      int u = scanner.nextInt() - 1;
      int v = scanner.nextInt() - 1;
      edges.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
      edges.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
    }

    scanner.close();

    return buildTree(0, -1, 0);
  }

  private static Tree buildTree(int nodeId, int parentId, int depth) {
    List<Integer> children = edges.get(nodeId);
    if (children == null || (children.size() == 1 && children.contains(parentId))) {
      return new TreeLeaf(values[nodeId], colors[nodeId], depth);
    } else {
      TreeNode node = new TreeNode(values[nodeId], colors[nodeId], depth);
      for (Integer childId : children) {
        if (childId != parentId) {
          node.addChild(buildTree(childId, nodeId, depth + 1));
        }
      }
      return node;
    }
  }

  public static void main(String[] args) {
    Tree root = solve();

    SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
    ProductRedNodesVisitor vis2 = new ProductRedNodesVisitor();
    FancyVisitor vis3 = new FancyVisitor();

    root.accept(vis1);
    root.accept(vis2);
    root.accept(vis3);

    System.out.println(vis1.getResult());
    System.out.println(vis2.getResult());
    System.out.println(vis3.getResult());
  }
}
