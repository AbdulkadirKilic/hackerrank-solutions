// HackerRank Question: https://www.hackerrank.com/challenges/programming-language-detection/problem

package solutions.regex.Building_a_Smart_IDE_Programming_Language_Detection;

import java.io.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    // Read the input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder code = new StringBuilder();
    String line;

    while ((line = br.readLine()) != null) {
      code.append(line).append("\n");
    }

    String codeText = code.toString();

    // Check for Java
    if (codeText.contains("import java")
        || codeText.matches(".*\\bpublic class\\b.*")
        || codeText.contains("System.out.println")) {
      System.out.println("Java");
    }
    // Check for Python
    else if (codeText.matches(".*\\bdef\\b.*:")
        || codeText.contains("print(")
        || codeText.matches(".*:\\s*$")
        || codeText.contains("print ")) {
      System.out.println("Python");
    }
    // Check for C
    else if (codeText.contains("#include")
        || codeText.matches(".*\\bprintf\\b.*")
        || codeText.matches(".*\\bscanf\\b.*")) {
      System.out.println("C");
    } else {
      System.out.println("Unknown");
    }
  }
}
