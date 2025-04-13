package Graph;

import java.util.*;

public class Dijkstra {

    // Inner Pair class to store the node and its distance
    static class Pair {
        int node;
        int distance;

        // Constructor
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // Dijkstra's Algorithm to find the shortest path from source to all other nodes in a graph
    public int[] dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];  // dist[i] will store the shortest distance from source to node i
        Arrays.fill(dist, Integer.MAX_VALUE);  // Initialize all distances as infinity
        dist[source] = 0;  // Distance to the source is always 0

        // visited array to track nodes that have been processed
        boolean[] visited = new boolean[n];

        // Min-heap priority queue, stores Pair objects (distance, node)
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pq.offer(new Pair(source, 0));  // Start with the source node (distance 0)

        while (!pq.isEmpty()) {
            Pair current = pq.poll();  // Get the node with the smallest distance
            int currentDist = current.distance;
            int currentNode = current.node;

            // Skip if we've already processed this node
            if (visited[currentNode]) continue;

            // Mark the node as visited
            visited[currentNode] = true;

            // Explore neighbors
            for (int neighbor = 0; neighbor < n; neighbor++) {
                // Check if there is an edge between currentNode and neighbor
                if (graph[currentNode][neighbor] != 0) {
                    int newDist = currentDist + graph[currentNode][neighbor];
                    if (newDist < dist[neighbor]) {  // if the new dist is less than the dist which is already present -- update it
                        dist[neighbor] = newDist;
                        pq.offer(new Pair(neighbor, dist[neighbor]));  // Add neighbor to the queue
                    }
                }
            }
        }

        return dist;  // Return the distance array
    }

    // For testing purposes, you can use this main method to run the algorithm on a sample graph
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();

        // Sample graph represented as an adjacency matrix
        // graph[i][j] represents the weight of the edge between node i and node j
        int[][] graph = {
                {0, 7, 9, 0, 0, 0},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 0},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {0, 0, 0, 0, 9, 0}
        };

        int source = 0;  // Start from node 0
        int[] dist = dijkstra.dijkstra(graph, source);

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }
}
