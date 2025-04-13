package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubSequences {
    public static void main(String[] args) {
        int[] arr = {1,2,3}; // [[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
        int idx = 0;
        ArrayList<Integer> output = new ArrayList<>();
        List<ArrayList<Integer>> ans  = new ArrayList<>();
        List<ArrayList<Integer>> res = printSub(arr,idx,output,ans);
        System.out.println(res);

    }

    private static List<ArrayList<Integer>> printSub(int[] arr, int idx, ArrayList<Integer> output, List<ArrayList<Integer>> ans) {

        if(idx >= arr.length) {
            ans.add(new ArrayList<>(output));
            return ans;
        }
        //include
        output.add(arr[idx]);
        printSub(arr,idx+1,output,ans);
        output.remove(output.size()-1);
        printSub(arr,idx+1,output,ans);

        return ans;


    }

    private static void printSubSII(int[] arr, int idx, StringBuilder output) {
        if (idx == arr.length) {
            System.out.println(output.toString());
            return;
        }

        output.append(arr[idx]);
        printSubSII(arr, idx + 1, output);

        output.deleteCharAt(output.length() - 1);

        printSubSII(arr, idx + 1, output);
    }

}
