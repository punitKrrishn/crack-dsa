package TCSNQT_Coding_Questions.Arrays;

public class LargestNumber {

    public static void main(String[] args) {
        int[] arr = {19,10,12,15,45};

        int largest = Integer.MIN_VALUE; // -2147483648

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println("Largest Number "+largest);

    }
}
