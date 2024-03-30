package ds.stacksAndQueues;

public class CircularQueue {
    int[] queueArray;
    int front, rear, maxSize;
    public CircularQueue(int maxSize){
        this.front = this.rear = -1;
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
    }


    // Main method for testing the CircularQueue class
    public static void main(String[] args)
    {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);

        // Should print 1
        System.out.println("Peek: " + circularQueue.peek());

        // Should print 1
        System.out.println("Dequeue: " + circularQueue.dequeue());

        // Should print 2
        System.out.println("Peek after dequeue: " + circularQueue.peek());
    }

    public void enqueue(int x){
        if(isFull(this)){
            System.out.println("Queue is full");
        }else{
            if(isEmpty(this)){          //check if this is the first enqueue operation
                this.front = 0;
                this.rear = 0;
            }else{
                this.rear = (this.rear+1)%this.maxSize;
            }
            this.queueArray[this.rear] = x;
        }
    }

    public int dequeue(){
        int x = -1;
        if(isEmpty(this)){
            System.out.println("Queue is empty");
        }else{
            x = this.queueArray[front];
            if(this.front==this.rear)               //check if this is the last dequeue operation
                this.front = this.rear = -1;
            else
                this.front = (this.front+1)%this.maxSize;
        }
        return x;
    }

    public int peek(){
        if (!isEmpty(this))
        {
            return queueArray[front];
        }
        else
        {
            System.out.println("Queue is empty. No peek value.");
            return -1; // Assuming -1 represents an empty value
        }
    }

    public boolean isFull(CircularQueue queue){
        return ((queue.front==0 && queue.rear==queue.maxSize-1)
                || (queue.rear==queue.front-1));
    }

    public boolean isEmpty(CircularQueue queue){
        return queue.front==-1 && queue.rear==-1;
    }
}
