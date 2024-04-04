package ds.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import ds.heaps.MergeKSortedArraysWithMinHeap.MinHeapNode;

public class SmallestRangeCoveringElementsFromKLists {
    public static void main(String[] args)
    {
        int[][] arr = { {4,10,15,24,26},{0,9,12,20},{5,18,22,30} };

        int K = arr.length;

        // Function call
        findSmallestRange(arr, K);
    }

    static void findSmallestRange(int[][] arr, int K){
        List<MinHeapNode> ans = new ArrayList<>();

        PriorityQueue<MinHeapNode> queue = new PriorityQueue<>();

        int min, max=Integer.MIN_VALUE, range=Integer.MAX_VALUE, start=-1, end=-1;

        //add first element of all K arrays. set their next element indexes as 1
        for(int i=0; i<K; i++){
            queue.add(new MinHeapNode(arr[i][0], i, 1));
            max = Math.max(arr[i][0], max);                 //keep track of max element
        }

        while(true){
            MinHeapNode top = queue.poll();             //top will have min element
            min = top.value;

            if(range>(max-min+1)){              //update range if current max-min < range
                range = max-min+1;
                start = min;                //keep track of start and end elements
                end = max;
                System.out.println(range+" "+min+" "+max);
            }

            //check if there is next element of root in its same array
            if(top.y < arr[top.x].length){
                max = Math.max(max, arr[top.x][top.y]);             //if the next element is >max, then update max

                queue.add(new MinHeapNode(arr[top.x][top.y], top.x, top.y+1));         // add next element to queue
            }
            else break;             //break if any one array has reached end
        }

        System.out.println("Range :"+start+", "+end);
    }
}
