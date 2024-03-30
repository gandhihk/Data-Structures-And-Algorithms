package ds.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegInAllSubArraysOfSizeK {

    public static void main(String[] args)
    {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;
        printFirstNegativeInteger(arr, n, k);
    }

    static void printFirstNegativeInteger(int[] arr, int n, int k){
        Queue<Integer> q = new LinkedList<>();
        int i;
        // Process first window elements of array
        for(i=0; i<k; i++)
            if(arr[i]<0)
                q.add(i);

        for(; i<n; i++){
            if(q.isEmpty())                     //if queue is empty, then there are no neg elements, so print 0
                System.out.println("0");
            else                                //else print the front element
                System.out.println(arr[q.peek()]);

            while(!q.isEmpty() && q.peek()<(i-k+1))     //remove all elements that are not part of current window
                q.poll();

            if(arr[i]<0)            //add new element if it is neg
                q.add(i);
        }

        // Print the first negative integer of last window
        if(q.isEmpty())
            System.out.println("0");
        else
            System.out.println(arr[q.peek()]);
    }
}
