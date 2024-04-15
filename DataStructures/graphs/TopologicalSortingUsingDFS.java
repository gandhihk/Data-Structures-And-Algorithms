package ds.graphs;

import java.util.Stack;

public class TopologicalSortingUsingDFS {
    public static void main(String[] args){
        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(3, 1);
        g1.addEdge(3, 2);
        topologicalSortUsingDFS(g1);
    }

    static void topologicalSortUsingDFS(Graph g){
        boolean[] visited = new boolean[g.vertices];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<g.vertices; i++){
            if(!visited[i])
                dfs(g, visited, stack, i);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    static void dfs(Graph g, boolean[] visited, Stack<Integer> stack, int node){
        visited[node] = true;

        for(int adj: g.adjList[node]){
            if(!visited[adj])
                dfs(g, visited, stack, adj);
        }

        stack.push(node);
    }
}
