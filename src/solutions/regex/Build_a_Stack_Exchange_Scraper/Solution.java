// HackerRank Question: https://www.hackerrank.com/challenges/stack-exchange-scraper/problem

package solutions.regex.Build_a_Stack_Exchange_Scraper;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder htmlInput = new StringBuilder();
    String line;

    // Read all input lines into a single String
    while ((line = reader.readLine()) != null) {
      htmlInput.append(line).append("\n");
    }

    // Regex patterns to extract required data
    String questionIdPattern = "id=\"question-summary-(\\d+)\""; // Captures the question ID
    String questionTextPattern =
        "<a href=\"[^\"]*\" class=\"question-hyperlink\">([^<]*)</a>"; // Captures question text
    String relativeTimePattern =
        "<span title=\"[^\"]*\" class=\"relativetime\">([^<]*)</span>"; // Captures relative time

    // Combine the patterns into one sequential extraction process
    Pattern combinedPattern =
        Pattern.compile(
            questionIdPattern + ".*?" + questionTextPattern + ".*?" + relativeTimePattern,
            Pattern.DOTALL);

    Matcher matcher = combinedPattern.matcher(htmlInput.toString());

    // Store results to maintain order
    List<String> results = new ArrayList<>();

    // Extract and format the required data
    while (matcher.find()) {
      String questionId = matcher.group(1).trim();
      String questionText = matcher.group(2).trim();
      String relativeTime = matcher.group(3).trim();
      results.add(questionId + ";" + questionText + ";" + relativeTime);
    }

    for (String result : results) {
      System.out.println(result);
    }
  }
}
