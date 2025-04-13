package DynamicProgramming.Subsets;

public class SubsetSumEqualToTarget {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int n  = arr.length;
        int k = 0; // target
        boolean[][] dp = new boolean[n+1][k + 1];

        // If the sum is 0, we can always achieve it (by selecting no elements)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }


        // Recursively compute the answer
        boolean ans = solve(n - 1, k, arr, dp);
        System.out.println(ans);

    }



    public static boolean solve(int i, int target, int[] arr, boolean[][] dp) {
        if (target == 0) {  // subtracted till target become zero
            return true;
        }

        if (i < 0) {
            return false;
        }

        if (dp[i][target]) {
            return dp[i][target];
        }

        boolean pick = false;
        if (arr[i] <= target) {
            pick = solve(i - 1, target - arr[i], arr, dp);  // pick the current element
        }

        boolean notPick = solve(i - 1, target, arr, dp);  // do not pick the current element

        dp[i][target] = pick || notPick;  // Store the result in dp table

        return dp[i][target];
    }


    private static boolean checkSum2(int[] arr, int sum, int n) {
        // Create a 2D DP table with (n+1) rows and (sum+1) columns
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base case: A sum of 0 is always possible (with the empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {  // i start from 1 row and col is filled for arr[0]
            for (int j = 1; j <= sum; j++) {
                boolean pick = false;
                if (arr[i] <= sum) {
                    pick = solve(i - 1, sum - arr[i], arr, dp);  // pick the current element
                }

                boolean notPick = solve(i - 1, sum, arr, dp);  // do not pick the current element
                dp[i][j] = notPick || pick;
            }
        }

        // The value in dp[n][sum] will tell us if the sum can be achieved with the given items
        return dp[n][sum];
    }
}

