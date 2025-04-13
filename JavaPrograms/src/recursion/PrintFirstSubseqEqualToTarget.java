package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintFirstSubseqEqualToTarget {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        int target = 3;
        int idx = 0;
        ArrayList<Integer> output = new ArrayList<>();
        List<ArrayList<Integer>> res = new ArrayList<>();
        if (printFirstSubS(arr, idx, output, res, target, 0)) {
            System.out.println(res.get(0));
        } else {
            System.out.println("No subsequence found");
        }
    }

    private static boolean printFirstSubS(int[] arr, int idx, ArrayList<Integer> output, List<ArrayList<Integer>> res, int target, int currentSum) {
        if (idx >= arr.length) {
            if (currentSum == target) {
                res.add(new ArrayList<>(output));
                return true;
            }
            return false;
        }

        output.add(arr[idx]);
        if (printFirstSubS(arr, idx + 1, output, res, target, currentSum + arr[idx])) {
            return true;
        }

        output.remove(output.size() - 1);
        return printFirstSubS(arr, idx + 1, output, res, target, currentSum);
    }
}
