// HackerRank Question: https://www.hackerrank.com/challenges/compare-two-linked-lists/problem

package solutions.data_structures.Compare_two_linked_lists;

import java.io.*;
import java.util.*;

class SinglyLinkedListNode {
  public int data;
  public SinglyLinkedListNode next;

  public SinglyLinkedListNode(int nodeData) {
    this.data = nodeData;
    this.next = null;
  }
}

public class Solution {

  public static int compare_lists(SinglyLinkedListNode llist1, SinglyLinkedListNode llist2) {
    while (llist1 != null && llist2 != null) {
      if (llist1.data != llist2.data) {
        return 0;
      }
      llist1 = llist1.next;
      llist2 = llist2.next;
    }

    return (llist1 == null && llist2 == null) ? 1 : 0;
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int tests = scanner.nextInt();

    for (int t = 0; t < tests; t++) {
      int llist1Count = scanner.nextInt();
      SinglyLinkedListNode llist1 = null, tail1 = null;
      for (int i = 0; i < llist1Count; i++) {
        int data = scanner.nextInt();
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (llist1 == null) {
          llist1 = newNode;
        } else {
          tail1.next = newNode;
        }
        tail1 = newNode;
      }

      int llist2Count = scanner.nextInt();
      SinglyLinkedListNode llist2 = null, tail2 = null;
      for (int i = 0; i < llist2Count; i++) {
        int data = scanner.nextInt();
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (llist2 == null) {
          llist2 = newNode;
        } else {
          tail2.next = newNode;
        }
        tail2 = newNode;
      }

      int result = compare_lists(llist1, llist2);
      System.out.println(result);
    }

    scanner.close();
  }
}
