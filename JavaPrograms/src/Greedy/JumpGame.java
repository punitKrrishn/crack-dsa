public class JumpGame {

    public static void main(String[] args) {
        JumpGame game = new JumpGame();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(game.canJump(nums1)); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(game.canJump(nums2)); // Output: false
    }

    public boolean canJump(int[] nums) {
        int maxReach = 0; // farthest index we can reach

        for (int i = 0; i < nums.length; i++) {
            // If we are at an index that is not reachable, return false
            if (i > maxReach) {
                return false;
            }

            // Update the maxReach
            maxReach = Math.max(maxReach, i + nums[i]);

            // If we can reach or exceed the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        // If we finish the loop and can't reach the last index, return false
        return false;
    }


}
