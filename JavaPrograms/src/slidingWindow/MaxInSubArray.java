package slidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaxInSubArray {
    public static void main(String[] args) {

        int[] arr = {2,4,5,2,6,7,8};
        int k = 3;
        int[] max = maxSlidingWindow(arr,k);
        System.out.println(max);
    }
        public static int[] maxSlidingWindow(int[] nums, int k) {
            int ans[] = new int[nums.length - k + 1];
            Deque<Integer> q = new LinkedList<>();     // A deque to maintain the window elements in decreasing order

            int i = 0;
            int j = 0;

            while(j < nums.length) {
                // Step 1: Add the current element to the deque
                if(q.size() == 0){
                    q.add(nums[j]);  // Add first element directly if the deque is empty
                }
                else{
                    while(q.size() > 0 && q.peekLast() < nums[j]) {
                        q.removeLast();  // Remove all smaller elements at the end of the deque
                    }
                    q.add(nums[j]);  // Add the current element to the deque
                }

                // Step 2: Move the `j` pointer to expand the window
                if(j - i + 1 < k) {
                    j++;  // Expand the window
                }
                // Step 3: Once the window is of size `k`, we need to record the maximum and slide the window
                else if(j - i + 1 == k) {
                    ans[i] = q.peek();  // The maximum value is at the front of the deque
                    // Slide the window:
                    if(nums[i] == q.peek()) {
                        q.removeFirst();  // If the element going out of the window is the maximum, remove it
                    }
                    i++;  // Slide the window by incrementing `i`
                    j++;  // Expand the window by incrementing `j`
                }
            }
            return ans;  // Return the array with the maximums for each window
        }


}
