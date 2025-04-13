package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentNumber {

    // Pair class to hold the frequency and the number
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3}; // Expected Output: [1, 2]
        int k = 2;
        ArrayList<Integer> ans = solve(nums, k);
        System.out.println(ans);  // Output the result
    }

    private static ArrayList<Integer> solve(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // Populate frequency map
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.first - a.first);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll().first);
        }


        return ans;
    }
}
