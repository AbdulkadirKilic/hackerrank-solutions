// HackerRank Question: https://www.hackerrank.com/challenges/java-arraylist/problem

package solutions.java.Java_Arraylist;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    List<List<Integer>> listOfLists = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int d = scanner.nextInt();
      List<Integer> line = new ArrayList<>();
      for (int j = 0; j < d; j++) {
        line.add(scanner.nextInt());
      }
      listOfLists.add(line);
    }

    int q = scanner.nextInt();

    for (int i = 0; i < q; i++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();

      try {

        System.out.println(listOfLists.get(x - 1).get(y - 1));
      } catch (IndexOutOfBoundsException e) {
        System.out.println("ERROR!");
      }
    }

    scanner.close();
  }
}
