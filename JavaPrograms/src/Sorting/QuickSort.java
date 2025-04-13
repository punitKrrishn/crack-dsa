package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 6, 3, 2, 1};  // The array we want to sort
        int start = 0;
        int end = arr.length - 1;
        quickSort(arr, start, end);  // Call the quickSort function to sort the array
        System.out.println(Arrays.toString(arr));  // Print the sorted array
    }

    // This function is responsible for sorting the array
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {  // Base case: If start index is less than end, continue sorting
            // Call partition to get the index where the pivot belongs in the sorted array
            int pivotIndex = partition(arr, start, end);

            // Recursively sort the left part of the array (before the pivot)
            quickSort(arr, start, pivotIndex - 1);

            // Recursively sort the right part of the array (after the pivot)
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    // This function divides the array and places the pivot in its correct position
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];  // Take the last element as the pivot
        int i = start - 1;  // i will keep track of the last element that is less than the pivot

        // Loop through the array, except the pivot
        for (int j = start; j < end; j++) {
            // If current element is less than the pivot, swap it to the left side of the pivot
            if (arr[j] < pivot) {
                i++;  // Move i to the next index
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // After the loop, put the pivot in its correct position
        i++;  // Increment i to the position where the pivot should go
        // Swap arr[i] with arr[end] (pivot)
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;  // Return the index where the pivot is placed
    }
}
