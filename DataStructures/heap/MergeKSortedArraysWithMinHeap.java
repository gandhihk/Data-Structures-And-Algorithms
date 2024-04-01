package ds.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArraysWithMinHeap {
    static class MinHeapNode implements Comparable<MinHeapNode>{
        int x, y;
        int value;
        MinHeapNode(int value, int x, int y)
        {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override public int compareTo(MinHeapNode hn)
        {
            if (this.value <= hn.value) {
                return -1;
            }
            else {
                return 1;
            }
        }

        @Override public String toString(){
            return String.valueOf(this.value);
        }
    }

    public static void main(String[] args){

        int[][] arr = { { 2, 6, 12 },
                { 1, 9 },
                { 23, 34, 90, 2000 } };

        System.out.println(mergeKArrays(arr, arr.length).toString());
    }

    static List<MinHeapNode> mergeKArrays(int[][] arr, int K){
        List<MinHeapNode> ans = new ArrayList<>();

        PriorityQueue<MinHeapNode> queue = new PriorityQueue<>();

        //add first element of all K arrays. set their next element indexes as 1
        for(int i=0; i<K; i++){
            queue.add(new MinHeapNode(arr[i][0], i, 1));
        }

        MinHeapNode root = null;
        while(!queue.isEmpty()){        //iterate till heap is not empty
            root = queue.poll();        //remove the top, this will call heapify internally
            ans.add(root);              //add it to ans since it will be the smallest

            //check if there is next element of root in its same array, if yes then add it to queue
            if(root.y < (arr[root.x].length-1))
                queue.add(new MinHeapNode(arr[root.x][root.y++], root.x, root.y));
        }

        return ans;
    }
}
