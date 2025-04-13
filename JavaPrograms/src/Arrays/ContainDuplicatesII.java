package Arrays;

import java.util.HashSet;

public class ContainDuplicatesII {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,3};
        int k = 3; // abs(i-j) <=k
        //boolean ans = containDuplicateII(arr,k);
        boolean ans = containDupRec(arr,k,0);

        System.out.println(ans);
    }

    public static boolean containDuplicateII(int[] arr,int k) {

        for(int i=0; i<arr.length; i++) {
            for(int j = i + 1; j < arr.length && j <= i + k; j++) {
                if(arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containDupRec(int[] arr, int k, int i) {

        // Base case: If i exceeds the array length, no duplicates found
        if (i >= arr.length) {
            return false;
        }

        // Inner recursive function to check the next k elements
        for (int j = i + 1; j < arr.length && j <= i + k; j++) {
            if (arr[i] == arr[j]) {
                return true; // Duplicate found within range
            }
        }

        // Recur for the next element
        return containDupRec(arr, k, i + 1);
    }

    public static boolean containDuplicateOptimal(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            // If the element is already in the HashSet, we have a duplicate
            if (set.contains(arr[i])) {
                return true;
            }

            // Add the current element to the HashSet
            set.add(arr[i]);

            // Remove the element that is out of the range of k distance
            if (set.size() > k) {
                set.remove(arr[i - k]); // remove the first element i reaches 4
            }
        }

        return false;
    }

}
