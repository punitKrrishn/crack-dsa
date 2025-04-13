package Stringss.Questions;

public class PrintLCS {
    public class LCS {

        public static void main(String[] args) {
            String X = "AGGTAB";
            String Y = "GXTXAYB";

            // Print the LCS string
            System.out.println("LCS string: " + lcs(X, Y));
        }

        // Function to find the Longest Common Subsequence (LCS) string
        public static String lcs(String X, String Y) {
            int m = X.length();
            int n = Y.length();

            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // Now, backtrack to find the LCS string
            StringBuilder lcsStr = new StringBuilder();
            int i = m, j = n;
            while (i > 0 && j > 0) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lcsStr.append(X.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

            // The LCS is built backwards, so reverse it.
            lcsStr.reverse();

            // Return the LCS as a string
            return lcsStr.toString();
        }


    }

}
