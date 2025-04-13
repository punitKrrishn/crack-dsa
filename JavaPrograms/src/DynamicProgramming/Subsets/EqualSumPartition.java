package DynamicProgramming.Subsets;

public class EqualSumPartition {

    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};
        int n  = arr.length;

        boolean result = equalSumPartition(n - 1, arr);
        System.out.println(result);  // Output: true/false

    }

    // Method to check whether partitioning is possible
    private static boolean equalSumPartition(int n, int[] arr) {
        int sum = 0;

        for (int e : arr) {
            sum += e;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        return solve(n, target, arr, dp);
    }

    public static boolean solve(int i, int target, int[] arr, boolean[][] dp) {
        if (target == 0) {
            return true;  // If target becomes 0, a subset with sum = 0 is found
        }

        if (i < 0) {
            return false;  // If we've considered all items and target is still not zero, return false
        }

        if (dp[i][target]) {
            return dp[i][target];
        }

        // Step 5: Recursive case
        boolean pick = false;
        if (arr[i] <= target) {
            pick = solve(i - 1, target - arr[i], arr, dp);  // Pick the current element
        }

        boolean notPick = solve(i - 1, target, arr, dp);  // Don't pick the current element

        // Step 6: Store the result in dp table
        dp[i][target] = pick || notPick;

        return dp[i][target];
    }
}
