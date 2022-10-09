package ds.linkedlist;

class Node{
	int data;
	Node prev;
	Node(int data){
		this.data = data;
		this.prev = null;
	}
}

public class FactorialOfLargeNumber {
	public static void main(String args[]) {
		factorial(100);
	}
	
	static void factorial(int n) {
		Node tail = new Node(1);
		for(int i=2; i<=n; i++)
			multiply(tail, i);
		print(tail);
		System.out.println();
	}
	
	static void print(Node tail) {
		if(tail==null)
			return;
		print(tail.prev);
		System.out.print(tail.data);
	}
	
	static void multiply(Node tail, int x) {
		Node temp = tail, prevNode = tail;
		int carry = 0, data;
		while(temp!=null) {			//temp used for navigation, prevNode used to get handle of last node
			data = temp.data * x + carry;		//multiply and take carry forward to all previous nodes
			temp.data = data%10;
			carry = data/10;
			prevNode = temp;		//take handle of last prev node
			temp = temp.prev;		//move to previous node
		}
		
		while(carry!=0) {
			prevNode.prev = new Node((int)(carry%10));		//create new prev node
			carry = carry/10;
			prevNode = prevNode.prev;		//move to prev
		}
	}
}
