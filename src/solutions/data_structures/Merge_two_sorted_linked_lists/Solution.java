// HackerRank Question: https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem

package solutions.data_structures.Merge_two_sorted_linked_lists;

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

  public static SinglyLinkedListNode mergeLists(
      SinglyLinkedListNode headA, SinglyLinkedListNode headB) {

    if (headA == null) return headB;
    if (headB == null) return headA;

    SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
    SinglyLinkedListNode current = dummy;

    while (headA != null && headB != null) {
      if (headA.data <= headB.data) {
        current.next = headA;
        headA = headA.next;
      } else {
        current.next = headB;
        headB = headB.next;
      }
      current = current.next;
    }

    if (headA != null) {
      current.next = headA;
    } else if (headB != null) {
      current.next = headB;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int tests = scanner.nextInt();

    for (int t = 0; t < tests; t++) {
      int llist1Count = scanner.nextInt();
      SinglyLinkedListNode headA = null, tailA = null;

      for (int i = 0; i < llist1Count; i++) {
        int data = scanner.nextInt();
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (headA == null) {
          headA = newNode;
        } else {
          tailA.next = newNode;
        }
        tailA = newNode;
      }

      int llist2Count = scanner.nextInt();
      SinglyLinkedListNode headB = null, tailB = null;

      for (int i = 0; i < llist2Count; i++) {
        int data = scanner.nextInt();
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (headB == null) {
          headB = newNode;
        } else {
          tailB.next = newNode;
        }
        tailB = newNode;
      }

      SinglyLinkedListNode mergedHead = mergeLists(headA, headB);

      printList(mergedHead);
    }

    scanner.close();
  }

  public static void printList(SinglyLinkedListNode node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println();
  }
}
