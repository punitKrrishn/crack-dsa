package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,5,8,13,17,20,25};
        int target = 8;
        int end = arr.length-1;
        int start = 0;
        int ans = binarySearch(arr,start,end,target);
        System.out.print(ans);
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {

        if(start > end) {
            return -1;
        }
        int mid = start + (end-start)/2;

        if(target == arr[mid]) {
            return mid;
        }
        if (target < arr[mid]) {
            return binarySearch(arr,start,mid-1,target);
        }else {
            return binarySearch(arr,mid+1,end,target);
        }


    }


}
