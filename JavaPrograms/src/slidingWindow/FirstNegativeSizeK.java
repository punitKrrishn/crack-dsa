package slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class  FirstNegativeSizeK {
    public static void main(String[] args) {
        int[] arr = {2, -4, 5, -2, -6, 7, 8};
        int k = 2;
        ArrayList<Integer> ans = firstNegativeSizeK(arr, k);
        System.out.println(ans);
    }

    private static ArrayList<Integer> firstNegativeSizeK(int[] arr, int k) {
        int i = 0;  // Start of the window
        int j = 0;  // End of the window
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();  // Queue to store negative number indices

        while (j < arr.length) {
            // If the current element is negative, add its index to the queue
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }

            // If the window size is less than k, keep expanding the window
            if (j - i + 1 < k) {
                j++;
            } else {
                // Add the first negative number in the current window to the result
                if (!queue.isEmpty()) {
                    ans.add(queue.peekFirst());
                } else {
                    ans.add(0);  // No negative number in this window
                }

                // Slide the window forward
                // If the element at index i is a negative number, remove it from the queue
                if (!queue.isEmpty()) {
                    queue.pollFirst();
                }

                // Move the window forward
                i++;
                j++;
            }
        }

        return ans;
    }
}
