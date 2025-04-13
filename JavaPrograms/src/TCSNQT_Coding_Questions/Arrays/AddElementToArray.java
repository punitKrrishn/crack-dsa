package TCSNQT_Coding_Questions.Arrays;

import java.util.Scanner;

public class AddElementToArray {

    public static void main(String[] args) {

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

        // naya element
        int x = sc.nextInt();

        int[] newArray = new int[size+1];

        for(int i=0; i<size; i++) {
            newArray[i] = arr[i];
        }
        newArray[size] = x;

        for(int ele : newArray) {
            System.out.print(ele+" ");
        }
        System.out.println();

    }


}
