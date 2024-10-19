// HackerRank Question: https://www.hackerrank.com/challenges/java-list/problem

package solutions.java.Java_List;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(scan.nextInt());
    }

    int q = scan.nextInt();

    for (int i = 0; i < q; i++) {
      String command = scan.next();
      if (command.equals("Insert")) {
        int index = scan.nextInt();
        int value = scan.nextInt();
        list.add(index, value);
      } else if (command.equals("Delete")) {
        int index = scan.nextInt();
        list.remove(index);
      }
    }

    for (Integer num : list) {
      System.out.print(num + " ");
    }

    scan.close();
  }
}
