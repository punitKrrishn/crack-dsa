package DynamicProgramming;

public class Knapsack {

    // Function to solve the 0/1 Knapsack Problem
    public static int knapsack(int[] values, int[] weights, int Capacity, int n) {
        // Create a 2D DP table with (n+1) rows and (Capacity+1) columns
        int[][] dp = new int[n + 1][Capacity + 1];

        // Fill the DP table
        for (int i = 0; i < n+1; i++) {
            for (int w = 0; w < Capacity+1; w++) {
                // If there are no items or the capacity is 0, the value is 0
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;  // Base case: No items or no capacity, max value is 0
                } else if (weights[i - 1] <= w) {
                    // If the current item's weight is less than or equal to the current capacity
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                    // Choose the maximum value between:
                    // 1. Not including the current item: dp[i-1][w]
                    // 2. Including the current item: dp[i-1][w - weights[i-1]] + values[i-1]
                } else {
                    // If the weight of the current item exceeds the capacity, we can't include it
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The value in dp[n][Capacity] will be the maximum value we can carry in the knapsack
        return dp[n][Capacity];
    }

    public static void main(String[] args) {
        // Example items (values and weights)
        int[] values = {60, 100, 120}; // Values of the items
        int[] weights = {10, 20, 30}; // Weights of the items
        int Capacity = 50; // Maximum weight capacity of the knapsack
        int n = values.length; // Number of items

        // Solve the knapsack problem
        int maxValue = knapsack(values, weights, Capacity, n);

        // Output the result
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
