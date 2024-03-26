package ds.stacks;

import java.util.Stack;

public class QueueUsingStack {
	
	static class Queue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
    }

	public static void main(String[] args) {
		/* Create a queue with items 1 2 3*/
        Queue q = new Queue();
        q.stack1 = new Stack<>();
        q.stack2 = new Stack<>();
        enQueue(q, 1);
        enQueue(q, 2);
        enQueue(q, 3);
 
        /* Dequeue items */
        System.out.print(deQueue(q) + " ");
        System.out.print(deQueue(q) + " ");
        System.out.println(deQueue(q) + " ");

	}
	
	static void enQueue(Queue q, int e) {
		q.stack1.push(e);
	}
	
	static int deQueue(Queue q) {
		int x;
		
		if(q.stack1.isEmpty() && q.stack2.isEmpty())
			return -1;
		
		if(q.stack2.isEmpty()) {				//if stack2 is empty, then move all new elements from stack1 to stack2
			while(!q.stack1.isEmpty())
				q.stack2.push(q.stack1.pop());
		}
		x = q.stack2.pop();						//pop from stack2
		
		return x;
	}

}
