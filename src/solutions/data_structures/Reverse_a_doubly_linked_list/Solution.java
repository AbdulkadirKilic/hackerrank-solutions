// HackerRank Question: https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem

package solutions.data_structures.Reverse_a_doubly_linked_list;

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

  public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    if (head == null) {
      return null;
    }

    DoublyLinkedListNode current = head;
    DoublyLinkedListNode temp = null;

    while (current != null) {
      temp = current.prev;
      current.prev = current.next;
      current.next = temp;

      current = current.prev;
    }

    if (temp != null) {
      head = temp.prev;
    }

    return head;
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

                DoublyLinkedListNode llist1 = Result.reverse(llist.head);

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
