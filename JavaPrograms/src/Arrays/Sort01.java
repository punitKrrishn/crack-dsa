package Arrays;

import java.util.Arrays;

public class Sort01 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1,1};

        sort01(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort01(int[] arr) {

        int i = 0;
        int j = arr.length-1;
        while(i < j) {
            if(arr[i] == 0) {
                i++;
            } else if (arr[j] == 1) {
                j--;
            }
            else {
                swap(arr,i,j);
                i++;
                j--;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
