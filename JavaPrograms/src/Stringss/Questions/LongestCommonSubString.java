package Stringss.Questions;

import java.util.Arrays;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "abfce";
        int n = a.length();
        int m = b.length();

        // Initialize DP table for memoization
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);  // Initialize with -1 to indicate uncomputed values
        }

        // Calling the recursive function with memoization
        int lcsLength = longestCommonSubStringTab(a, b);
        System.out.println("Length of longest common substring: " + lcsLength);

    }



//    Time Complexity: O(n * m) where n is the length of string a and m is the length of string b. We iterate over the entire dp table.
//    Space Complexity: O(n * m) for the dp table.
    private static int longestCommonSubStringTab(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n+1][m+1];
        int maxLength = 0;  // Variable to store the maximum length of the common substring

        for(int i=1; i<=a.length(); i++) {
            for(int j=1; j<=b.length(); j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1+ dp[i-1][j-1];
                    maxLength = Math.max(maxLength, dp[i][j]);  // Update maxLength
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }

    private static int longestCommonSubString(String a, String b, int i, int j) {

        if(i==0 || j == 0) {
            return 0;
        }

        if(a.charAt(i-1) == b.charAt(j-1)) {
            return 1 + longestCommonSubString(a,b,i-1,j-1);
        }
        else {
            return 0;
        }
    }

    private static int longestCommonSubStringMemo(String a, String b, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            dp[i][j] = 1 + longestCommonSubStringMemo(a, b, i - 1, j - 1, dp);
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }

}
