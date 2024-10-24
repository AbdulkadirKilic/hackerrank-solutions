// HackerRank Question:
// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem

package solutions.data_structures.Print_in_Reverse;

import java.io.*;
import java.util.*;
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
  public static void printList(SinglyLinkedListNode node, String sep) {
    while (node != null) {
      System.out.print(node.data);

      node = node.next;

      if (node != null) {
        System.out.print(sep);
      }
    }
  }
}

class Result {

  public static void reversePrint(SinglyLinkedListNode llist) {

    if (llist == null) {
      return;
    }

    Stack<Integer> stack = new Stack<>();

    SinglyLinkedListNode current = llist;
    while (current != null) {
      stack.push(current.data);
      current = current.next;
    }

    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int tests = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, tests)
        .forEach(
            testsItr -> {
              try {
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

                Result.reversePrint(llist.head);
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
  }
}
