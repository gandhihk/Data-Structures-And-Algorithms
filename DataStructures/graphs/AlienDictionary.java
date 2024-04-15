package ds.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = { "baa", "abcd", "abca", "cab", "cad" };

        printOrder(words);
    }

    static void printOrder(String[] words){
        int[] freq = new int[26];               //frequency of chars

        int N = words.length;
        int count = 0;                          //count of unique chars
        for(int i=0; i<N; i++){
            String word = words[i];
            for(int j=0; j<word.length(); j++){
                freq[word.charAt(j)-'a']++;
                if(freq[word.charAt(j)-'a']==1)
                    count++;
            }
        }

        // Create adjacency list for the graph
        List<Integer>[] adjList = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Build the graph by iterating through adjacent words
        for(int i=0; i<N-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int j=0;
            while(j<word1.length() && j<word2.length()){            //compare each char of these 2 words
                if(word1.charAt(j)!=word2.charAt(j)){               //if char don't match, then add edge between those chars in adjList
                    addEdge(adjList, word1.charAt(j), word2.charAt(j));
                    break;
                }else j++;
            }
        }

        List<Integer> ans = topologicalSortUsingKahnAlgo(adjList);
        System.out.print(ans);
    }

    static List<Integer> topologicalSortUsingKahnAlgo(List<Integer>[] adjList){
        int[] inDegree = new int[adjList.length];
        //count the indegrees for all nodes
        for(int i=0; i<adjList.length; i++){
            for(int adj: adjList[i])
                inDegree[adj]++;
        }

        List<Integer> sorted = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<adjList.length; i++)
            if(inDegree[i]==0)          //add all 0 indegree nodes to queue
                queue.add(i);

        while(!queue.isEmpty()){
            int node = queue.poll();
            sorted.add(node);

            for(int adj: adjList[node]){
                inDegree[adj]--;                //decrement indegree of adj node
                if(inDegree[adj]==0)            //if indegree becomes 0, then add it to queue
                    queue.add(adj);
            }
        }

        return sorted;
    }

    static void addEdge(List<Integer>[] adjList, char c1, char c2){
        adjList[c1-'a'].add(c2-'a');
    }
}
