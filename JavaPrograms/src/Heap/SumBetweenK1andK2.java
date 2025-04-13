package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SumBetweenK1andK2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 11, 12,15};
        int k1 = 3, k2 = 6;
        int k1Smallest = kthSmallest(arr, k1);
        int k2Smallest = kthSmallest(arr, k2);
        int result = findSum(arr, k1Smallest, k2Smallest);
        System.out.println("Sum of elements smaller than k1-th and k2-th smallest: " + result);
    }

    private static int findSum(int[] arr, int k1Smallest, int k2Smallest) {
        int sum = 0;
        for (int num : arr) {
            if (num > k1Smallest && num < k2Smallest) {
                sum += num;
            }
        }
        return sum;
    }

    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
