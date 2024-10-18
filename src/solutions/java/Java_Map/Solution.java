// HackerRank Question: https://www.hackerrank.com/challenges/phone-book/problem

package solutions.java.Java_Map;

import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    Map<String, Integer> phoneBook = new HashMap<>();

    int n = in.nextInt();
    in.nextLine();

    for (int i = 0; i < n; i++) {
      String name = in.nextLine();
      int phone = in.nextInt();
      in.nextLine();
      phoneBook.put(name, phone);
    }

    while (in.hasNext()) {
      String query = in.nextLine();

      if (phoneBook.containsKey(query)) {
        System.out.println(query + "=" + phoneBook.get(query));
      } else {
        System.out.println("Not found");
      }
    }

    in.close();
  }
}
