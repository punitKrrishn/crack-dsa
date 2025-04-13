package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    // Pair class to store node and weight
    class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }

    int[][] adjMatrix;
    List<List<Integer>> adjList;
    List<List<Pair>> adjListWithWeight;

    // Constructor to initialize graph with nodes
    Graph(int nodes) {
        adjMatrix = new int[nodes][nodes];
        adjList = new ArrayList<>();
        adjListWithWeight = new ArrayList<>();

        // Initialize adjacency lists for both simple and weighted lists
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }

    // Add edges in the adjacency matrix and adjacency list for undirected/directed graph
    public void addEdgesInMatrix(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2]; // weight of edge

            // Handle adjacency matrix and list (with weights)
            if (isDirected) {
                // For directed graph, add edge in one direction
                adjMatrix[u][v] = w;  // Add weight to the matrix
                adjList.get(u).add(v); // Add vertex v to adjacency list of u
                adjListWithWeight.get(u).add(new Pair(v, w)); // Add Pair (v, w) to weighted adjacency list
            } else {
                // For undirected graph, add edges in both directions
                adjMatrix[u][v] = w;  // Add weight to the matrix
                adjMatrix[v][u] = w;  // Symmetric weight for the undirected edge

                adjList.get(u).add(v);  // Add vertex v to adjacency list of u
                adjList.get(v).add(u);  // Add vertex u to adjacency list of v

                // For weighted adjacency list
                adjListWithWeight.get(u).add(new Pair(v, w));
                adjListWithWeight.get(v).add(new Pair(u, w));
            }
        }
    }

    // Function to print the adjacency matrix
    public void printMatrix() {
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.print("row " + i + " -> ");
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    // Function to print the adjacency list
    public void printList() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " (weight " + adjMatrix[i][adjList.get(i).get(j)] + "), ");
            }
            System.out.println();
        }
    }

    // Function to print the adjacency list with weights
    public void printWeightedList() {
        for (int i = 0; i < adjListWithWeight.size(); i++) {
            System.out.print(i + " -> ");
            for (Pair p : adjListWithWeight.get(i)) {
                System.out.print(p.node + " (weight " + p.weight + "), ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 2, 10}, {0, 1, 20}, {1, 3, 30}}; // Directed graph edges with weights
        int[][] edgesWithWeight = {{0, 2, 10}, {0, 1, 20}, {1, 3, 30}}; // Same edges with weights

        int nodes = 4;
        Graph graph = new Graph(nodes);

        // Adding edges in the adjacency matrix and list for undirected graph
        System.out.println("Undirected Graph:");
        graph.addEdgesInMatrix(edges, false);

        // Adding edges in the adjacency matrix and list for directed graph
        System.out.println("Directed Graph:");
        graph.addEdgesInMatrix(edgesWithWeight, true);

        // Printing the adjacency matrix and list
        System.out.println("Adjacency Matrix:");
        graph.printMatrix();
        System.out.println("Adjacency List:");
        graph.printList();
        System.out.println("Weighted Adjacency List:");
        graph.printWeightedList();
    }
}
