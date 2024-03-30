package ds.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveQueue {

    public static void main(String[] args)
    {
        Queue<Integer> q = new java.util.LinkedList<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);
        System.out.println(q);
        interleaveQueueUsingQueue(q);
        System.out.println(q);
    }

    public static void interLeaveQueueUsingStack(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        //goal is to have 1st half elements in reverse order in stack
        //and 2nd half elements in queue. so that 1st element in ans queue is at top of stack and next element is in front of queue

        int length = queue.size();
        for(int i=0; i<length/2; i++){             //push 1st half elements to stack
            stack.push(queue.poll());
        }

        while(!stack.isEmpty()){                   //add stack elements to queue i.e. in reverse order
            queue.add(stack.pop());
        }

        for(int i=0; i<length/2; i++){             //add 1st half of elements back to queue at end
            queue.add(queue.poll());
        }

        for(int i=0; i<length/2; i++){             //push 1st half elements to stack again(this time it will be in reverse order)
            stack.push(queue.poll());
        }

        for(int i=0; i<length/2; i++){             //finally pick 1 element from stack and 1 from queue and add it to the back of queue
            queue.add(stack.pop());
            queue.add(queue.poll());
        }
    }

    public static void interleaveQueueUsingQueue(Queue<Integer> queue){
        Queue<Integer> q = new LinkedList<>();

        int length = queue.size();
        for(int i=0; i<length/2; i++){          //push 1st half of elements to another queue
            q.add(queue.poll());
        }

        for(int i=0; i<length/2; i++){          //pick 1 element from another queue and 1 from front of this queue and add it to the back of this queue
            queue.add(q.poll());
            queue.add(queue.poll());
        }
    }
}
