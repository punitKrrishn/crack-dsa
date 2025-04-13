package TCSNQT_Coding_Questions.Arrays;

import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {

//        int[] arr = new int[5];
//        arr[0] = 1;
//        arr[1] = 30;
//
//        int[] arr = {1,25,30};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        for(int ele : arr) {
            System.out.print(ele+" ");
        }
        System.out.println();

        // two pointer
        reverseArray(arr);

        for(int ele : arr) {
            System.out.print(ele+" ");
        }
    }
    public static void reverseArray(int[] arr) {
        int i=0;
        int j=arr.length-1;

        while(i < j) {
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
