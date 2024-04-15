package ds.graphs;

import java.util.PriorityQueue;

public class PrimsAlgoMST {
    public static void main(String[] args){
        int graph[][] = new int[][] {{0,1,5},
                {1,2,3},
                {0,2,1}};

        // Function call
        System.out.println(minimumSpanningTreeSum(3,3,graph));
    }

    static int minimumSpanningTreeSum(int n, int m, int[][] matrix){
        WeightedGraph g = new WeightedGraph(n);
        for(int i=0;i<matrix.length;i++)
        {
            int u=matrix[i][0];
            int v=matrix[i][1];
            int wt=matrix[i][2];
            g.addEdge(u, v, wt);
        }

        int sum=0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.weight-b.weight);
        queue.add(new Pair(0, 0));

        while(!queue.isEmpty()){
            Pair top = queue.poll();
            if(visited[top.V])
                continue;

            visited[top.V] = true;
            sum+=top.weight;

            for(Pair adj: g.adjList[top.V]){
                if(!visited[adj.V]){
                    queue.add(new Pair(adj.V, adj.weight));
                }
            }
        }

        return sum;
    }
}
