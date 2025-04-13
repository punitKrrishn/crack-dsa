package Graph;

import java.util.ArrayList;
import java.util.List;

public class MyGraph {

    class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }

    public void createGraphMatrix(int[][] matrix,int[][] edges,boolean isDirected) {
            for(int[] e : edges) {
                int u = e[0];
                int v = e[1];

                if(isDirected) {
                    matrix[u][v] = 1;
                }else {
                    matrix[u][v] = 1;
                    matrix[v][u] = 1;
                }
            }
    }
    public void createAdjList(List<List<Integer>> adjList,int[][] edges,boolean isDirected) {
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];

            if(isDirected) {
                adjList.get(u).add(v);
            }else {
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
    }
    public void createAdjListWithWeight(List<List<Pair>> adjListPair,int[][] edges,boolean isDirected) {
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if(isDirected) {
                adjListPair.get(u).add(new Pair(u,v));
            }else {
                adjListPair.get(u).add(new Pair(v, w));
                adjListPair.get(v).add(new Pair(u, w));
            }
        }
    }
    public void printAdjMatrix(int[][] adjMatrix) {
        for(int i=0; i<adjMatrix.length; i++) {
            for(int j=0; j<adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j]+", ");
            }
            System.out.println();
        }
    }

    public void printAdjList(List<List<Integer>> adjList) {
        for(int i=0; i<adjList.size(); i++) {
            for(int j=0; j<adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j)+", ");
            }
            System.out.println();
        }
    }

    public void printWeightedList(List<List<Pair>> adjListWithWeight) {
        for (int i = 0; i < adjListWithWeight.size(); i++) {
            System.out.print(i + " -> ");
            for (Pair p : adjListWithWeight.get(i)) {
                System.out.print(p.node + " (weight " + p.weight + "), ");
            }
            System.out.println();
        }
    }
    public void printDegree(int[][] edges, int nodes, boolean isDirected) {
        // Array to store the degree of each node
        int[] degree = new int[nodes];

        // Loop through each edge in the graph
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (isDirected) {
                degree[from] = degree[from] + 1;
            } else {
                degree[from] = degree[from] + 1;
                degree[to] = degree[to] + 1;
            }


        }

        // Print the degree of each node
        for (int i = 0; i < nodes; i++) {
            System.out.println("Degree of node " + i + ": " + degree[i]);
        }
    }
    public ArrayList<Integer> dfs(int node, List<List<Integer>> adj, boolean[] visited,ArrayList<Integer> ans) {
        visited[node] =true;
        ans.add(node);
        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour]) {
                dfs(neighbour,adj,visited,ans);
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        int[][] edges = {{0,2},{0,1},{1,3}};
        int nodes = 4;
        int[][] adjMatrix = new int[nodes][nodes];

        MyGraph myGraph = new MyGraph();
        myGraph.createGraphMatrix(adjMatrix,edges,false);
        myGraph.printAdjMatrix(adjMatrix);

        // Create adjList
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<nodes; i++){
            adjList.add(new ArrayList<>());
        }
        myGraph.createAdjList(adjList,edges,false);
        System.out.println("Print Adj List");
        myGraph.printAdjList(adjList);
        myGraph.printDegree(edges,nodes,false);

        // Create adjList with weight
        int[][] edgesWithWeight = {{0,2,10},{0,1,20},{1,3,30}};
        List<List<Pair>> adjListWithWeight = new ArrayList<>();
        for(int i=0; i<nodes; i++){
            adjListWithWeight.add(new ArrayList<>());
        }

        myGraph.createAdjListWithWeight(adjListWithWeight,edgesWithWeight,false);
        myGraph.printWeightedList(adjListWithWeight);

        // call dfs on adj list
        // DFS on adj list
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                ArrayList<Integer> dfsResult = myGraph.dfs(i, adjList, visited, new ArrayList<>());
                System.out.println("DFS result from node " + i + ": " + dfsResult);
            }
        }
    }
}
