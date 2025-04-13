package DynamicProgramming;

import java.util.Arrays;

public class FrogJump1 {
    public static void main(String[] args) {
        int idx = 4;
        int[] arr = {30,10,60,10,50};
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        int minimumTotalEnergyToN = solveDp(arr,idx,dp);
        System.out.print(minimumTotalEnergyToN);
    }

    private static int solve(int[] arr, int idx) {

        if(idx == 0) {
            return 0;
        }
        int oneWay = solve(arr,idx-1) + Math.abs(arr[idx] - arr[idx-1]);
        int otherWay = Integer.MAX_VALUE;
        if(idx > 1) {
            otherWay = solve(arr,idx - 2) + Math.abs(arr[idx] - arr[idx-2]);
        }
        return  Math.min(oneWay,otherWay);

    }

    private static int solveDp(int[] arr, int idx, int[] dp) {

        if(idx == 0) {
            return 0;
        }
        if(dp[idx] != -1) {return dp[idx];}
        int oneWay = solveDp(arr,idx-1,dp) + Math.abs(arr[idx] - arr[idx-1]);
        int otherWay = Integer.MAX_VALUE;
        if(idx > 1) {
             otherWay = solveDp(arr,idx - 2,dp) + Math.abs(arr[idx] - arr[idx-2]);
        }
        dp[idx] =  Math.min(oneWay,otherWay);
        return dp[idx];
    }

    //T.c = O(n) and Sc O(n)
    private static int solveMemo(int[] arr, int n) {
        // Create a DP array to store minimum energy to reach each stone
        int[] dp = new int[arr.length];

        // Base case: no energy is required to reach the first stone
        dp[0] = 0;

        // Fill the DP array iteratively for each stone from 1 to n-1
        for (int i = 1; i < n; i++) {
            // Energy required to jump from the previous stone (i-1)
            int oneWay = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);

            // Initialize the other way as a large value
            int otherWay = Integer.MAX_VALUE;

            // Energy required to jump from two stones back (i-2), if possible
            if (i > 1) {
                otherWay = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }

            // Store the minimum of both possibilities in dp[i]
            dp[i] = Math.min(oneWay, otherWay);
        }

        // Return the minimum energy required to reach the last stone
        return dp[n - 1];
    }

    //T.c = O(n) and Sc O(1)
    private static int solveSO(int[] arr, int n) {

        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int oneWay = prev + Math.abs(arr[i] - arr[i - 1]);

            int otherWay = Integer.MAX_VALUE;

            if (i > 1) {
                otherWay = prev2 + Math.abs(arr[i] - arr[i - 2]);
            }

            int curr = Math.min(oneWay, otherWay);
            prev2 = prev;
            prev = curr;

        }
        return prev;
    }

}
