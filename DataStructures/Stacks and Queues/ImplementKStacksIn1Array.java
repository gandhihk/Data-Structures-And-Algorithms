package ds.stacks;

public class ImplementKStacksIn1Array {
	
	static class Stack{
		int arr[], top[], next[];
		int free, n, k;
		Stack(int n, int k){
			this.n=n; this.k=k;
			free=0;
			arr = new int[n];
			top = new int[k];
			next = new int[n];
			
			for(int i=0; i<n; i++)
				next[i] = i+1;
			next[n-1]=-1;
			
			for(int i=0; i<k; i++)
				top[i] = -1;
		}
		
		void push(int e, int k) {
			if(free == -1) {
				System.out.println("Stack overflow");
				return;
			}
			
			int i = free;		//get index of next overall free cell
			free = next[i];			//update free to next free cell for new element
			next[i] = top[k];		//update the prev element index for new element in next[]
			top[k] = i;				//update top of kth stack with this new element's index
			arr[i] = e;			//add the new element to ith pos
		}
		
		int pop(int k) {
			if(top[k]==-1) {
				System.out.println("Stack is empty");
				return -1;
			}
			
			int i = top[k];		//get index of element to be popped from kth stack
			top[k] = next[i];		//update top of kth stack to prev element index of kth stack
			next[i] = free;			//udpate next free cell of popped element to free
			free = i;				//update overall free to popped element index since this is going to be freed now
			
			return arr[i];			//return ith element to be popped
		}
	}

	public static void main(String[] args) {
		int k = 3, n = 10;
        
        Stack ks = new Stack(n, k);
 
        ks.push(15, 2);
        ks.push(45, 2);
 
        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);
 
        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);
 
        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}

}
