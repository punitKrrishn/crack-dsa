package BackTracking;

import java.util.ArrayList;

public class ArrayPermutations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        ArrayList<Integer> ds = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        findPermute(arr, 0, ds, visited);
    }

    private static void findPermute(int[] arr, int idx, ArrayList<Integer> ds, boolean[] visited) {
        // If the current combination's size is equal to the array length, print the result
        if (idx == arr.length) {
            System.out.println(ds);
            return;
        }

        // Iterate through the array and create permutations
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;  // Mark the element as visited
                ds.add(arr[i]);  // Add the element to the current permutation

                // Recurse to find further permutations
                findPermute(arr, idx + 1, ds, visited);

                // Backtrack by removing the last element and unmarking it
                ds.remove(ds.size() - 1);
                visited[i] = false;
            }
        }
    }
}
