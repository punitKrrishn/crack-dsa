package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 6, 3, 2, 1};  // Array we want to sort
        int start = 0;
        int end = arr.length - 1;
        divide(arr, start, end);  // Call the divide function to start the sorting
        System.out.print(Arrays.toString(arr));  // Print the sorted array
    }

    // Function to divide the array into two halves recursively
    public static void divide(int[] arr, int start, int end) {
        if (start >= end) {  // Base case: if only one element, it's already sorted
            return;
        }
        int mid = start + (end - start) / 2;  // Find the middle index
        divide(arr, start, mid);  // Recursively divide the left part
        divide(arr, mid + 1, end);  // Recursively divide the right part
        conquer(arr, start, mid, end);  // Merge the two halves
    }

    // Function to merge the two sorted parts back into the original array
    public static void conquer(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];  // Temporary array for merging

        int idx1 = start;  // Pointer for the left part
        int idx2 = mid + 1;  // Pointer for the right part
        int k = 0;  // Pointer for the merged array

        // Compare elements from both parts and add the smaller one to the merged array
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                merged[k++] = arr[idx1++];  // Add from left part
            } else {
                merged[k++] = arr[idx2++];  // Add from right part
            }
        }

        // Add any remaining elements from the left part
        while (idx1 <= mid) {
            merged[k++] = arr[idx1++];
        }

        // Add any remaining elements from the right part
        while (idx2 <= end) {
            merged[k++] = arr[idx2++];
        }

        // Copy the merged array back into the original array
        for (int i = 0, j = start; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
}
