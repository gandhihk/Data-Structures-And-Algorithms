package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

import ds.linkedlist.SortKSortedDoublyLL.Node;

public class RotateDoublyLLbyNNodes {
	
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

		Node n1 = new Node(8, null);
		Node n2 = new Node(56, n1);
		Node n3 = new Node(12, n2);
		Node n4 = new Node(2, n3);
		Node n5 = new Node(6, n4);
		Node n6 = new Node(3, n5);
		n1.setPrev(n2); n2.setPrev(n3); n3.setPrev(n4); n4.setPrev(n5); n5.setPrev(n6); n6.setPrev(null);
		list.add(n6); list.add(n5); list.add(n4); list.add(n3); list.add(n2); list.add(n1);

		printList(list.get(0));
		System.out.println();

		printList(rotate(list.get(0), 2));
	}
	
	static Node rotate(Node head, int N) {
		int count=1;
		
		Node current = head;
		
		while(count<N && current!=null) {
			current = current.next;
			count++;
		}
		
		Node nthNode = current;
		
		while(current.next!=null)
			current = current.next;
		
		Node last = current;
		
		last.next = head;
		head.prev = last;
		
		head = nthNode.next;
		head.prev = null;
		nthNode.next = null;
		
		return head;
	}
	
	static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}

}
