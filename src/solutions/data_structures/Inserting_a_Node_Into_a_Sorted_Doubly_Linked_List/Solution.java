// HackerRank Question: https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem

package solutions.data_structures.Inserting_a_Node_Into_a_Sorted_Doubly_Linked_List;

import java.io.*;
import java.util.stream.*;

class DoublyLinkedListNode {
  public int data;
  public DoublyLinkedListNode next;
  public DoublyLinkedListNode prev;

  public DoublyLinkedListNode(int nodeData) {
    this.data = nodeData;
    this.next = null;
    this.prev = null;
  }
}

class DoublyLinkedList {
  public DoublyLinkedListNode head;
  public DoublyLinkedListNode tail;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
  }

  public void insertNode(int nodeData) {
    DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

    if (this.head == null) {
      this.head = node;
    } else {
      this.tail.next = node;
      node.prev = this.tail;
    }

    this.tail = node;
  }
}

class DoublyLinkedListPrintHelper {
  public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
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

  public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

    if (llist == null) {
      return newNode;
    }

    if (data < llist.data) {
      newNode.next = llist;
      llist.prev = newNode;
      return newNode;
    }

    DoublyLinkedListNode current = llist;
    while (current.next != null && current.next.data < data) {
      current = current.next;
    }

    newNode.next = current.next;
    newNode.prev = current;

    if (current.next != null) {
      current.next.prev = newNode;
    }

    current.next = newNode;

    return llist;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                DoublyLinkedList llist = new DoublyLinkedList();

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

                DoublyLinkedListNode llist1 = Result.sortedInsert(llist.head, data);

                DoublyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
