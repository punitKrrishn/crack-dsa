package TCSNQT_Coding_Questions.Arrays;


import java.util.HashMap;
import java.util.Scanner;

public class SymmetricPairs {

    public static void main(String[] args) {

        int arr[][] = {{1, 2}, {2, 1}, {3, 4}, {4, 5}, {5, 4}};

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {

            int first = arr[i][0];
            int second = arr[i][1];

            String pair = first+","+second;
            String reverse = second+","+first;
            if(map.containsKey(reverse)) {
                System.out.println(reverse);
            }
            map.put(pair,1);
        }

    }

}
