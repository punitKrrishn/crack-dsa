package recursion;

public class MaxInArray {
    public static void main(String[] args) {
        int[] arr = {2,4,8,3,1,5,4};
        int ans = findMax(arr,0);
        System.out.println(ans);
    }
    static int findMax(int[] arr,int idx) {

        if(idx == arr.length-1) {
            return arr[idx];
        }
        int smallAns = findMax(arr,idx+1); // recursion work
        int ans = Math.max(smallAns,arr[idx]);
        return ans;
    }
}
