package ds.heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinSumOfSquaresOfCharsAfterRemovingKChars {

    public static void main(String args[])
    {
        String str = "abbccc"; // Input 1
        int k = 2;
        System.out.println(minStringValue(str, k));

        str = "aaab"; // Input 2
        k = 2;
        System.out.println(minStringValue(str, k));
    }

    static int minStringValue(String s, int k){
        Map<Character, Integer> frequency = new HashMap<>();
        //find Frequency of each character and store in a hashmap
        for(int i=0; i<s.length(); i++)
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0)+1);

        // creating a priority queue with comparator such that elements in the queue are in descending order.
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // Push each char frequency into priority_queue
        for(Map.Entry<Character, Integer> e: frequency.entrySet())
            queue.add(e.getValue());

        // Removal of K characters
        while(k-- > 0)
            queue.add(queue.poll()-1);          // Get top element, remove it. Decrement by 1 and again push into priority_queue

        int ans=0;
        // After removal of K characters find sum of squares of string Value
        while (!queue.isEmpty())
            ans += queue.peek()*queue.poll();

        return  ans;
    }
}
