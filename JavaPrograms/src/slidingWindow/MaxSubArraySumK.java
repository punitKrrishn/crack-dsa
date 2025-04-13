package slidingWindow;

public class MaxSubArraySumK { // maxisum sub array of size k

    public static void main(String[] args) {
        int[] arr = {2,4,5,2,6,7,8};
        int k = 3;
        int max = findMaxSubArray(arr,k);
        System.out.println(max);
    }

    private static int findMaxSubArray(int[] arr,int k) {

        int i=0;
        int j=0;
        int n = arr.length;
        int sum = 0;
        int maxSum = 0;

        while (j<n) {
            sum += arr[j];

            if(j-i+1 < k) {
                j++;
            } else if (j-i+1 == k) {
                maxSum = Math.max(sum,maxSum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
}
