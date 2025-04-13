package DynamicProgramming.Subsets;

public class CountSubsetsWithDiffK {
    public static void main(String[] args) {
   /*     countSubsetsWithDifference:

        First, we calculate the total sum of the array.
                We check if (totalSum + diff) is even. If it's odd, return 0 because it's not possible to split the array into two subsets with that difference.
                We compute the target sum target = (totalSum + diff) / 2.
        The problem now reduces to counting subsets with a sum equal to target.*/

        int[] arr = {3, 34, 4, 12, 5, 2};
        int n = arr.length;
        int diff = 3;

        int ans = countSubsetsWithSum(arr, n, diff);
        System.out.println(ans);

    }
    private static int countSubsetsWithDifference(int[] arr, int n, int diff) {
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        if ((totalSum + diff) % 2 != 0) {
            return 0;
        }

        int target = (totalSum + diff) / 2;

        // Step 4: Use the Pick-Not Pick approach to count subsets with the given sum
        return countSubsetsWithSum(arr, n, target);
    }

    private static int countSubsetsWithSum(int[] arr, int n, int target) {
        // Create a memoization table to store intermediate results
        int[][] dp = new int[n + 1][target + 1];

        // Base case: There is 1 way to get a sum of 0 (pick no elements)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                // Pick the current element if it doesn't exceed the target sum
                if (arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][target];
    }


}
