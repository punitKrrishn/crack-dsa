package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerToLeft {
    public static void main(String[] args) {

        int[] arr = {2,4,6,5,1}; // [-1, 2, 4, 4, -1]

        ArrayList<Integer> ans = nextSmallerToLeft(arr);
        System.out.println(ans);
    }

    public static ArrayList<Integer> nextSmallerToLeft(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i=0; i<n; i++) {

            if(st.empty()) {
                ans.add(-1);
            }
            else if(!st.empty() && st.peek() < arr[i]) {
                ans.add(st.peek());
            }
            else if(!st.empty() && st.peek() >= arr[i]) {

                while(!st.empty() && st.peek() >= arr[i]) {
                    st.pop();
                }
                if(st.empty()) {
                    ans.add(-1);
                }else {
                    ans.add(st.peek());
                }
            }
            st.push(arr[i]);
        }
        return ans;
    }

}
