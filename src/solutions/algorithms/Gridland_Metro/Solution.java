// HackerRank Question: https://www.hackerrank.com/challenges/gridland-metro/problem

package solutions.algorithms.Gridland_Metro;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'gridlandMetro' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER m
   *  3. INTEGER k
   *  4. 2D_INTEGER_ARRAY track
   */

  public static long gridlandMetro(int n, int m, int k, List<List<Integer>> track) {
    // Map to store merged track ranges in each row
    Map<Integer, TreeMap<Integer, Integer>> trackMap = new HashMap<>();

    // Populate the map with each track's range
    for (List<Integer> t : track) {
      int row = t.get(0);
      int start = t.get(1);
      int end = t.get(2);

      trackMap.putIfAbsent(row, new TreeMap<>());

      TreeMap<Integer, Integer> rowTracks = trackMap.get(row);

      // Merge intervals if overlapping or adjacent
      Map.Entry<Integer, Integer> floorEntry = rowTracks.floorEntry(start);
      if (floorEntry != null && floorEntry.getValue() >= start - 1) {
        start = floorEntry.getKey();
        end = Math.max(end, floorEntry.getValue());
        rowTracks.remove(floorEntry.getKey());
      }

      Map.Entry<Integer, Integer> higherEntry = rowTracks.ceilingEntry(start);
      while (higherEntry != null && higherEntry.getKey() <= end + 1) {
        end = Math.max(end, higherEntry.getValue());
        rowTracks.remove(higherEntry.getKey());
        higherEntry = rowTracks.ceilingEntry(start);
      }

      rowTracks.put(start, end);
    }

    long totalOccupiedCells = 0;

    // Calculate the occupied cells by summing up merged intervals in each row
    for (TreeMap<Integer, Integer> rowTracks : trackMap.values()) {
      for (Map.Entry<Integer, Integer> interval : rowTracks.entrySet()) {
        totalOccupiedCells += interval.getValue() - interval.getKey() + 1L;
      }
    }

    // Total cells in the grid minus occupied cells gives the empty cells
    long totalCells = (long) n * m;
    return totalCells - totalOccupiedCells;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    int k = Integer.parseInt(firstMultipleInput[2]);

    List<List<Integer>> track = new ArrayList<>();

    IntStream.range(0, k)
        .forEach(
            i -> {
              try {
                track.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    long result = Result.gridlandMetro(n, m, k, track);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
