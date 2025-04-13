package DynamicProgramming;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 4;
        // take 1 step or can take 2 steps
       int ans =  countTotalWays(n);


    }

    //T.c 2^n and S.C = O(n)
    private static int countTotalWays(int idx) {

        if (idx == 0) {
            return 1;
        }
        if (idx == 1) {
            return 1;
        }

        int left = countTotalWays(idx - 1);
        int right = 0;
        if (idx > 1) {
            right = countTotalWays(idx - 2);
        }
        return left + right;
    }

    //T.C = O(n) ans S.c O(n)
    private static int countTotalWaysMemo(int idx,int [] dp) {

        if (idx == 0) {
            return 1;
        }
        if (idx == 1) {
            return 1;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }

        int left = countTotalWays(idx - 1);
        int right = 0;
        if (idx > 1) {
            right = countTotalWays(idx - 2);
        }
        dp[idx] =  left + right;
        return dp[idx];
    }

    //T.C = O(n) ans S.c O(n)
    private static int countTotalWaysTabu(int idx) {
        if (idx == 0 || idx == 1) {
            return 1; // Base cases: 1 way to reach step 0 or 1
        }

        // Initialize the dp array to store results for all indices from 0 to idx
        int[] dp = new int[idx + 1];

        // Base cases initialization
        dp[0] = 1; // 1 way to reach step 0
        dp[1] = 1; // 1 way to reach step 1

        // Fill the dp array for all steps from 2 to idx
        for (int i = 2; i <= idx; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // The total ways to reach step i
        }

        return dp[idx]; // Return the result for the given idx
    }

    //T.C = O(n) ans S.c O(1)
    private static int countTotalWaysSO(int idx) {
        if (idx == 0 || idx == 1) {
            return 1; // Base cases: 1 way to reach step 0 or 1
        }

        // We only need to keep track of the last two values
        int prev2 = 1; // Represents dp[i-2], initially 1 (for idx == 0)
        int prev = 1;  // Represents dp[i-1], initially 1 (for idx == 1)

        // Calculate the total ways for each step from 2 to idx
        for (int i = 2; i <= idx; i++) {
            int current = prev + prev2; // dp[i] = dp[i-1] + dp[i-2]

            // Update prev2 and prev for the next iteration
            prev2 = prev;  // Update prev2 to prev (dp[i-2])
            prev = current; // Update prev to current (dp[i-1])
        }

        return prev; // After the loop, prev will hold dp[idx]
    }





}
