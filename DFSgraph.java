// IMPLEMENTATION OF DFS GRAPH

// PROGRAM CODING

import java.util.*;

public class DFSgraph {
    static class Graph {
        private int V; // Number of vertices
        private LinkedList<Integer>[] adjList; // Adjacency list

        // Constructor to initialize the graph
        public Graph(int V) {
            this.V = V;
            adjList = new LinkedList[V]; // Create adjacency list array
            for (int i = 0; i < V; i++) {
                adjList[i] = new LinkedList<>(); // Initialize each LinkedList
            }
        }

        // Method to add an edge to the graph
        public void addEdge(int v, int w) {
            adjList[v].add(w); // Add w to v's list
            adjList[w].add(v); // Add v to w's list (undirected graph)
        }

        // Method to perform DFS traversal
        public void DFS(int start) {
            boolean[] visited = new boolean[V]; // Array to keep track of visited nodes
            DFSUtil(start, visited); // Start DFS from the given node
        }

        // Utility method for DFS recursion
        private void DFSUtil(int v, boolean[] visited) {
            visited[v] = true; // Mark the current node as visited
            System.out.print(v + " "); // Print the current node
            
            // Recur for all the vertices adjacent to this vertex
            for (int adj : adjList[v]) {
                if (!visited[adj]) { // If the adjacent node hasn't been visited
                    DFSUtil(adj, visited); // Recursively visit it
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5); // Create a graph with 5 vertices
        g.addEdge(0, 1); // Add an edge between vertex 0 and vertex 1
        g.addEdge(0, 2); // Add an edge between vertex 0 and vertex 2
        g.addEdge(1, 2); // Add an edge between vertex 1 and vertex 2
        g.addEdge(1, 3); // Add an edge between vertex 1 and vertex 3
        g.addEdge(3, 4); // Add an edge between vertex 3 and vertex 4
        g.DFS(0); // Start DFS traversal from vertex 0
    }
}



// OUTPUT
Note: DFSgraph.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
0 2 1 3 4
