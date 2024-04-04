package ds.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStreamOfIntegers {
    public static void main(String[] args)
    {
        int[] A = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
        int N = A.length;

        // Function call
        streamMed(A, N);
    }

    static void streamMed(int[] arr, int N){
        //two heaps for two halves of the stream
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

        //traverse through the stream
        for(int i=0; i<N; i++){
            //if ele is < than median(i.e. min of right half), then insert it in left half
            if(!rightMinHeap.isEmpty() && arr[i]<rightMinHeap.peek()){
                leftMaxHeap.offer(arr[i]);
                if(leftMaxHeap.size() > rightMinHeap.size()+1)      //rebalance if diff > 1
                    rightMinHeap.offer(leftMaxHeap.poll());
            }else{              //else insert it in right half
                rightMinHeap.offer(arr[i]);
                if(rightMinHeap.size() > leftMaxHeap.size()+1)      //rebalance if diff > 1
                    leftMaxHeap.offer(rightMinHeap.poll());
            }

            //find median
            if(rightMinHeap.size() > leftMaxHeap.size())            //check if odd length of stream
                System.out.print(rightMinHeap.peek()+" ");          //then return top of the heap which has more elements
            else if(leftMaxHeap.size() > rightMinHeap.size())
                System.out.print(leftMaxHeap.peek()+" ");
            else                                                    //else if even length of stream, then return avg of both the tops
                System.out.print((double) (rightMinHeap.peek()+leftMaxHeap.peek())/2+" ");
        }
    }
}
