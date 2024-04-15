package ds.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBipartite {
    public static void main(String[] args)
    {
        // Create a graph given in the above diagram
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 1);
        g1.addEdge(2, 3);
        g1.addEdge(0, 3);
        g1.addEdge(3, 0);
        g1.addEdge(3, 2);
        if (isBipartiteBFS(g1))
            System.out.println("Graph is bipartite");
        else
            System.out.println("Graph isn't bipartite");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (isBipartiteDFS(g2))
            System.out.println("Graph is bipartite");
        else
            System.out.println("Graph isn't bipartite");
    }

    static boolean isBipartiteDFS(Graph g){
        int[] color = new int[g.vertices];
        for(int i=0; i<g.vertices; i++)
            color[i]=-1;

        for(int i=0; i<g.vertices; i++){
            if(color[i]==-1)
                if(!bipartiteDFS(g, color, i, 0))
                    return false;
        }
        return true;
    }

    static boolean bipartiteDFS(Graph g, int[] color, int node, int newColor){
        color[node] = newColor;

        for(int adj: g.adjList[node]){
            if(color[adj]==-1)
                if(!bipartiteDFS(g, color, adj, getColor(newColor)))
                    return false;
            else if(color[adj]==color[node])
                return false;
        }
        return true;
    }

    static boolean isBipartiteBFS(Graph g){
        int[] color = new int[g.vertices];
        for(int i=0; i<g.vertices; i++)
            color[i]=-1;

        for(int i=0; i<g.vertices; i++){
            if(color[i]==-1)
                if(!bipartiteBFS(g, color, i))
                    return false;
        }
        return true;
    }

    static boolean bipartiteBFS(Graph g, int[] color, int startNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        color[startNode] = 0;           //set color for first node

        while(!queue.isEmpty()){
            int node = queue.poll();
            int nodeColor = color[node];        //get color of current node

            for(int adj: g.adjList[node]){
                if(color[adj]==-1){                 //if adj is not visited, then mark its color as opposite color
                    color[adj] = getColor(nodeColor);
                    queue.add(adj);
                }else if(color[node]==color[adj])       //if adj is visited and its color is same as current node, then graph is not bipartite
                    return false;
            }
        }
        return true;
    }

    static int getColor(int color){
        return color==0?1:0;
    }
}
