package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {5,2,1}; // 0,1,2,3,5,6,7,8 sum of all subsets
        int n = 3;
        int idx = 0;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<Integer> list = printAllSubsetSum(arr,n,idx,sum,ans);
        Collections.sort(list);
        System.out.print(list);
    }

    private static ArrayList<Integer> printAllSubsetSum(int[] arr, int n,int idx,int sum, ArrayList<Integer> ans) {

        if(idx == arr.length) {
            ans.add(sum);
            return ans;
        }
        sum += arr[idx];
        printAllSubsetSum(arr,n,idx+1,sum,ans);
        sum -= arr[idx];

        printAllSubsetSum(arr,n,idx+1,sum,ans);
        return  ans;
    }


}
