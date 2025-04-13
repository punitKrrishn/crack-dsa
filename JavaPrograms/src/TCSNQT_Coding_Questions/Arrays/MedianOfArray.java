package TCSNQT_Coding_Questions.Arrays;

public class MedianOfArray {

    public static void main(String[] args) {

        int[] arr = {10,20,800,40,50};

        double ans = findMedian(arr);
        System.out.println(ans);
    }

    private static double findMedian(int[] arr) {

        int n = arr.length;

        if(n % 2 == 0) {
            int midIndex = n/2;
            int midIndex2 = n/2-1;

            return arr[(midIndex+midIndex2)/2];
        }else  {
            return arr[n/2];
        }
    }

}
