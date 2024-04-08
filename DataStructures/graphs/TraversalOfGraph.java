package ds.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph{
    int vertices;
    List<Integer>[] adjList;
    @SuppressWarnings("unchecked") Graph(int vertices)
    {
        this.vertices = vertices;
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjList[i] = new ArrayList<>();
    }

    // Function to add an edge to the graph
    void addEdge(int u, int v) { adjList[u].add(v); }

    public void bfs(int startNode){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        queue.add(startNode);
        visited[startNode]=true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.println(node);

            for(int adj : adjList[node]){
                if(!visited[adj]){
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }

    public void dfs(int node, boolean[] visited){
        visited[node] = true;
        System.out.print(node+" ");

        for(int adj: adjList[node]){
            if(!visited[adj])
                dfs(adj, visited);
        }
    }

    public void dfsUtil(int node){
        boolean[] visited = new boolean[vertices];
        dfs(node, visited);
    }
}

public class TraversalOfGraph {
    public static void main(String[] args)
    {
        // Number of vertices in the graph
        int vertices = 5;

        // Create a graph
        Graph graph = new Graph(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        // Perform BFS traversal starting from vertex 0
        System.out.print(
                "Breadth First Traversal starting from vertex 0: ");
        graph.bfs(0);

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.print(
                "Depth First Traversal starting from vertex 0: ");
        g.dfsUtil(2);
    }
}
