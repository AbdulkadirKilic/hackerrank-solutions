// HackerRank Question:
// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem

package solutions.algorithms.Fraudulent_Activity_Notifications;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'activityNotifications' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY expenditure
   *  2. INTEGER d
   */

  public static int activityNotifications(List<Integer> expenditure, int d) {
    int notifications = 0;
    int[] count = new int[201]; // Fixed-size array for expenditures between 0-200

    // Add the expenditures of the first `d` days to the frequency array
    for (int i = 0; i < d; i++) {
      count[expenditure.get(i)]++;
    }

    // Check each day after the initial `d` days
    for (int i = d; i < expenditure.size(); i++) {
      double median = getMedian(count, d);
      if (expenditure.get(i) >= 2 * median) {
        notifications++;
      }

      // Update the frequency array: remove the oldest value and add the new value
      count[expenditure.get(i - d)]--;
      count[expenditure.get(i)]++;
    }

    return notifications;
  }

  // Helper function to calculate the median from the frequency array
  private static double getMedian(int[] count, int d) {
    int sum = 0;
    int median1 = -1;
    int median2 = -1;

    // For an odd count, the median is the middle element; for an even count, it's the average of
    // two middle elements
    for (int i = 0; i < count.length; i++) {
      sum += count[i];

      if (median1 == -1 && sum >= d / 2) {
        median1 = i;
      }
      if (median2 == -1 && sum >= d / 2 + 1) {
        median2 = i;
        break;
      }
    }

    // Return the median depending on whether `d` is odd or even
    if (d % 2 == 0) {
      return (median1 + median2) / 2.0;
    } else {
      return median2;
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int d = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> expenditure =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.activityNotifications(expenditure, d);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
