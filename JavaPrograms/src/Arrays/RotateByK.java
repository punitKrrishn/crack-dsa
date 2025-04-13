package Arrays;

import java.util.Arrays;

public class RotateByK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        int[] ans = rotateByK(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] rotateByK(int[] arr, int k) {
        int n = arr.length;

        // Handle case where k is greater than the length of the array
        k = k % n;

        reverse(arr,0,n-k-1); //3,4,5
        reverse(arr,n-k,n-1); //1,2
        reverse(arr,0,n-k);
        return arr;
    }

    // Helper method to reverse a part of the array
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
