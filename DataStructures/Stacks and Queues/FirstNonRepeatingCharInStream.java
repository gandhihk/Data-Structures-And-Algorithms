package ds.stacksAndQueues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharInStream {
    public static void main(String[] args)
    {
        String str = "geeksforgeeksandgeeksquizfor";
        firstNonRepeating(str);
    }

    static void firstNonRepeating(String str){
        Map<Character, Integer> map = new HashMap<>();      //hashmap to store frequencies
        Queue<Character> queue = new LinkedList<>();        //queue to store unique chars

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(!map.containsKey(c)){                //if unique, then add to queue
                queue.add(c);
            }
            map.put(c, map.getOrDefault(c, 0)+1);       //update its frequency

            while(!queue.isEmpty() && map.get(queue.peek())>1)      //remove all repeating chars from front of queue to get the 1st unique char for current char
                queue.poll();

            if(queue.isEmpty())         //if queue is empty, it means all chars so far are repeating
                System.out.print("-1 ");
            else                        //else the front of queue has 1st unique char
                System.out.print(queue.peek());
        }
    }
}
