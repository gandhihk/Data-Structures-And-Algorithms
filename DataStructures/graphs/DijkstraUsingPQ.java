package ds.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class WeightedGraph extends WeightedDAG{
    WeightedGraph(int vertices){
        super(vertices);
    }
    @Override
    void addEdge(int u, int v, int weight) { adjList[u].add(new Pair(v, weight)); adjList[v].add(new Pair(u, weight));}
}

public class DijkstraUsingPQ {
    public static void main(String[] args){
        WeightedGraph g = new WeightedGraph(9);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        int s = 0;
        System.out.println("Following are shortest distances "+
                "from source " + s );
        int[] dist = shortestPath(g, s);
        for(int i=0; i<g.vertices; i++)
            System.out.print(dist[i]+" ");
    }

    static int[] shortestPath(WeightedGraph g, int startNode){
        int[] dist = new int[g.vertices];
        for(int i=0; i<g.vertices; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[startNode] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.weight-b.weight);
        queue.add(new Pair(startNode, dist[startNode]));

        while(!queue.isEmpty()){
            Pair top = queue.poll();            //pick the min dist path

            for(Pair adj: g.adjList[top.V]){            //for all its adj nodes
                if(dist[adj.V] > dist[top.V]+adj.weight){              //if new dist < old dist
                    dist[adj.V] = dist[top.V]+adj.weight;               //update dist with new dist
                    queue.add(new Pair(adj.V, dist[adj.V]));            //add new path to queue
                }
            }
        }

        return dist;
    }
}
