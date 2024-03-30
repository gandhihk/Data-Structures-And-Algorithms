package ds.stacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinAndMaxOfAllSubarraysOfSizeK {

    public static void main(String[] args)
    {
        int[] arr = {2, 5, -1, 7, -3, -1, -2} ;
        int k = 3;
        System.out.println(sumOfKsubArrays(arr, k));
    }

    static int sumOfKsubArrays(int[] arr, int k){
        int ans=0;

        Deque<Integer> min = new LinkedList<>();        //store only min elements of curr window
        Deque<Integer> max = new LinkedList<>();        //store only max elements of curr window

        int i;
        //add min and max elements of first window to queues
        for(i=0; i<k; i++){
            //remove all elements bigger than curr element from rear of min queue
            while(!min.isEmpty() && arr[min.peekLast()]>=arr[i])
                min.removeLast();
            min.addLast(i);         //add curr element to min queue

            //remove all elements bigger than curr element from rear of min queue
            while(!max.isEmpty() && arr[max.peekLast()]<=arr[i])
                max.removeLast();
            max.addLast(i);         //add curr element to max queue
        }

        for(; i<arr.length; i++){
            //add min and max of prev window to ans
            ans += arr[min.peekFirst()]+arr[max.peekFirst()];

            //remove all elements from min and max queues that are not in current window
            while(!min.isEmpty() && min.peekFirst()<(i-k+1))
                min.removeFirst();
            while(!max.isEmpty() && max.peekFirst()<(i-k+1))
                max.removeFirst();

            //remove all elements bigger than curr element from rear of min queue
            while(!min.isEmpty() && arr[min.peekLast()]>=arr[i])
                min.removeLast();
            min.addLast(i);             //add curr element to min queue

            //remove all elements smaller than curr element from rear of max queue
            while(!max.isEmpty() && arr[max.peekLast()]<=arr[i])
                max.removeLast();
            max.addLast(i);             //add curr element to max queue
        }

        //add min and max of last window to ans
        ans += arr[min.peekLast()]+arr[max.peekLast()];

        return ans;
    }
}
