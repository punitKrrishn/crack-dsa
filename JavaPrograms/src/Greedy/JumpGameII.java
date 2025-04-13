package Greedy;

public class JumpGameII {


    public static void main(String[] args) {
        JumpGameII game = new JumpGameII();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(game.jumpOptimal(nums1));

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(game.jumpOptimal(nums2));
    }

    private int jumpHelper(int[] nums, int index, Integer[] memo) {

        if (index >= nums.length - 1) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        int minJumps = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[index]; i++) {
            int nextIndex = index + i;
            int jumpsFromNext = jumpHelper(nums, nextIndex, memo);
            if (jumpsFromNext != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + jumpsFromNext);
            }
        }

        memo[index] = minJumps;
        return minJumps;
    }


    //---big o n

    public int jumpOptimal(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0; // No jumps needed if only one element

        int jumps = 0;
        int farthest = 0;
        int end = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == end) {
                jumps++;
                end = farthest;
                if (end >= n - 1) break;
            }
        }

        return jumps;
    }
}
