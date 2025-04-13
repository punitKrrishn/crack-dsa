package Sorting;

import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3,5,2,6,3,2,1};
        selectionSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted array
            int minIdx = i; // assume i=0th element is the smallest so minIndex => i = 0 then i = 1 min and so on
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) { // compare next every elements with min index element
                    minIdx = j; // update the minIndex becoz we have found the smallest element index
                }
            }

            // Now we swap the assumed ith element with the original small element using minIndex
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

}
