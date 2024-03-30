package ds.stacksAndQueues;

import java.util.*;

public class ReverseFirstKElementsInQueue {

    public static void main (String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        int k = 5;
        queue = reverseFirstK(queue, k);
        // printing queue
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    public static Queue<Integer> reverseFirstK(Queue<Integer> queue, int K){
        reverse(queue, K);          //reverse the first K elements
        //after recursion, the K elements will be present at the end of queue
        int restOfElements = queue.size()-K;
        //so move the rest of the elements to the end of queue
        while(restOfElements-->0){
            int x = queue.poll();
            queue.add(x);
        }
        return queue;
    }

    public static void reverse(Queue<Integer> queue, int K){
        if(K==0)            //base case
            return;
        int X = queue.poll();
        reverse(queue, K-1);
        queue.add(X);
    }
}
