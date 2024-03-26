package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MergeSortLL {
	
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

		Node n1 = new Node(7, null);
		Node n2 = new Node(10, n1);
		Node n3 = new Node(5, n2);
		Node n4 = new Node(20, n3);
		Node n5 = new Node(3, n4);
		Node n6 = new Node(2, n5);
		Node n7 = new Node(53, n6);
		Node n8 = new Node(8, n7);
		list.add(n8); list.add(n7); list.add(n6); list.add(n5);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);

		printList(list.get(0));
		printList(mergeSort(list.get(0)));
	}
	
	static Node mergeSort(Node head) {
		Node head1 = head;
		if(head.next==null)				//base case if this is the only element in list
			return head;
		
		Node midNode = findMid(head);		//find middle node
		Node head2 = midNode.next;			//set head2 to middle's next
		midNode.next = null;				//set null to middle's next to end list1
		
		head1 = mergeSort(head1);			//divide list1 further
		head2 = mergeSort(head2);			//divide list2 further
		
		return merge(head1, head2);			//merge both lists
	}

	static Node merge(Node head1, Node head2) {
		Node dummy = new Node(-1, null);		//dummy node to track head of merged list
		Node temp = dummy;					//temp node to traverse merged list
		
		while(head1!=null && head2!=null) {		//traverse both lists
			if(head1.data <= head2.data) {		//if node1<=node2
				temp.next = head1;				//add node1 to merged list
				head1 = head1.next;				//move list1's pointer
			}else {
				temp.next = head2;				//add node2 to merged list
				head2 = head2.next;				//move list2's pointer
			}
			temp = temp.next;					//move merged list's pointer
		}
		
		while(head1!=null) {					//add all remaining nodes of list1
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		
		while(head2!=null) {					//add all remaining nodes of list2
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		
		return dummy.next;
	}
	
	static Node findMid(Node head) {			//find mid using fast and slow pointer technique
		Node fast=head, slow=head;
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	static void printList(Node head) {
		System.out.println();
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}
}
