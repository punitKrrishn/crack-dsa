package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterToLeft {
    public static void main(String[] args) {
     int[] arr = {4, 5, 2, 10, 8}; // -1,-1,5,-1,10
     ArrayList<Integer> ans = nextGreaterElement(arr);
     System.out.println(ans);
    }
    public static ArrayList<Integer> nextGreaterElement(int[] arr) {

        Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>(); // store the element lesser than curr
        int n = arr.length;

        for(int i=0; i<n; i++) {

            if(st.empty()) {
                ans.add(-1);
            }

           else if(!st.empty() && st.peek() > arr[i]) {
                    ans.add(st.peek());
            }
            else if (!st.empty() && st.peek() <= arr[i]) {

                while(!st.empty() && st.peek() <= arr[i]) {
                    st.pop();
                    }
                    if(st.empty()) { // element not found after removing elements
                        ans.add(-1);
                    }
                    else{
                        ans.add(st.peek()); // if we found the element after removing
                    }
                }
                st.push(arr[i]); // add element in stack for every iteration
        }
        return ans;

    }
}
