// HackerRank Question:
// https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem

package solutions.data_structures.Cycle_Detection;

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

class Result {

  /*
   * Complete the 'has_cycle' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
   */

  public static int has_cycle(SinglyLinkedListNode head) {
    if (head == null) {
      return 0; // No cycle if the list is empty
    }

    // Initialize two pointers for cycle detection
    SinglyLinkedListNode slow = head;
    SinglyLinkedListNode fast = head;

    // Traverse the list with two pointers
    while (fast != null && fast.next != null) {
      slow = slow.next; // Move slow pointer by one step
      fast = fast.next.next; // Move fast pointer by two steps

      // If slow and fast pointers meet, there is a cycle
      if (slow == fast) {
        return 1; // Cycle detected
      }
    }

    return 0; // No cycle
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

                // Create a cycle if indicated by the input
                int createCycle = Integer.parseInt(bufferedReader.readLine().trim());
                if (createCycle == 1 && llist.head != null) {
                  // Make the tail node point back to the head or another node to form a cycle
                  llist.tail.next = llist.head; // Creates a cycle
                }

                int result = Result.has_cycle(llist.head);

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
