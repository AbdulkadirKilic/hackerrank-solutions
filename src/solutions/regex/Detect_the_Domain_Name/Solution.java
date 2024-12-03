// HackerRank Question: https://www.hackerrank.com/challenges/detect-the-domain-name/problem

package solutions.regex.Detect_the_Domain_Name;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    // Read input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine().trim()); // Number of lines
    StringBuilder html = new StringBuilder();

    for (int i = 0; i < n; i++) {
      html.append(br.readLine()).append("\n");
    }

    // Updated regex to match valid domain names from URLs
    String regex = "(?i)https?://(?:www\\.|ww2\\.)?([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(html);

    // TreeSet to store unique domains in lexicographical order
    Set<String> domains = new TreeSet<>();

    // Extract and clean domains
    while (matcher.find()) {
      domains.add(matcher.group(1)); // Add the domain name to the set
    }

    // Join the domains with a semicolon and print
    System.out.println(String.join(";", domains));
  }
}
