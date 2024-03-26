package ds.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeNSortedLists {
	
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	static class NodeComparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			return o1.data - o2.data;
		}
	}

	public static void main(String[] args) {
		int N = 3;
	       
        // array to store head of linkedlist
        Node[] a = new Node[N];
       
        // Linkedlist1
        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(3);
        head1.next.next = new Node(5);
          head1.next.next.next = new Node(7);
       
        // Limkedlist2
        Node head2 = new Node(2);
        a[1] = head2;
        head2.next = new Node(4);
          head2.next.next = new Node(6);
          head2.next.next.next = new Node(8);
       
        // Linkedlist3
        Node head3 = new Node(0);
        a[2] = head3;
        head3.next = new Node(9);
          head3.next.next = new Node(10);
          head3.next.next.next = new Node(11);
 
        Node res = mergeKList(a, N);
        printList(res);
	}
	
	static Node mergeKList(Node[] arr, int K) {
		PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
		
		//insert 1st nodes from all lists
		for(int i=0; i<K; i++) {
			queue.add(arr[i]);
		}
		
		Node head = new Node(0);		//dummy node for result list
		Node curr = head;
		while(!queue.isEmpty()) {
			Node top = queue.poll();
			curr.next = top;
			curr = curr.next;
			
			if(top.next!=null)
				queue.add(top.next);
		}
		
		return head.next;
	}

	static void printList(Node head) {
		System.out.println();
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}
}
