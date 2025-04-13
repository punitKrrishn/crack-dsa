package TCSNQT_Coding_Questions.Arrays;


import java.util.Scanner;

public class AverageOfArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = sc.nextInt();

        int[] arr = new int[size];

        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        int totalSum = 0;
        for(int ele : arr) {
            totalSum = totalSum + ele;
        }

        float avg = (float) totalSum / size;
        System.out.println("Ans "+avg);
    }
}
