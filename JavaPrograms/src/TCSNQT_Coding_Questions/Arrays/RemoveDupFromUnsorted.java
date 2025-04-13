package TCSNQT_Coding_Questions.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RemoveDupFromUnsorted {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 3, 2, 4, 1, 5};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                System.out.print(arr[i]+" ");
                map.put(arr[i],1);
            }
        }

    }
}
