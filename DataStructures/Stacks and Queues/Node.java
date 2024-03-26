package ds.stacks;

public class Node {
	Node next, prev;
	int data;
	Node(int data){
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}
