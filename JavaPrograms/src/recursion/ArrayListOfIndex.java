package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListOfIndex {
    public static void main(String[] args) {
        int[] arr = {4,4,3,4,4}; //1,3,4
        int target = 4;
        int idx = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> output = allIndex(arr,target,idx,ans);
        System.out.print(output.toString());
    }
    public static ArrayList<Integer> allIndex(int[] arr, int target, int idx,ArrayList<Integer> ans) {

            if(idx >= arr.length) {
                return new ArrayList<Integer>();
            }
            if(arr[idx] == target) {
                ans.add(idx);
            }
             allIndex(arr,target,idx+1,ans);
            return ans;
    }
}
