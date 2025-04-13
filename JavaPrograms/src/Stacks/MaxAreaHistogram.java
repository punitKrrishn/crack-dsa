package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxAreaHistogram {

    // Stock class to store the price and index
    public static class Histogram {
        int height;
        int index;

        // Constructor to initialize price and index
        public Histogram(int height, int index) {
            this.height = height;
            this.index = index;
        }

        // Getter for price
        public int getHeight() {
            return height;
        }

        // Getter for index
        public int getIndex() {
            return index;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};
        ArrayList<Integer> NSLIndies = nextSmallerToLeft(arr);
        ArrayList<Integer> NSRIndies = nextSmallerToRight(arr);
        List<Integer> NSRIndiesRev = NSRIndies.reversed();
        // Calculate width and area for each histogram bar
        int maxArea = 0;

        for(int i=0; i<arr.length; i++) {
            int width = NSRIndiesRev.get(i) - NSLIndies.get(i) -1 ;

            // Calculate area for current bar
            int area = width * arr[i];
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
    }


    public static ArrayList<Integer> nextSmallerToLeft(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Histogram> st = new Stack<>();
        int n = arr.length;

        for(int i=0; i<n; i++) {

            if(st.empty()) {
                ans.add(-1);
            }
            else if(!st.empty() && st.peek().getHeight() < arr[i]) {
                ans.add(st.peek().getIndex());
            }
            else if(!st.empty() && st.peek().getHeight() >= arr[i]) {

                while(!st.empty() && st.peek().getHeight() >= arr[i]) {
                    st.pop();
                }
                if(st.empty()) {
                    ans.add(-1);
                }else {
                    ans.add(st.peek().getIndex());
                }
            }
            st.push(new Histogram(arr[i],i));
        }
        return ans;
    }

    public static ArrayList<Integer> nextSmallerToRight(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Histogram> st = new Stack<>();
        int n = arr.length;

        for(int i=n-1; i>=0; i--){

            if(st.empty()) {
                ans.add(-1);
            }
            else if(!st.empty() && st.peek().getHeight() <= arr[i]) {
                ans.add(st.peek().getIndex());
            }
            else if(!st.empty() && st.peek().getHeight() >= arr[i]) {
                while(!st.empty() && st.peek().getHeight() > arr[i]) {
                    st.pop();
                }
                if(st.empty()) {
                    ans.add(-1);
                }
                else {
                    ans.add(st.peek().getIndex());
                }
            }
            st.push(new Histogram(arr[i],i));
        }
        return ans;
    }

}
