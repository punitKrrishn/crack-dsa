package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerToRight {

    public static void main(String[] args) {
        int[] arr = {1,3,2,4}; // -1,2,-1,-1
        ArrayList<Integer> ans = nextSmallerToRight(arr);
        System.out.println(ans.reversed());
    }
    public static ArrayList<Integer> nextSmallerToRight(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i=n-1; i>=0; i--){

            if(st.empty()) {
                ans.add(-1);
            }
            else if(!st.empty() && st.peek() <= arr[i]) {
                ans.add(st.peek());
            }
            else if(!st.empty() && st.peek() >= arr[i]) {
                while(!st.empty() && st.peek() > arr[i]) {
                    st.pop();
                }
                if(st.empty()) {
                    ans.add(-1);
                }
                else {
                    ans.add(st.peek());
                }
            }
            st.push(arr[i]);
        }
        return ans;
    }

}
