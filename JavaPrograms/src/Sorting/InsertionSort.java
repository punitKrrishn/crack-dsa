package Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5,3,2,6,3,2,1};
        insertionSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {  // Outer loop

            for (int j = i + 1; j > 0; j--) {  // Inner loop : here j > 0  becoz first element is already sorted

                if (arr[j] < arr[j - 1]) {  // Compare current element with the previous one
                    // Swap the elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;  // If the current element is in the right place, break the inner loop
                }
            }
        }
    }
}
