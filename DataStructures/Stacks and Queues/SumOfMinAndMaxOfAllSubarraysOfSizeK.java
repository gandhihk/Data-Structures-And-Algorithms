package ds.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfMinAndMaxOfAllSubarraysOfSizeK {

    public static void main(String[] args)
    {
        int[] arr = {2, 5, -1, 7, -3, -1, -2} ;
        int k = 3;
        System.out.println(sumOfKsubArrays(arr, k));
    }

    static int sumOfKsubArrays(int[] arr, int k){
        int ans=0;

        Queue<Integer> min = new LinkedList<>();        //store only min elements of curr window
        Queue<Integer> max = new LinkedList<>();        //store only max elements of curr window

        int i;
        //add min and max elements of first window to queues
        for(i=0; i<k; i++){
            //remove all elements bigger than curr element from rear of min queue
            while(!min.isEmpty() && arr[min.peek()]>=arr[i])
                min.poll();
            min.add(i);         //add curr element to min queue

            //remove all elements bigger than curr element from rear of min queue
            while(!max.isEmpty() && arr[max.peek()]<=arr[i])
                max.poll();
            max.add(i);         //add curr element to max queue
        }

        for(; i<arr.length; i++){
            //add min and max of prev window to ans
            ans += arr[min.peek()]+arr[max.peek()];

            //remove all elements from min and max queues that are not in current window
            while(!min.isEmpty() && min.peek()<(i-k+1))
                min.poll();
            while(!max.isEmpty() && max.peek()<(i-k+1))
                max.poll();

            //remove all elements bigger than curr element from rear of min queue
            while(!min.isEmpty() && arr[min.peek()]>=arr[i])
                min.poll();
            min.add(i);             //add curr element to min queue

            //remove all elements bigger than curr element from rear of min queue
            while(!max.isEmpty() && arr[max.peek()]<=arr[i])
                max.poll();
            max.add(i);             //add curr element to max queue
        }

        //add min and max of last window to ans
        ans += arr[min.peek()]+arr[max.peek()];

        return ans;
    }
}
