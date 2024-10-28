// HackerRank Question: https://www.hackerrank.com/challenges/designer-pdf-viewer/problem

package solutions.algorithms.Designer_PDF_Viewer;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'designerPdfViewer' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY h
   *  2. STRING word
   */

  public static int designerPdfViewer(List<Integer> h, String word) {
    int maxHeight = 0;

    // Determine the maximum height for any letter in the word
    for (char c : word.toCharArray()) {
      int index = c - 'a'; // Calculate index in the height list
      maxHeight = Math.max(maxHeight, h.get(index));
    }

    // Calculate area of the highlighted rectangle
    return maxHeight * word.length();
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    List<Integer> h =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    String word = bufferedReader.readLine();

    int result = Result.designerPdfViewer(h, word);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
