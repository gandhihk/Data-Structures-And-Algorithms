package ds.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUnDirectedGraphBFSAndDFS {
    static class Ele{
        int node, parent;
        Ele(int n, int p){
            node = n; parent = p;
        }
    }

    public static void main(String[] args)
    {
        // Create a graph given in the above diagram
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (isCyclicDFS(g1))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (isCyclicDFS(g2))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }

    static boolean isCyclicBFS(Graph g){
        boolean[] visited = new boolean[g.vertices];
        for(int i=0; i<g.vertices; i++)                     //checking for disconnected nodes as well
            if(!visited[i])
                if(checkCycleBFS(g, visited, i)) return true;      //pass the starting node
        return false;
    }

    static boolean checkCycleBFS(Graph g, boolean[] visited, int startNode){
        List<Integer>[] adjList = g.adjList;
        Queue<Ele> queue = new LinkedList<>();
        queue.add(new Ele(startNode, -1));              //add start node to queue and keep -1 as its parent

        while(!queue.isEmpty()){
            Ele parent = queue.poll();              //get the current node as parent

            for(Integer adj: adjList[parent.node]){           //repeat for all its adj nodes
                if(!visited[adj]){                            //if the adj node is not visited, mark it visited and add to queue with current node as parent
                    visited[adj] = true;
                    queue.add(new Ele(adj, parent.node));
                }else if(adj != parent.parent)              //if adj node is visited and is not same as current node's parent, then cycle found
                    return true;
            }
        }
        return false;
    }

    static boolean isCyclicDFS(Graph g){
        boolean[] visited = new boolean[g.vertices];
        for(int i=0; i<g.vertices; i++)                     //checking for disconnected nodes as well
            if(!visited[i])
                if(checkCycleDFS(g, visited, i, -1)) return true;      //pass the starting node
        return false;
    }

    static boolean checkCycleDFS(Graph g, boolean[] visited, int startNode, int parent){
        visited[startNode] = true;

        for(Integer adj: g.adjList[startNode]){
            if(!visited[adj])
                return checkCycleDFS(g, visited, adj, startNode);
            else if(adj!=parent)
                return true;
        }
        return false;
    }
}
