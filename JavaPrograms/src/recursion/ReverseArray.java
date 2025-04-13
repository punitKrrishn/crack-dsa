package recursion;

import java.util.Scanner;

import static Arrays.Sort01.swap;

public class ReverseArray {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int e : arr) {
            System.out.print(e+" ");
        }
        int s = 0;
        int e = arr.length-1;
        reverseArray(arr,s,e);

        System.out.println();
        for(int ele : arr) {
            System.out.print(ele+" ");
        }
    }
    public static void reverseArray(int[] arr, int s, int e) {

        if(s >= e) {
            return;
        }
        swap(arr,s,e);
        reverseArray(arr,s+1,e-1);
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
