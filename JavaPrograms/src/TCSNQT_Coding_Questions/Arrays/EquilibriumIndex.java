package TCSNQT_Coding_Questions.Arrays;

public class EquilibriumIndex {

    public static void main(String[] args) {

        int[] arr = {1,-1,4}; // output 2

        int ans = findPoint(arr);

        System.out.println(ans);
    }

    private static int findPoint(int[] arr) {

        int totalSum = 0;
        int leftSum = 0;

        for(int ele : arr) {
            totalSum += ele;
        }
        for(int i=0; i<arr.length; i++) {
            if(leftSum == totalSum-leftSum-arr[i]) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;

    }


}
