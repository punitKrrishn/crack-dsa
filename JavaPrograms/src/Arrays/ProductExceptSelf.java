package Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
       // int[] result = productExceptSelf(nums);
        int[] result = productExceptSelf2(nums);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        // Step 1: Calculate the product for each element except itself
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= arr[j];
                }
            }
            result[i] = product;
        }

        return result;
    }

    public static int[] productExceptSelf2(int[] arr) {

        int n = arr.length;

        // Step 1: Create prefix array
        int[] prefix = new int[n];
        prefix[0] = 1;  // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];  // Compute prefix product
        }

        // Step 2: Create suffix array
        int[] suffix = new int[n];
        suffix[n - 1] = 1;  // No elements to the right of the last element
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];  // Compute suffix product
        }

        // Step 3: Calculate result using prefix and suffix arrays
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];  // The product except self
        }

        return result;

    }
    public static int[] productExceptSelf3(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        // Step 1: Calculate the prefix product and store it in result array
        result[0] = 1;  // No elements to the left of the first one
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * arr[i - 1];  // Multiply previous result by the previous element
        }

        // Step 2: Calculate the suffix product and update the result array
        int suffix = 1; // No elements to the right of the last one
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;  // Multiply current result by suffix
            suffix *= arr[i];  // Update suffix product for next iteration
        }

        return result;
    }

}
