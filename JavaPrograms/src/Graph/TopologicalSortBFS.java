package Graph;

import java.util.*;

public class TopologicalSortBFS {

    public static void main(String[] args) {
        int V = 6;
        int[][] prerequisites = {
                {5, 2},
                {5, 0},
                {4, 0},
                {4, 1},
                {2, 3},
                {3, 1}
        };

        TopologicalSortBFS ts = new TopologicalSortBFS();
        List<Integer> result = ts.topologicalSort(V, prerequisites);
        System.out.println(result);
    }

    public List<Integer> topologicalSort(int V, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : prerequisites) {
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);  // Add edge v -> u
            inDegree[u]++;  // Increment in-degree for u
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topologicalOrder = new ArrayList<>();

        // Add all nodes with in-degree 0 to the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalOrder.add(node);

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (topologicalOrder.size() == V) {
            return topologicalOrder;
        } else {
            return new ArrayList<>();
        }
    }
}
