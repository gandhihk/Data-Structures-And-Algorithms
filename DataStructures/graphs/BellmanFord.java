package ds.graphs;

public class BellmanFord {
    class Edge {
        int src, dest, weight;
        Edge() { src = dest = weight = 0; }
    };

    int V, E;
    Edge edge[];

    // Creates a graph with V vertices and E edges
    BellmanFord(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    public static void main(String[] args){
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        BellmanFord graph = new BellmanFord(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or B-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        // Function call
        int[] dist = findShortestPathUsingBellmanFord(graph, 0);
        for(int i=0; i<V; i++)
            System.out.print(dist[i]+" ");
    }

    static int[] findShortestPathUsingBellmanFord(BellmanFord g, int startNode){
        Edge[] edges = g.edge;
        int[] dist = new int[g.V];
        // Step 1: Initialize distances from src to all
        // other vertices as INFINITE
        for(int i=0; i<g.V; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[startNode] = 0;

        // Step 2: Relax all edges |V| - 1 times
        for(int i=0; i<g.V-1; i++){
            for(Edge e: edges){
                int u = e.src;
                int v = e.dest;
                int weight = e.weight;

                if(dist[v] > dist[u]+weight){
                    dist[v] = dist[u]+weight;
                }
            }
        }

        // Step 3: check for negative-weight cycles
        for(Edge e: edges){
            int u = e.src;
            int v = e.dest;
            int weight = e.weight;

            if(dist[v] > dist[u]+weight){
                System.out.println(
                        "Graph contains negative weight cycle");
                break;
            }
        }
        return dist;
    }
}
