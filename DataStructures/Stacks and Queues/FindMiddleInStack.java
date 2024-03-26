package ds.stacks;

public class FindMiddleInStack {
	
	static class Stack{
		Node head, mid;
		int size;
		Stack(){
			this.size=0;
			head=null; mid=null;
		}
		
		void push(int key) {
			Node newNode = new Node(key);
			
			if(size==0) {
				head = newNode;
				mid = newNode;
				size++;
				return;
			}
			
			head.next=newNode;
			newNode.prev=head;
			head=head.next;
			size++;
			
			if(size%2 != 0)
				mid = mid.next;
		}
		
		int pop() {
			if(size==0) {
				System.out.println("Stack empty");
				return -1;
			}
			
			int ans = head.data;
			if(size==1) {
				head=null;
				mid=null;
			}else {
				head=head.prev;
				size--;
				
				if(size%2 == 0)
					mid = mid.prev;
			}
			return ans;
		}
		
		int findMid() {
			return mid.data;
		}
		
		void deleteMid() {
			if(size==1) {
				head=null;
				mid=null;
				size--;
			}else if(size==2) {
				mid = head;
				head.prev=null;
				size--;
			}else {
				mid.next.prev = mid.prev;
				mid.prev.next = mid.next;
				
				size--;
				if(size%2 == 1)
					mid = mid.next;
				else
					mid = mid.prev;
			}
		}
	}

	public static void main(String[] args) {
		Stack ms = new Stack();
        ms.push(11);
        ms.push(22);
        ms.push(33);
        ms.push(44);
        ms.push(55);
        ms.push(66);
        ms.push(77);
        ms.push(88);
        ms.push(99);
 
        System.out.println("Popped : " + ms.pop());
        System.out.println("Popped : " + ms.pop());
        System.out.println("Middle Element : "
                           + ms.findMid());
        ms.deleteMid();
        System.out.println("New Middle Element : "
                           + ms.findMid());
	}

}
