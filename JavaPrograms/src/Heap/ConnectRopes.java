package Heap;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        int result = connectRopes(ropes);
        System.out.println("Minimum cost to connect ropes: " + result); // Output: 29
    }

    public static int connectRopes(int[] ropes) {
        // Create a min-heap (priority queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all rope lengths to the min-heap
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // While there is more than one rope to combine
        while (minHeap.size() > 1) {
            // Extract the two smallest ropes
            int first = minHeap.poll();
            int second = minHeap.poll();

            // Cost to connect these two ropes
            int cost = first + second;
            totalCost += cost;

            // Add the combined rope back to the heap
            minHeap.add(cost);
        }

        return totalCost;
    }
}
