package Arrays;

import java.util.ArrayList;

public class PrintSubsquenceArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayList<Integer> ans = new ArrayList<>();
        int idx = 0;
        printSubsequence(arr,idx,ans);
    }

    private static void printSubsequence(int[] arr, int idx, ArrayList<Integer> ans) {

        if(idx >= arr.length) {
            System.out.println(""+ans);
            return;
        }
        //include
        ans.add(arr[idx]); //2. added 3 for index 2 and print 1,3
        printSubsequence(arr,idx+1,ans);
        ans.removeLast(); // come to this and remove index 2 element
        printSubsequence(arr,idx+1,ans); //1. now for 2 idx of left subsequence --> 2+1
    }
}
