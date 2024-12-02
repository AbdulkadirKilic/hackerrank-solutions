// HackerRank Question: https://www.hackerrank.com/challenges/hackerrank-language/problem

package solutions.regex.HackerRank_Language;

import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    // Initialize valid programming languages in a Set for O(1) lookup
    Set<String> validLanguages =
        new HashSet<>(
            Arrays.asList(
                "C",
                "CPP",
                "JAVA",
                "PYTHON",
                "PERL",
                "PHP",
                "RUBY",
                "CSHARP",
                "HASKELL",
                "CLOJURE",
                "BASH",
                "SCALA",
                "ERLANG",
                "CLISP",
                "LUA",
                "BRAINFUCK",
                "JAVASCRIPT",
                "GO",
                "D",
                "OCAML",
                "R",
                "PASCAL",
                "SBCL",
                "DART",
                "GROOVY",
                "OBJECTIVEC"));

    // Read input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // Number of requests

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      String language = input[1]; // The language field is at index 1

      // Check if the language is valid and print the result
      if (validLanguages.contains(language)) {
        System.out.println("VALID");
      } else {
        System.out.println("INVALID");
      }
    }
  }
}
