package Graph;

import java.util.*;

public class TopologicalSortDFS {

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

        TopologicalSortDFS ts = new TopologicalSortDFS();
        List<Integer> result = ts.topologicalSort(V, prerequisites);
        System.out.println(result);
    }

    public List<Integer> topologicalSort(int V, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : prerequisites) {
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj,i, visited, st);
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;
    }

    public void dfs(List<List<Integer>> adj, int curr,boolean[] visited,Stack<Integer> st) {

        visited[curr] = true;
        for(int neighbour : adj.get(curr)) {
            if(!visited[neighbour]) {
                dfs(adj,neighbour,visited,st);
                visited[neighbour] = true;
            }
        }
        st.push(curr);
    }

}
