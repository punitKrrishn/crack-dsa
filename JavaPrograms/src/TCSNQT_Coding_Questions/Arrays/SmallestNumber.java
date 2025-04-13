package TCSNQT_Coding_Questions.Arrays;

public class SmallestNumber {
    public static void main(String[] args) {
        int[] arr = {19,10,12,15,45};

        int smallest = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        System.out.println("Smallest Number "+smallest);
    }
}

