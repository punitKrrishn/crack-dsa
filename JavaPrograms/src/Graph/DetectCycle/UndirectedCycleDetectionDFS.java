package Graph.DetectCycle;

import java.util.*;

public class UndirectedCycleDetectionDFS {

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 0}  // Cycle between 0 and 5
        };

        UndirectedCycleDetectionDFS cycleDetection = new UndirectedCycleDetectionDFS();
        boolean hasCycle = cycleDetection.detectCycle(V, edges);
        System.out.println("Graph has cycle: " + hasCycle);
    }

    public boolean detectCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);  // For undirected graph, add both directions
        }

        boolean[] visited = new boolean[V];

        // Check for cycles in all connected components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, -1)) {  // -1 means no parent for the starting node
                    return true;  // Cycle detected
                }
            }
        }
        return false;  // No cycle detected
    }

    // DFS helper function
    public boolean dfs(List<List<Integer>> adj, int node, boolean[] visited, int parent) {
        visited[node] = true;

        // Explore all neighbors of the current node
        for (int neighbor : adj.get(node)) {
            // If the neighbor is not visited, continue DFS
            if (!visited[neighbor]) {
                if (dfs(adj, neighbor, visited, node)) {
                    return true;
                }
            }
            // If the neighbor is visited and is not the parent, we've found a cycle
            else if (neighbor != parent) {
                return true;  // Cycle detected
            }
        }

        return false;  // No cycle found in this path
    }
}
