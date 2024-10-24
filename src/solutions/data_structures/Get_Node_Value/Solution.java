// HackerRank Question:
// https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem

package solutions.data_structures.Get_Node_Value;

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

  public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
    SinglyLinkedListNode current = llist;
    int length = 0;

    while (current != null) {
      length++;
      current = current.next;
    }

    int targetPosition = length - positionFromTail - 1;

    current = llist;
    for (int i = 0; i < targetPosition; i++) {
      current = current.next;
    }

    return current.data;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

                int position = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.getNode(llist.head, position);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
