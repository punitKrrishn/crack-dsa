package Heap;

import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {
        int[] nums = {2, 6, 3, 12, 56, 8}; // Expected output: [2, 3, 6, 8, 12, 56]
        int k = 3;
        solve(nums, k);
    }

    private static void solve(int[] arr, int k) {
        // Min-heap (PriorityQueue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int j = 0;

        // Step 1: Add elements to the heap
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);

            // Step 2: If the heap size exceeds k+1, poll the smallest element
            if (minHeap.size() > k) {
                arr[j] = minHeap.poll(); // Place the smallest element in the correct position
                j++;
            }
        }

        // Step 3: After processing all elements, there will still be some elements in the heap
        while (!minHeap.isEmpty()) {
            arr[j] = minHeap.poll(); // Place remaining elements in the correct positions
            j++;
        }

        // Step 4: Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
