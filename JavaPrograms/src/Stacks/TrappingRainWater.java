package Stacks;

import java.util.ArrayList;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // Call the method to calculate the trapped rainwater
        TrappingRainWater obj = new TrappingRainWater();
        System.out.println("Trapped Water: " + obj.trappingRainWater(arr));
    }

    private int trappingRainWater(int[] arr) {
        // Create arrays to store the maximum height from left and right
        ArrayList<Integer> maxHeightLeft = new ArrayList<>();
        ArrayList<Integer> maxHeightRight = new ArrayList<>();

        // Now calculate the trapped water
        int trappedWater = 0;

        // Compute maxLeft array
        int maxElementLeft = arr[0];
        maxHeightLeft.add(maxElementLeft);
        for (int i = 1; i < arr.length; i++) {
            maxElementLeft = Math.max(maxElementLeft, arr[i]);
            maxHeightLeft.add(maxElementLeft);
        }

        // Compute maxRight array
        int maxElementRight = arr[arr.length - 1];
        maxHeightRight.add(maxElementRight);
        for (int i = arr.length - 2; i >= 0; i--) {
            maxElementRight = Math.max(maxElementRight, arr[i]);
            maxHeightRight.add(maxElementRight);
        }

        // Reverse the maxRight array to match the indices of maxLeft
        ArrayList<Integer> reversedMaxRight = new ArrayList<>();
        for (int i = maxHeightRight.size() - 1; i >= 0; i--) {
            reversedMaxRight.add(maxHeightRight.get(i));
        }

        for (int i = 0; i < arr.length; i++) {
            int waterAtCurrent = Math.min(maxHeightLeft.get(i), reversedMaxRight.get(i)) - arr[i]; // subtract the height of tower
            if (waterAtCurrent > 0) {
                trappedWater += waterAtCurrent;
            }
        }

        return trappedWater;
    }
}
