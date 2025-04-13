package TCSNQT_Coding_Questions.Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ReplaceByRank {

    public static void main(String[] args) {

     /*   Input:  [20, 15, 26, 2, 98, 6]
        Sorted: [2, 6, 15, 20, 26, 98]
        Ranks:   1  2   3   4   5   6
        Output: [4, 3, 5, 1, 6, 2] */

        int[] arr = {20, 15, 26, 2, 98, 6};
        int[] result = replaceArray(arr);

        System.out.println(Arrays.toString(result));
    }

    public static int[] replaceArray(int[] arr) {

        int[] dup = Arrays.copyOf(arr,arr.length);

        Arrays.sort(dup);

        HashMap<Integer,Integer> map = new HashMap<>();

        int rank = 1;
        for(int ele : dup) {
            if(!map.containsKey(ele)) {
                map.put(ele,rank++);
            }
        }

        for(int i=0; i<arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;

    }




}
