package TCSNQT_Coding_Questions.Arrays;


import java.util.Arrays;

public class SecondSmallestAndLargest {
    public static void main(String[] args) {

        int[] arr = {19,10,12,15,45};

        // 5,2,2
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest && smallest != arr[i]) {
                secondSmallest = arr[i];
            }
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < secondLargest && largest != arr[i]) {
                secondLargest = arr[i];
            }
        }

        System.out.println(secondSmallest+" : "+secondLargest);




    }

}
