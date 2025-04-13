package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1,8,15,2,5};
        int target = 13;
       // twoSum(arr,target); //Brute Force Approach
       // twoSum2(arr,target); //Using Binary Search
       // twoSum3(arr, target);

    }

    public static void twoSum(int[] arr, int target) {
        boolean found = false;  // Flag to track if a pair is found

        for(int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if(arr[i]+arr[j] == target) {
                    found = true;
                    System.out.print("index of "+i+" index of "+j+" make sum "+target);
                }
            }
        }
        if (!found) {  // If no pair was found, print "none"
            System.out.println("none");
        }
    }

    public static void twoSum2(int[] arr, int target) {

        Arrays.sort(arr);
        for (int j : arr) {
            int myTarget = target - j;
            int result = binarySearchRec(arr, myTarget, 0, arr.length-1);
            int ans = j + result;

            if ( ans == target) {

                System.out.print("my target of " + target + " my result of " + result + "+" + j + " : make sum " + target);
                break;

            }
        }
    }

    public static void twoSum3(int[] arr, int target) {
        Arrays.sort(arr);  // Make sure the array is sorted for two-pointer technique

        int s = 0;  // Starting pointer
        int e = arr.length - 1;  // Ending pointer

        while (s < e) {  // Continue while the pointers don't cross
            int sum = arr[s] + arr[e];  // Calculate the sum of the two elements

            if (sum == target) {
                System.out.println("Found: " + arr[s] + " + " + arr[e] + " = " + target);
                s++;  // Move the start pointer to the right to find other pairs
                e--;  // Move the end pointer to the left to find other pairs
            } else if (sum < target) {
                s++;  // If sum is less than target, move the start pointer right to increase the sum
            } else {
                e--;  // If sum is greater than target, move the end pointer left to decrease the sum
            }
        }
    }


    public static void twoSum4(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();  // To store numbers and their indices

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];  // Find the complement of the current number

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                System.out.println("Found: " + arr[i] + " + " + complement + " = " + target);
                return;  // Found the pair, exit the function
            }

            // Add the current number to the map
            map.put(arr[i], i);
        }

        System.out.println("No pair found that sums to " + target);  // If no pair is found
    }



    public static int binarySearchRec(int[] arr, int target, int s, int e){
        if(s>e) {
            return -1;
        }
        int mid = s +(e-s)/2;

        if(target == arr[mid]) {
            return arr[mid];
        }
        if(arr[mid] > target) {
            return binarySearchRec(arr,target,s,mid-1);
        }else {
            return binarySearchRec(arr,target,mid+1,e);
        }

    }

}
