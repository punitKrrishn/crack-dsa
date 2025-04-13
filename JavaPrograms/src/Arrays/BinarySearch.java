package Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};  // Sorted array
        int target = 1;  // Example target value
       // int result = binarySearch(arr, target);
        int result = binarySearchRec(arr, target,0,arr.length);

        if (result == -1) {
            System.out.println("Target not found.");
        } else {
            System.out.println("Target found at index: " + result);
        }
    }
    public static int binarySearch(int[] arr, int target) {

        int s = 0;
        int e = arr.length-1;

        while (s <= e) {

            int mid = s + (e-s)/2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) { // goes left
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearchRec(int[] arr, int target, int s, int e){
        if(s>e) {
            return -1;
        }
        int mid = s +(e-s)/2;

        if(target == arr[mid]) {
            return mid;
        }
        if(arr[mid] > target) {
            return binarySearchRec(arr,target,s,mid-1);
        }else {
            return binarySearchRec(arr,target,mid+1,e);
        }

    }
}
