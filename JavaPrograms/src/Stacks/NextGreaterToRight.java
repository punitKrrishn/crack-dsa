package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterToRight {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8}; // 5,10,10,-1,-1
        System.out.println(Arrays.toString(arr));

        ArrayList<Integer> ans = nextGreaterToRight(arr);
        System.out.println(ans.reversed()); // // Output: 5 10 10 -1 -1

    }
    public static ArrayList<Integer> nextGreaterToRight(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=n-1; i>=0; i--) {
            if(st.empty()) {
                ans.add(-1);
            }
            else if(!st.isEmpty() && st.peek() > arr[i]) {
                ans.add(st.peek());
            }
            else if(!st.isEmpty() && st.peek() <= arr[i]) {
                while (!st.empty() && st.peek() <= arr[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
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
