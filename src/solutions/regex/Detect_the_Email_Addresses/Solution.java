// HackerRank Question: https://www.hackerrank.com/challenges/detect-the-email-addresses/problem

package solutions.regex.Detect_the_Email_Addresses;

import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Number of lines in the text
    int n = Integer.parseInt(scanner.nextLine());

    // Regex pattern to match email addresses
    String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
    Pattern pattern = Pattern.compile(emailRegex);

    // Set to store unique email addresses
    Set<String> emailSet = new TreeSet<>();

    // Read each line and extract email addresses
    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine();
      Matcher matcher = pattern.matcher(line);

      // Add all matched emails to the set
      while (matcher.find()) {
        emailSet.add(matcher.group());
      }
    }

    // Print all emails in lexicographical order, separated by semicolons
    System.out.println(String.join(";", emailSet));
  }
}
