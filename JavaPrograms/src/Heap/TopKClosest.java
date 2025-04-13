package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TopKClosest {
    static class Pair {
        int first;
        int second;

        Pair(int diff, int num) {
            this.first = diff;
            this.second = num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 3, 12, 56, 8};
        int k = 2;
        int x = 56;
        ArrayList<Integer> ans = solve(nums, k, x);
        System.out.println(ans);
    }

    private static ArrayList<Integer> solve(int[] arr, int k, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->{
           if(a.first == b.first) {
               return Integer.compare(b.second,a.second);
           }
           return Integer.compare(b.first,a.first);
        });

        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            maxHeap.add(new Pair(diff, arr[i]));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        while (!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll().second);
        }

        // Collections.sort(ans);
        return ans;
    }
}
