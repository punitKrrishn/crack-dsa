package BackTracking;

public class ArrayPermutationsUsingSwap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        findPermute(arr, 0);
    }

    private static void findPermute(int[] arr, int idx) {
        if (idx == arr.length) {
            printArray(arr);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            findPermute(arr, idx + 1);
            swap(arr, idx, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
