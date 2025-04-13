package Sorting;
import java.util.Arrays;
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,5,36,8,4,9,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr) {

        // i = 0 to n-2 -> n-1 iterations
        for(int i=0; i<arr.length-1; i++) {
            boolean isSwapped = false;
            for(int j=0; j<arr.length-i-1; j++) { // arr.length-i-1 == n-1
                /*
                last i elements are already sorted so
                no needed to check
                 */
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped) { // no need to for next i iteration becoz already sorted
                break;
            }
        }
    }
}
