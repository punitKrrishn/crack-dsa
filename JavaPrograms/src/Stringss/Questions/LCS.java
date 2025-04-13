package Stringss.Questions;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
      //  int lcsLength = longestCommonSubsequence(a, b, n, m);
     //   int lcsLength = longestCommonSubsequenceMemo(a, b, n, m,dp);
        int lcsLength = longestCommonSubsequenceTab(a,b);

        System.out.println("Length of LCS: " + lcsLength);  // Output: 4 (GTAB)
    }

    private static int longestCommonSubsequence(String a, String b, int i, int j) {

        if(i==0 || j == 0) {
            return 0;
        }

        if(a.charAt(i-1) == b.charAt(j-1)) {
            return 1 + longestCommonSubsequence(a,b,i-1,j-1);
        }

        int leftString = longestCommonSubsequence(a,b,i,j-1);
        int rightString = longestCommonSubsequence(a,b,i-1,j);

        return Math.max(leftString,rightString);
    }

    // Using Memoization
    private static int longestCommonSubsequenceMemo(String a, String b, int i, int j, int[][] dp) {
        // Base case: If we reach either string's end, no common subsequence
        if (i == 0 || j == 0) {
            return 0;
        }

        // Check if the subproblem has already been solved
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If characters match, we include this character in the LCS
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            dp[i][j] = 1 + longestCommonSubsequence(a, b, i - 1, j - 1);
        } else {
            // Otherwise, find the maximum by excluding one character from either string
            dp[i][j] = Math.max(longestCommonSubsequence(a, b, i, j - 1),
                    longestCommonSubsequence(a, b, i - 1, j));
        }

        return dp[i][j];
    }

    // Tabulation

    public static int longestCommonSubsequenceTab(String a, String b) {
        int m = a.length();
        int n = b.length();

        // Create a 2D array to store the lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp table in a bottom-up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The value in dp[m][n] contains the length of the LCS
        return dp[m][n];
    }


}
