package TCSNQT_Coding_Questions.Arrays;


import java.util.HashMap;
import java.util.Map;

public class Frequency {
    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3}; //{1:2,2:2,3:1}

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele : arr) {
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

    }
}
