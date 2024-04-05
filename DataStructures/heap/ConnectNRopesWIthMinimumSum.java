package ds.heaps;

import java.util.PriorityQueue;

public class ConnectNRopesWIthMinimumSum {
    public static void main(String[] args)
    {
        int[] len = { 4, 3, 2, 6 };
        int size = len.length;
        System.out.println("Total cost for connecting"
                + " ropes is "
                + minCost(len, size));
    }

    static int minCost(int[] arr, int size){
        //Min heap to store N ropes
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cost=0;
        for(int i=0; i<size; i++)           //add all ropes in heap
            heap.add(arr[i]);

        int min, sec_min;           //two variables to store smallest and 2nd smallest ropes
        while(heap.size()>1){       //loop till heap has 2 ropes
            min = heap.poll();          //get smallest and 2nd smallest ropes
            sec_min = heap.poll();

            cost += min+sec_min;
            heap.add(min+sec_min);      //add the new formed rope to heap
        }

        return cost;
    }
}
