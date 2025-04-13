package DynamicProgramming;

public class MaxSumNonAdj {
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 5, 6, 7};
        int idx = arr.length - 1;  // Start with the last index
        int ans = solve(arr, idx);
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

    private static int solveTabu(int[] arr, int idx) {

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int pick = Integer.MIN_VALUE;
        for(int i=1; i<arr.length; i++) {
            if(i>1){  pick = arr[idx] + dp[i-2];}
            int notPick = dp[i-1];
            dp[i] =  Math.max(pick, notPick);

        }
       return dp[arr.length-1];

    }
}
