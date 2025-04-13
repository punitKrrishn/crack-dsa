package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxRectangle {

    public static class Pair {
        int height;
        int index;

        Pair(int height, int index) {
            this.height = height;
            this.index = index;
        }

        int getHeight() {
            return height;
        }

        int getIndex() {
            return index;
        }
    }

    // Function to compute the next smaller element to the left for each element
    public static ArrayList<Integer> nextSmallerToLeft(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if(st.empty()) {
                ans.add(-1);
            }
            else if(!st.empty() && st.peek().getHeight() < arr[i]) {
                ans.add(st.peek().getIndex());
            }
            else if(!st.empty() && st.peek().getHeight() >= arr[i]) {
                while (!st.empty() && st.peek().getHeight() >= arr[i]) {
                    st.pop();
                }
                if (st.empty()) {
                    ans.add(-1);
                } else {
                    ans.add(st.peek().getIndex());
                }
            }

            st.push(new Pair(arr[i], i));
        }
        return ans;
    }

    // Function to compute the next smaller element to the right for each element
    public static ArrayList<Integer> nextSmallerToRight(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Pair> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            if(st.empty()) {
                ans.add(-1);
            }
            else if(!st.empty() && st.peek().getHeight() < arr[i]) {
                ans.add(st.peek().getIndex());
            }
            else if(!st.empty() && st.peek().getHeight() >= arr[i]) {
                while (!st.empty() && st.peek().getHeight() >= arr[i]) {
                    st.pop();
                }
                if (st.empty()) {
                    ans.add(arr.length); // Use arr.length as the boundary if no smaller element is found
                } else {
                    ans.add(st.peek().getIndex());
                }
            }
            st.push(new Pair(arr[i], i));
        }

        Collections.reverse(ans); // Reverse the list because we processed from right to left
        return ans;
    }

    // Function to compute the maximum area histogram for a row
    private static int mAH(int[] arr) {
        ArrayList<Integer> leftSmallerIndices = nextSmallerToLeft(arr);
        ArrayList<Integer> rightSmallerIndices = nextSmallerToRight(arr);

        int maxArea = 0; // maxArea should be initialized to 0, not -1
        for (int i = 0; i < arr.length; i++) {
            int width = rightSmallerIndices.get(i) - leftSmallerIndices.get(i) - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println("Max Area: " + maximalRectangle(matrix1));  // Expected Output: 6
    }

    // Function to compute the maximum rectangle area
    private static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Create an array to store the modified histogram heights (mahArray)
        int[][] mahArray = new int[row][col];

        // Initialize the first row of mahArray as it is
        for (int j = 0; j < col; j++) {
            mahArray[0][j] = matrix[0][j] - '0'; // Convert '1'/'0' to 1/0
        }

        // Compute the height for each subsequent row
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // If the current cell in matrix is '1', increment the height, otherwise reset to 0
                mahArray[i][j] = (matrix[i][j] == '1') ? (mahArray[i - 1][j] + 1) : 0;
            }
        }

        // Now calculate the maximal area for each row using the helper methods
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            maxArea = Math.max(maxArea, mAH(mahArray[i]));  // For each row, calculate MAH (Maximum Area Histogram)
        }
        return maxArea;
    }
}
