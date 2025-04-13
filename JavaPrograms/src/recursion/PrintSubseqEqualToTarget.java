package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubseqEqualToTarget {
    public static void main(String[] args) {

        int[] arr = {3, 1, 2};
        int target = 3;
        int idx = 0;
        ArrayList<Integer> output = new ArrayList<>();
        List<ArrayList<Integer>> ans = new ArrayList<>();
        List<ArrayList<Integer>> res = printSubS(arr, idx, output, ans, target, 0);
        System.out.println(res);
    }

    private static List<ArrayList<Integer>> printSubS(int[] arr, int idx, ArrayList<Integer> output, List<ArrayList<Integer>> ans, int target, int currentSum) {
        if (idx >= arr.length) {
            if (currentSum == target) {
                ans.add(new ArrayList<>(output));
            }
            return ans;
        }
        output.add(arr[idx]);
        printSubS(arr, idx + 1, output, ans, target, currentSum + arr[idx]);
        output.remove(output.size() - 1);
        printSubS(arr, idx + 1, output, ans, target, currentSum);
        return ans;
    }

    //printSubSII(arr, idx, new StringBuilder());  // Use StringBuilder to build the subsequences

}
