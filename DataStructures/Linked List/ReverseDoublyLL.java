package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseDoublyLL {
	
	static class Node{
		int data;
		Node next, prev;
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
		void setPrev(Node prev) {
			this.prev = prev;
		}
	}

	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();

		Node n1 = new Node(20, null);
		Node n2 = new Node(4, n1);
		Node n3 = new Node(15, n2);
		Node n4 = new Node(85, n3);
		n1.setPrev(n2); n2.setPrev(n3); n3.setPrev(n4); n4.setPrev(null);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);

		printList(list.get(0));
		System.out.println();
		printList(reverseList(list.get(0)));
	}
	
	static Node reverseList(Node head) {
		Node curr = head, nP = head, pP = null;
		
		while(curr!=null) {
			nP = curr.next;
			curr.next = pP;
			curr.prev = nP;
			pP = curr;
			curr = nP;
		}
		
		return pP;
	}
	
	static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}

}
