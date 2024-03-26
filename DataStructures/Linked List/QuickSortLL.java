package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;


public class QuickSortLL {
	
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
		
		quickSort(list.get(0), list.get(7));
		printList(list.get(0));
	}
	
	static void quickSort(Node start, Node end) {
		if(start==null || start==end.next || start==end)		//base case if there is only 1 node
			return;
		
		Node pivot_prev = partition(start, end);				//partition and return pivot prev node
		
		quickSort(start, pivot_prev);							//sort left half
		
		//if pivot is moved to start, then pivot_prev will be equal to pivot, so right half starts from next of pivot_prev
		if(pivot_prev!=null && pivot_prev==start)				
			quickSort(pivot_prev.next, end);
		//if pivot is within list, then pivot_prev will be previous of pivot, so right half starts from pivot_prev.next.next
		else if(pivot_prev!=null && pivot_prev.next!=null)
			quickSort(pivot_prev.next.next, end);
	}
	
	static Node partition(Node start, Node end) {
		if(start==end || start==null || end==null)				//base case
			return start;
		
		Node pivot_prev = start;							//to track previous node of pivot
		Node curr = start;									//to track first node where data>pivot i.e. this will be the pivot pos
		int pivotData = end.data;
		
		while(start != end) {							//run loop till reaches pivot
			if(start.data < pivotData) {				//if this node's data<pivot, then need to swap this node's data with first node where data>pivot i.e. pivot pos
				pivot_prev = curr;						//store the pivot's previous node position
				swap(curr, start);						//swap
				curr = curr.next;						//move pivot pos
			}
			start = start.next;							//move this node pointer
		}
		swap(curr, end);								//finally move the pivot data to pivot pos
		
		return pivot_prev;								//return the pivot_prev node
	}
	
	static void swap(Node i, Node j) {
		int temp = i.data;
		i.data = j.data;
		j.data = temp;
	}
	
	static void printList(Node head) {
		System.out.println();
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}

}
