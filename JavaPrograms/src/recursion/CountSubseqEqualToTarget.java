package recursion;

import java.util.ArrayList;

public class CountSubseqEqualToTarget {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2};
        int target = 3;
        int idx = 0;
        ArrayList<Integer> output = new ArrayList<>();
        int count = countSubsequences(arr, idx, output, target, 0);
        System.out.println(count);
    }

    private static int countSubsequences(int[] arr, int idx, ArrayList<Integer> output, int target, int currentSum) {
        if (idx >= arr.length) {
            return (currentSum == target) ? 1 : 0;
        }

        output.add(arr[idx]);
        int includeCount = countSubsequences(arr, idx + 1, output, target, currentSum + arr[idx]);
        output.remove(output.size() - 1);
        int excludeCount = countSubsequences(arr, idx + 1, output, target, currentSum);

        return includeCount + excludeCount;
    }
}
