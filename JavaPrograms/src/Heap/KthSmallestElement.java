package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] nums = {12, 3, 5, 7, 19}; // o/p 3
        int k = 2;
        int ans = solve(nums,k);
        System.out.println(ans);
    }
    private static int solve(int[] arr, int k) {
        // if we sort the array we get the ans
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<arr.length; i++) {
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();

    }
}
