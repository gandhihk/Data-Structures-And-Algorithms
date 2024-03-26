package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;


public class ReverseLLinGroups {
	
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
		list.add(n8); list.add(n7); list.add(n6); list.add(n5);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);
		Node head = list.get(0);
		printList(head);
		
		head = reverseList(n8, 5);
		printList(head);

	}
	
	static Node reverseList(Node head, int k) {
		Node prev = null, curr = head, next = null, first = null, prevFirst = null;
		
		int i=0;
		while(curr!=null) {							//outer loop
			if(i==0) {								//check if new inner loop
				prevFirst = first;					//set prevFirst and first
				first = curr;
			}
			while(i<k && curr!=null) {				//inner loop same as reversing list, run till k elements or curr=null
				next = curr.next;					
				curr.next = prev;
				prev = curr;
				curr = next;
				i++;
			}
			if(prevFirst!=null)						//get prevFirst and point it to end of current group
				prevFirst.next = prev;
			if(i==k) {								//end of current group, reset values
				if(prevFirst==null)					//get head of first group
					head = prev;
				i=0;
				prev = null;
			}
		}
		return head;
	}

	static void printList(Node head) {
		System.out.println();
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}
}
