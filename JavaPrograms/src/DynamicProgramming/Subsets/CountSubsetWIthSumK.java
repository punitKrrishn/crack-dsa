package DynamicProgramming.Subsets;

public class CountSubsetWIthSumK {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int n  = arr.length;
        int target = 3;
        int ans = solve(n-1,target,arr);
        System.out.println(ans);
    }


    private static int solve(int idx,int target, int[] arr) {

        if(target == 0) {
            return 1;
        }
        if (idx == 0) {
            return arr[idx] == target ? 1 : 0;
        }

        int notPick = solve(idx-1,target,arr);
        int pick = 0;
        if(arr[idx] <= target) {
            pick  = solve(idx-1,target-arr[idx],arr);
        }

        return pick + notPick;

    }
}
