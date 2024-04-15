package ds.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgoMST {
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args){
        int V = 4;
        List<Edge> graphEdges = new ArrayList<Edge>(
                List.of(new Edge(0, 1, 10), new Edge(0, 2, 6),
                        new Edge(0, 3, 5), new Edge(1, 3, 15),
                        new Edge(2, 3, 4)));
        minimumSpanningTreeKruskal(graphEdges, V);
    }

    static void minimumSpanningTreeKruskal(List<Edge> edges, int V){
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });

        DisjointSet set = new DisjointSet(V);
        List<Edge> mst = new ArrayList<>();

        for(Edge e: edges){
            int parent1 = set.findParent(e.src);
            int parent2 = set.findParent(e.dest);

            if(parent1!=parent2){
                set.unionBySize(e.src, e.dest);
                mst.add(new Edge(e.src, e.dest, e.weight));
            }
        }

        System.out.println(
                "Following are the edges of the constructed MST:");
        int minCost = 0;
        for (Edge e: mst) {
            System.out.println(e.src + " -- "
                    + e.dest + " == "
                    + e.weight);
            minCost += e.weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    }
}
