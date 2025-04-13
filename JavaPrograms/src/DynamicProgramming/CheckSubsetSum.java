package DynamicProgramming;

public class CheckSubsetSum {

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};  // Example array
        int sum = 7;  // Target sum
        int n = arr.length;

        // Call the recursive function to check if sum is possible
        boolean ans = checkSum2(arr, sum, n);

        // Print the answer
        System.out.print("Ans: " + ans);  // Expected output: true
    }

    // Recursive function to check if a subset with the given sum exists
    private static boolean checkSum(int[] arr, int sum, int n) {
        // Base case 1: If sum is 0, the subset is possible (empty set can achieve sum 0)
        if (sum == 0) {
            return true;
        }

        // Base case 2: If no items left and sum is not 0, it's not possible
        if (n == 0) {
            return false;
        }

        // If the current item is greater than the current sum, it cannot be included
        if (arr[n - 1] > sum) {
            // Skip this item and check for the remaining items with the same sum
            return checkSum(arr, sum, n - 1);
        } else {
            // Try including or excluding the current item
            return checkSum(arr, sum - arr[n - 1], n - 1) || checkSum(arr, sum, n - 1);
        }
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
                // If the current item's weight is less than or equal to the current sum
                if (arr[i - 1] <= j) {
                    // Check if sum can be achieved by including or excluding the current item
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    // If the current item cannot be included, carry over the result from the previous row
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The value in dp[n][sum] will tell us if the sum can be achieved with the given items
        return dp[n][sum];
    }
}
