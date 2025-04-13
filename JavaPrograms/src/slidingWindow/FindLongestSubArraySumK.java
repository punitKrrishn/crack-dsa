package slidingWindow;

//Variable sliding window only farak in this check for the greater so here 3 condition use <, ==, >
public class FindLongestSubArraySumK {

    public static void main(String[] args) {
        int[] arr = {4,1,1,1,2,3,5};
        int sum = 5;
        int ans = findLongestSubArraySizeK(arr,sum);
        System.out.println(ans);
    }

    private static int findLongestSubArraySizeK(int[] arr, int k) {

        int i=0;
        int j=0;
        int longest = 0;
        int sum = 0;

        while(j<arr.length) {

            sum = sum + arr[j];

            if(sum < k) {  // j-i+1 here is sum
             j++;
            }
            else if(sum == k) {
                longest = Math.max(longest,j - i + 1);
                j++;
            }
            else if(sum > k) {
                while (sum > k) {
                    sum = sum - arr[i];
                    i++;
                }
                if(sum == k){
                    longest = Math.max(longest, j - i + 1);
                }
                j++;
            }
        }
    return longest;
    }
}
