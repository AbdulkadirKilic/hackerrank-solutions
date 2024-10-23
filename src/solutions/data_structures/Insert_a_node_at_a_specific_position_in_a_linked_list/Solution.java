// HackerRank Question: https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem

package solutions.data_structures.Insert_a_node_at_a_specific_position_in_a_linked_list;

import java.io.*;
import java.util.stream.*;

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

class SinglyLinkedListPrintHelper {
  public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
      throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }
}

class Result {

  public static SinglyLinkedListNode insertNodeAtPosition(
      SinglyLinkedListNode llist, int data, int position) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

    if (position == 0) {
      newNode.next = llist;
      return newNode;
    }

    SinglyLinkedListNode current = llist;
    for (int i = 0; i < position - 1; i++) {
      current = current.next;
    }

    newNode.next = current.next;
    current.next = newNode;

    return llist;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    SinglyLinkedList llist = new SinglyLinkedList();

    int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, llistCount)
        .forEach(
            i -> {
              try {
                int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                llist.insertNode(llistItem);
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    int data = Integer.parseInt(bufferedReader.readLine().trim());

    int position = Integer.parseInt(bufferedReader.readLine().trim());

    SinglyLinkedListNode llist_head = Result.insertNodeAtPosition(llist.head, data, position);

    SinglyLinkedListPrintHelper.printList(llist_head, " ", bufferedWriter);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
