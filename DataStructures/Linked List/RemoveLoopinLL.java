package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveLoopinLL {
	
	static class Node{
		int data;
		Node next;
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();

		Node n1 = new Node(8, null);
		Node n2 = new Node(7, n1);
		Node n3 = new Node(6, n2);
		Node n4 = new Node(5, n3);
		Node n5 = new Node(4, n4);
		Node n6 = new Node(3, n5);
		Node n7 = new Node(2, n6);
		Node n8 = new Node(1, n7);
		n1.next = n6;	
		list.add(n8); list.add(n7); list.add(n6); list.add(n5);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);
		
		removeLoop(list.get(0));

	}

	static void removeLoop(Node head) {
		Node slowP = head, fastP = head;
		
		while(slowP!=null && fastP!=null && fastP.next!=null) {		//detect loop
			slowP = slowP.next;
			fastP = fastP.next.next;
			if(slowP == fastP) {
				slowP = head;										//set slow pointer to head
				break;
			}
		}
		
		Node prev = fastP;							//keep track of prev node for last node of loop
		while(slowP!=fastP) {						//move both pointers at same pace until they are same
			slowP = slowP.next;
			prev = fastP;
			fastP = fastP.next;
		}
		System.out.println("Start of loop is "+slowP.data+" and end is "+prev.data);
		prev.next = null;							//set last node's next to null to remove loop
		printList(head);
	}
	
	static void printList(Node head) {
		System.out.println();
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}
}
