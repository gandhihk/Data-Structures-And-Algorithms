package ds.binarytree;

import java.util.LinkedList;

public class CheckIfGraphIsTree {
	
	private int V; // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency List 
	
	@SuppressWarnings("unchecked")
	CheckIfGraphIsTree(int v) 
    { 
        V = v; 
        adj = new LinkedList[V]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList<Integer>(); 
    } 

	public static void main(String[] args) {
		CheckIfGraphIsTree g1 = new CheckIfGraphIsTree(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        if (g1.isTree()) 
            System.out.println("Graph is Tree"); 
        else
            System.out.println("Graph is not Tree");

	}
	
	// Function to add an edge into the graph 
	void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
        adj[w].add(v); 
    }
	
	// Returns true if the graph is a tree, else false. 
    boolean isTree() 
    { 
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V]; 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
 
        //check if the graph starting from vertex 0 is cyclic 
        if (isCyclic(0, visited, -1)) 
            return false; 
 
        //check if all vertices are reachable
        for (int u = 0; u < V; u++) 
            if (!visited[u]) 
                return false; 
 
        return true; 
    } 
    
    boolean isCyclic(int vertex, boolean visited[], int parent) {
    	visited[vertex] = true;		// Mark the current vertex as visited
    	
    	for(int a: adj[vertex]) {			//for all the adjacent vertices of this vertex
    		if(!visited[a]) {				//if adj vertex is not visited, then recur for its adjacent nodes
    			if(isCyclic(a, visited, vertex))
    				return true;
    		}
    		else if(parent!=a)				//else if its visited and it is not the same as this vertex's parent
    			return true;				//then this is a cycle
    	}
    	return false;
    }

}
