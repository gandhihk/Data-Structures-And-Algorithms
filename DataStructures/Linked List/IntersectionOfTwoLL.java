package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoLL {
	
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

		Node n1 = new Node(30, null);
		Node n2 = new Node(15, n1);
		Node n3 = new Node(9, n2);
		Node n4 = new Node(6, n3);
		Node n5 = new Node(3, n4);
		list.add(n5);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);
		
		List<Node> list2 = new ArrayList<>();

		n1 = new Node(30, null);
		n2 = new Node(15, n1);
		n3 = new Node(10, n2);
		list2.add(n3); list2.add(n2); list2.add(n1);

		printList(list.get(0));
		printList(list2.get(0));

		System.out.println();
		printList(findIntersection(list.get(0), list2.get(0)));
	}
	
	static Node findIntersection(Node head1, Node head2) {
		Node ptr1 = head1, ptr2 = head2;		//take 2 pointers
		
		if(ptr1==null || ptr2==null)
			return null;
		
		while(ptr1.data != ptr2.data) {			//run loop until both point to intersection node
			
			ptr1 = ptr1.next;					//move both by 1
			ptr2 = ptr2.next;
			
			if(ptr1 == ptr2)					//if they point to same node, then it is the intersection node
				return ptr1;
			
			if(ptr1==null)					//if ptr1 is null, then redirect it to head2
				ptr1 = head2;
			
			if(ptr2==null)					//if ptr2 is null, then redirect it to head1
				ptr2 = head1;
		}
		return ptr1;
	}
	
	static void printList(Node head) {
		System.out.println();
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}

}
