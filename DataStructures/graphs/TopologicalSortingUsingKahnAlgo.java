package ds.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortingUsingKahnAlgo {
    public static void main(String[] args){
        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(3, 1);
        g1.addEdge(3, 2);
        System.out.print(topologicalSortUsingKahnAlgo(g1));
    }

    static List<Integer> topologicalSortUsingKahnAlgo(Graph g){
        int[] inDegree = new int[g.vertices];
        //count the indegrees for all nodes
        for(int i=0; i<g.vertices; i++){
            for(int adj: g.adjList[i])
                inDegree[adj]++;
        }

        List<Integer> sorted = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<g.vertices; i++)
            if(inDegree[i]==0)          //add all 0 indegree nodes to queue
                queue.add(i);

        while(!queue.isEmpty()){
            int node = queue.poll();
            sorted.add(node);

            for(int adj: g.adjList[node]){
                inDegree[adj]--;                //decrement indegree of adj node
                if(inDegree[adj]==0)            //if indegree becomes 0, then add it to queue
                    queue.add(adj);
            }
        }

        return sorted;
    }
}
