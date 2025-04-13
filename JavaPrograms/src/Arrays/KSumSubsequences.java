package Arrays;

import java.util.ArrayList;

public class KSumSubsequences {

    public void printKSumSubsequences(int[] arr, ArrayList<Integer> ans, int n, int sum, int idx, int k) {
        // Base case: If idx reaches n, check if the sum matches k
        if (idx >= n) {
            if (sum == k) {
                // If sum is equal to k, print the subsequence
                for (int e : ans) {
                    System.out.print(e + " ");
                }
                System.out.println();  // Print a new line after the subsequence
            }
            return;
        }

        // Include arr[idx] in the subsequence
        ans.add(arr[idx]);
        printKSumSubsequences(arr, ans, n, sum + arr[idx], idx + 1, k);
        ans.remove(ans.size() - 1);  // Backtrack: Remove the last added element

        // Exclude arr[idx] and move to the next element
        printKSumSubsequences(arr, ans, n, sum, idx + 1, k);
    }

    public static void main(String[] args) {
        KSumSubsequences solution = new KSumSubsequences();
        int[] arr = {1, 2, 3};
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int k = 3;  // Example sum we want to match
        solution.printKSumSubsequences(arr, ans, n, 0, 0, k);
    }
}
