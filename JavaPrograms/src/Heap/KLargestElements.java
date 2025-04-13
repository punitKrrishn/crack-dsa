package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] nums = {12, 3, 5, 7, 19}; // o/p 3
        int k = 2;
        ArrayList<Integer> ans = solve(nums,k);
        System.out.println(ans);
    }
    public static ArrayList<Integer> solve(int[] arr,int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            minHeap.add(arr[i]);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.remove());
        }
        return ans;
    }
}
