package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

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

		Node n1 = new Node(20, null);
		Node n2 = new Node(4, n1);
		Node n3 = new Node(15, n2);
		Node n4 = new Node(85, n3);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);
		
		Node head = reverseList(n4);
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}
	
	static Node reverseList(Node head) {
		Node curr = head, prev = null, next = head.next;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
