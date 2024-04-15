package ds.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args){
        int[][] prerequisites
                = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        if(possible(4, prerequisites))
            System.out.print("Possible");
        else System.out.print("Not possible");
    }

    static boolean possible(int V, int[][] prerequisites){
        //convert the prerequisites into adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i=0; i<m; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        //create indegree array and populate
        int[] inDegree = new int[V];
        for(int i=0; i<V; i++){
            for(int adj: graph.get(i))
                inDegree[adj]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<V; i++)
            if(inDegree[i]==0)
                queue.add(i);

        List<Integer> sorted = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            sorted.add(node);

            for(int adj: graph.get(node)){
                inDegree[adj]--;
                if(inDegree[adj]==0)
                    queue.add(adj);
            }
        }

        return sorted.size()==V;
    }
}
