package ds.graphs;

public class DetectCycleInDirectedGraphDFS {
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

    static boolean isCyclicDFS(Graph g){
        boolean[] visited = new boolean[g.vertices];
        boolean[] path = new boolean[g.vertices];           //keep track of the path

        for(int i=0; i<g.vertices; i++){
            if(!visited[i])
                if(isCyclic(g, visited, path, i))
                    return true;
        }
        return false;
    }

    static boolean isCyclic(Graph g, boolean[] visited, boolean[] path, int node){
        visited[node] = true;       //mark node as visited
        path[node] = true;             //add node to current path

        for(int adj: g.adjList[node]){              //for all adj nodes
            if(!visited[adj])                       //if not visited, perform dfs on it
                if(isCyclic(g, visited, path, adj))
                    return true;
            else if(path[adj])                      //else if visited and falls in the same current path, then cycle found
                return true;
        }
        path[node] = false;                 //remove this node from current path while going back
        return false;
    }
}
