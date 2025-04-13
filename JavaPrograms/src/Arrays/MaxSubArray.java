package Arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int ans = maxArraySum(arr);
        //maxSubArray2(arr);
        int ans = maxSubArray3(arr);
        System.out.println(ans);
    }

    public static int maxArraySum(int[] arr) {

        int maxSum = 0;
        int currSum = 0;

        for(int i=0; i<arr.length; i++) {
            currSum = currSum + arr[i];
            maxSum = Math.max(currSum,maxSum);

            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void maxSubArray2(int[] arr) {

        for(int i=0; i<arr.length; i++) {

            for (int j=i; j<arr.length; j++) {

                for(int k=i; k<=j; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println(" ");

            }
            System.out.println();
        }
    }

    public static int maxSubArray3(int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            int currSum = 0;
            for (int j=i; j<arr.length; j++) {
                currSum = currSum + arr[j];
                maxSum = Math.max(currSum,maxSum);
            }
        }
        return maxSum;
    }

}
