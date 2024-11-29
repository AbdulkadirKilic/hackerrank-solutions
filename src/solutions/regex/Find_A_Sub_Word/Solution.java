// HackerRank Question: https://www.hackerrank.com/challenges/find-substring/problem

package solutions.regex.Find_A_Sub_Word;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine()); // Number of sentences
    StringBuilder sentences = new StringBuilder();

    for (int i = 0; i < n; i++) {
      sentences.append(scanner.nextLine()).append("\n"); // Append all sentences
    }

    int q = Integer.parseInt(scanner.nextLine()); // Number of queries
    String[] queries = new String[q];

    for (int i = 0; i < q; i++) {
      queries[i] = scanner.nextLine(); // Store each query
    }

    // Process each query
    for (String query : queries) {
      // Match query as a valid sub-word surrounded by word characters
      String regex = "\\B" + query + "\\B";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(sentences.toString());

      int count = 0;
      while (matcher.find()) {
        count++;
      }

      System.out.println(count);
    }

    scanner.close();
  }
}
