// HackerRank Question: https://www.hackerrank.com/challenges/flatland-space-stations/problem

package solutions.algorithms.Flatland_Space_Stations;

import java.io.*;
import java.util.*;

public class Solution {

  static int flatlandSpaceStations(int n, int[] c) {
    Arrays.sort(c); // Sort space station locations

    // Calculate the maximum distance from the first city to the first space station
    int maxDistance = c[0];

    // Calculate maximum distances between consecutive space stations
    for (int i = 1; i < c.length; i++) {
      int distance = (c[i] - c[i - 1]) / 2;
      maxDistance = Math.max(maxDistance, distance);
    }

    // Calculate the distance from the last space station to the last city
    maxDistance = Math.max(maxDistance, (n - 1) - c[c.length - 1]);

    return maxDistance;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[] c = new int[m];

    String[] cItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      c[i] = cItem;
    }

    int result = flatlandSpaceStations(n, c);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
