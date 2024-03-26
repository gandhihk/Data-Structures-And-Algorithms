package ds.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class SortKSortedDoublyLL {
	
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

//		printList(sortKSortedDoublyLL(list.get(0)));
		printList(sortKSortedDoublyLLMinHeap(list.get(0), 2));
	}
	
	static Node sortKSortedDoublyLL(Node head) {
		if(head==null || head.next==null)
			return head;
		
		//outer loop to fix a node, starting with 2nd node
		for(Node i = head.next; i!=null; i=i.next) {
			Node j = i;
			
			//inner loop to check each of the previous nodes if their value>current node, then swap them
			//this loop will run at max k times since the LL is K sorted already
			while(j.prev!=null && j.prev.data>j.data) {
				swap(j, j.prev);
			}
			
			//if j is the new head, then reset head
			if(j.prev==null)
				head = j;
		}
		
		return head;
	}
	
	static void swap(Node i, Node j) {
		//utility method to swap all the pointers of these two nodes
		j.next = i.next;
		if(i.next!=null)
			i.next.prev = j;
		i.next = j;
		
		if(j.prev!=null)
			j.prev.next = i;
		i.prev = j.prev;
		j.prev = i;
	}
	
	static Node sortKSortedDoublyLLMinHeap(Node head, int k) {
		if(head==null || head.next==null)
			return head;
		
		Node temp = head, newHead = null;
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new SortKSortedDoublyLL.CompareNode());
		
		//create min heap of k+1 nodes initially
		for(int i=0; i<=k; i++) {
			pq.add(head);
			head = head.next;
		}
		
		//loop till there are nodes in queue
		while(!pq.isEmpty()) {
			if(newHead==null) {				//if this is the first node in sorted LL
				newHead = pq.poll();
				newHead.prev = null;
				temp = newHead;
			}else {							//for all subsequent nodes
				temp.next = pq.poll();
				temp.next.prev = temp;
				temp = temp.next;
			}
			
			if(head!=null) {				//if there is node left in original LL, then add it to the heap
				pq.add(head);
				head = head.next;
			}
		}
		
		temp.next = null;				//in the end, set next of last node of sorted LL to null
		
		return newHead;
	}
	
	static class CompareNode implements Comparator<Node>{
		public int compare(Node a, Node b) {
			return a.data-b.data;
		}
	}
	
	static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}

}
