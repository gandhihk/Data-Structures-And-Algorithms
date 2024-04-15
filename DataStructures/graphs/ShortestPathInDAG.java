package ds.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    Integer V, weight;
    Pair(int V, int weight){
        this.V = V; this.weight = weight;
    }
}

class WeightedDAG{
    int vertices;
    List<Pair>[] adjList;
    WeightedDAG(int vertices)
    {
        this.vertices = vertices;
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjList[i] = new ArrayList<>();
    }

    void addEdge(int u, int v, int weight) { adjList[u].add(new Pair(v, weight)); }
}
public class ShortestPathInDAG {
    public static void main(String[] args){
        WeightedDAG g = new WeightedDAG(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.println("Following are shortest distances "+
                "from source " + s );
        shortestPath(g, s);
    }

    static void shortestPath(WeightedDAG g, int startNode){
        //Step 1: find topological sorting order
        Stack<Integer> sorted = topologicalSortingUsingDFS(g);

        //Step 2: find distances for each node in the topo order
        int[] dist = new int[g.vertices];           //create distance array
        for(int i=0; i<g.vertices; i++)
            dist[i] = Integer.MAX_VALUE;            //initialize with MAX values
        dist[startNode] = 0;            //set distance of starting node as 0

        while(!sorted.isEmpty()){       //for all stack nodes
            int node = sorted.pop();

            if(dist[node]!=Integer.MAX_VALUE)           //if current node's distance is not yet calculated, then skip this node since its adjacent node's distance cannot be calculated at this point
                for(Pair p: g.adjList[node]){           //if it is calculated, then for all its adjacent nodes
                    if(dist[p.V] > dist[node]+p.weight)             //if adj node's distance > curr node's distance + distance between curr and adj node
                        dist[p.V] = dist[node] + p.weight;          //then update its distance
                }
        }

        for(int i=0; i<g.vertices; i++)
            System.out.print(dist[i]+", ");
    }

    static Stack<Integer> topologicalSortingUsingDFS(WeightedDAG g){
        boolean[] visited = new boolean[g.vertices];

        Stack<Integer> sortedOrder = new Stack<>();
        for(int i=0; i<g.vertices; i++){
            if(!visited[i])
                dfs(g, visited, i, sortedOrder);
        }
        return sortedOrder;
    }

    static void dfs(WeightedDAG g, boolean[] visited, int node, Stack<Integer> stack){
        visited[node] = true;

        for(Pair p: g.adjList[node]){
            if(!visited[p.V])
                dfs(g, visited, p.V, stack);
        }

        stack.push(node);
    }
}
