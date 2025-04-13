package Arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2};
       // boolean ans = containDuplicate1(arr); // brute force
        // boolean ans = containDuplicate2(arr); // brute force
        boolean ans = containDuplicate3(arr); // brute force

        System.out.println(ans);
    }

    public static boolean containDuplicate(int[] arr) {

        for(int i = 0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    return  true;
                }
            }
        }
        return  false;
    }

    public static boolean containDuplicate2(int[] arr) {

        Arrays.sort(arr); // array becomes 1,2,2,3,4 using two pointer

        // now we just compare the adj elements in array

        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] == arr[i+1]) {
                return true;
            }
        }

        return false;
    }
    public static boolean containDuplicate3(int[] arr){

        HashSet<Integer> map = new HashSet<>();

        for(int i=0; i<arr.length; i++) {
            if(map.contains(arr[i])) {
                return true;
            }else {
                map.add(arr[i]);
            }
        }
        return false;
    }



}

