package DynamicProgramming;

import java.util.Arrays;

public class FrogJumpK {
    public static void main(String[] args) {
        int idx = 4;
        int[] arr = {30,10,60,10,50};
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        int k = 2;
        int minimumTotalEnergyToN = solve(arr,idx,k);
        System.out.print(minimumTotalEnergyToN);
    }

    private static int solve(int[] arr, int idx, int k) {
        if (idx == 0) {
            return 0;  // No energy is needed to be at the start (0th index).
        }

        int minSteps = Integer.MAX_VALUE;

        // Try all jumps from 1 to k (i.e., from 1 step to k steps)
        for (int i = 1; i <= k; i++) {
            if (idx - i >= 0) {  // Ensure the jump doesn't go out of bounds
                // Recursive call to calculate the energy for the jump
                int jump = solve(arr, idx - i, k) + Math.abs(arr[idx] - arr[idx - i]);
                minSteps = Math.min(minSteps, jump);
            }
        }

        return minSteps;
    }

}
