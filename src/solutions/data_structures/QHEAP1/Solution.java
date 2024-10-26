// HackerRank Question: https://www.hackerrank.com/challenges/qheap1/problem

package solutions.data_structures.QHEAP1;

import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int Q = Integer.parseInt(reader.readLine().trim());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Set<Integer> toDelete = new HashSet<>();

    for (int i = 0; i < Q; i++) {
      String[] query = reader.readLine().split(" ");
      int type = Integer.parseInt(query[0]);

      if (type == 1) {
        // Add element v
        int v = Integer.parseInt(query[1]);
        minHeap.add(v);

      } else if (type == 2) {
        // Mark element v for deletion
        int v = Integer.parseInt(query[1]);
        toDelete.add(v);

      } else if (type == 3) {
        // Print minimum element
        while (toDelete.contains(minHeap.peek())) {
          toDelete.remove(minHeap.poll()); // Remove outdated elements
        }
        writer.write(minHeap.peek() + "\n");
      }
    }

    writer.flush();
  }
}
