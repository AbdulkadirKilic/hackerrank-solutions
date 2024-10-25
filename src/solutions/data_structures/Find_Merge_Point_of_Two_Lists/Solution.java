// HackerRank Question:
// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem

package solutions.data_structures.Find_Merge_Point_of_Two_Lists;

import java.io.*;

class SinglyLinkedListNode {
  public int data;
  public SinglyLinkedListNode next;

  public SinglyLinkedListNode(int nodeData) {
    this.data = nodeData;
    this.next = null;
  }
}

class SinglyLinkedList {
  public SinglyLinkedListNode head;
  public SinglyLinkedListNode tail;

  public SinglyLinkedList() {
    this.head = null;
    this.tail = null;
  }

  public void insertNode(int nodeData) {
    SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

    if (this.head == null) {
      this.head = node;
    } else {
      this.tail.next = node;
    }

    this.tail = node;
  }
}

public class Solution {

  // Function to find the merge point of two linked lists
  public static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode ptr1 = head1;
    SinglyLinkedListNode ptr2 = head2;

    // Traverse both lists. When one pointer reaches the end, start it at the head of the other
    // list.
    while (ptr1 != ptr2) {
      ptr1 = (ptr1 == null) ? head2 : ptr1.next;
      ptr2 = (ptr2 == null) ? head1 : ptr2.next;
    }

    // The node at which both pointers meet is the merge point
    return ptr1.data;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bufferedReader.readLine().trim());

    for (int tItr = 0; tItr < t; tItr++) {
      int index = Integer.parseInt(bufferedReader.readLine().trim());

      SinglyLinkedList llist1 = new SinglyLinkedList();
      int llist1Count = Integer.parseInt(bufferedReader.readLine().trim());
      for (int i = 0; i < llist1Count; i++) {
        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());
        llist1.insertNode(llistItem);
      }

      SinglyLinkedList llist2 = new SinglyLinkedList();
      int llist2Count = Integer.parseInt(bufferedReader.readLine().trim());
      for (int i = 0; i < llist2Count; i++) {
        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());
        llist2.insertNode(llistItem);
      }

      // Link the two lists at the merge point
      SinglyLinkedListNode ptr1 = llist1.head;
      for (int i = 0; i < index; i++) {
        ptr1 = ptr1.next;
      }
      SinglyLinkedListNode ptr2 = llist2.head;
      while (ptr2.next != null) {
        ptr2 = ptr2.next;
      }
      ptr2.next = ptr1;

      // Output the merge node data
      int result = findMergeNode(llist1.head, llist2.head);
      System.out.println(result);
    }

    bufferedReader.close();
  }
}
