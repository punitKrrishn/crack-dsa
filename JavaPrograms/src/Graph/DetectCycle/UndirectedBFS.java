package Graph;

import java.util.*;

public class UndirectedBFS {

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 0}
        };

        UndirectedBFS bfsObj = new UndirectedBFS();
        boolean hasCycle = bfsObj.bfs(V, edges);
        System.out.println("Cycle detected: " + hasCycle);
    }

    public boolean bfs(int V, int[][] edges) {
        List<List<Integer>> adj = createAdjacencyList(V, edges);
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsWithCycleDetection(i, adj, visited, parent)) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<List<Integer>> createAdjacencyList(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    private boolean bfsWithCycleDetection(int startNode, List<List<Integer>> adj, boolean[] visited, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                    queue.offer(neighbor);
                } else if (neighbor != parent[node]) {
                    return true;
                }
            }
        }

        return false;
    }
}
