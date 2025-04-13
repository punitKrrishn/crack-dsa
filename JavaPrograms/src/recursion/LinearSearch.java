package recursion;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {};
        int ans = linearSearch(arr,2,0);
        System.out.println(ans);
    }
    public static int linearSearch(int[] arr,int target, int idx) {
        //f(n) = f(n-1) or f(n)
        if(idx >= arr.length) {
            return -1;
        }
        if(arr[idx] == target) {
            return idx;
        }
        return linearSearch(arr,target,idx+1);


    }

}
