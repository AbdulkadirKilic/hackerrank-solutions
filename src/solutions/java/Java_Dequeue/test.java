// HackerRank Question: https://www.hackerrank.com/challenges/java-dequeue/problem

package solutions.java.Java_Dequeue;

import java.util.*;

public class test {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Deque<Integer> deque = new ArrayDeque<>();
    Set<Integer> set = new HashSet<>();

    int n = in.nextInt();
    int m = in.nextInt();

    int maxUnique = 0;

    for (int i = 0; i < n; i++) {
      int num = in.nextInt();

      deque.add(num);
      set.add(num);

      if (deque.size() > m) {
        int removed = deque.remove();
        if (!deque.contains(removed)) {
          set.remove(removed);
        }
      }

      maxUnique = Math.max(maxUnique, set.size());
    }

    System.out.println(maxUnique);

    in.close();
  }
}
