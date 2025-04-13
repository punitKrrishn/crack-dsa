package DynamicProgramming;

import java.util.Arrays;

public class HouseRobberCircle {
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 5, 6, 7};
        int idx = arr.length - 2;  // Start with the last index

        int first = solve(Arrays.copyOfRange(arr, 1, arr.length), idx);

        int second = solve(Arrays.copyOfRange(arr, 0, arr.length - 1),idx);

        int ans = Math.max(first,second);
        System.out.println(ans);  // Output the result
    }

    private static int solve(int[] arr, int idx) {
        if (idx == 0) {
            return arr[0];
        }

        if (idx < 0) {
            return 0;
        }

        int pick = arr[idx] + solve(arr, idx - 2);
        int notPick = solve(arr, idx - 1);

        return Math.max(pick, notPick);
    }

    public int f(int[] arr) {
        int n = arr.length;

        // If there's no house or just one house
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        // Space optimized DP using two variables
        int prev2 = 0;  // dp[i-2] initialized to 0 (before the first house)
        int prev1 = arr[0];  // dp[i-1] initialized to arr[0]

        for (int i = 1; i < n; i++) {
            // Current house can either be robbed or skipped
            int curr = Math.max(prev1, arr[i] + prev2);

            // Update the prev2 and prev1 for the next iteration
            prev2 = prev1;
            prev1 = curr;
        }

        // The result is in prev1
        return prev1;
    }
}
