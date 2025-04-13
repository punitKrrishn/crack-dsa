package TCSNQT_Coding_Questions.Arrays;


import java.util.HashMap;

public class IsSubsetOfOther {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};  // {1:1,2:0,4:1,5:1}
        int[] a2 = {2, 2, 5};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele : a1) {
            map.put(ele,map.getOrDefault(map.get(ele),0)+1);
        }
        boolean isValid = true;
        for(int ele : a2) {
            if(!map.containsKey(ele) || map.get(ele) == 0) {
                isValid =false;
            }
            map.put(ele, map.get(ele)-1);
        }
        System.out.println(isValid);


    }
}


