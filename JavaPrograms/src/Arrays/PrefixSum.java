package Arrays;

public class PrefixSum {

    public static int[] computePrefixSum(int[] arr) {
        // Create a prefix array of the same size as the input array
        int[] prefix = new int[arr.length];

        // Initialize the first element of the prefix array
        prefix[0] = arr[0];

        // Compute the prefix sum for the rest of the array
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        return prefix;
    }

    public static void main(String[] args) {
        // Example input array
        int[] arr = {1, 2, 3, 4, 5};

        // Compute the prefix sum
        int[] prefix = computePrefixSum(arr);

        // For range sum int r, int l for 1 index based array

        //ans = prefix[r]-prefix[l-1];

        // Print the prefix sum array
        System.out.print("Prefix sum array: ");
        for (int i = 0; i < prefix.length; i++) {
            System.out.print(prefix[i] + " ");
        }
    }
}
