// HackerRank Question: https://www.hackerrank.com/challenges/uk-and-us/problem

package solutions.regex.The_British_and_American_Style_of_Spelling;

import java.io.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Read number of lines
    int n = Integer.parseInt(br.readLine());
        StringBuilder text = new StringBuilder();

        // Read the N lines
        for (int i = 0; i < n; i++) {
            text.append(br.readLine()).append(" ");
        }

        // Combine all lines into a single text
        String inputText = text.toString();

        // Read number of test cases
        int t = Integer.parseInt(br.readLine());

        // Process each test case
        for (int i = 0; i < t; i++) {
            String word = br.readLine();
            // Create regex for both American and British spelling
            String regex = "\\b" + word.substring(0, word.length() - 2) + "(ze|se)\\b";

            // Match using regex
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputText);

            int count = 0;
            while (matcher.find()) {
                count++;
            }


            System.out.println(count);
        }
    }
}

