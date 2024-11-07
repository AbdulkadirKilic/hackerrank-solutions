// HackerRank Question: https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem

package solutions.algorithms.Hackerland_Radio_Transmitters;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'hackerlandRadioTransmitters' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY x
   *  2. INTEGER k
   */

  public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
    Collections.sort(x); // Sort the house positions
    int n = x.size();
    int transmitters = 0;
    int i = 0;

    while (i < n) {
      transmitters++; // Place a new transmitter
      int loc = x.get(i) + k; // This is the farthest right we can go for this transmitter

      // Move i to the farthest house within the range of this transmitter
      while (i < n && x.get(i) <= loc) i++;

      // Now i is at the first house outside the left coverage of the transmitter
      loc = x.get(--i) + k; // Set loc to the farthest right coverage

      // Move i past the coverage of this transmitter
      while (i < n && x.get(i) <= loc) i++;
    }

    return transmitters;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> x =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.hackerlandRadioTransmitters(x, k);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
