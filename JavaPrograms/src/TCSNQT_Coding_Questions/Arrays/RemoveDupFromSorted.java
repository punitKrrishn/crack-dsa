package TCSNQT_Coding_Questions.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDupFromSorted {

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3,3};

        ArrayList<Integer>  list = new ArrayList<>();
        if(arr.length > 0) {
            list.add(arr[0]);
        }
       for(int i=1; i<arr.length; i++) {
           if(arr[i] != arr[i-1]) {
               list.add(arr[i]);
           }
       }

        System.out.println(list);
    }
}
