package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class CloneLLWithRandomPointer {
	
	static class Node{
		int data;
		Node next, rand;
		
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
		void setRand(Node rand) {
			this.rand = rand;
		}
	}

	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();

		Node n1 = new Node(5, null);
		Node n2 = new Node(4, n1);
		Node n3 = new Node(3, n2);
		Node n4 = new Node(2, n3);
		Node n5 = new Node(1, n4);
		n1.setRand(n3); n2.setRand(n1); n3.setRand(n5); n4.setRand(n3); n5.setRand(n2);
		list.add(n5);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);
		
		Node clonedHead = cloneList(list.get(0));
		printList(list.get(0));
		printList(clonedHead);
	}
	
	static Node cloneList(Node head) {
		//step1 : Create duplicate nodes and add them just after original nodes
		Node curr = head;
		while(curr!=null) {
			Node newNode = new Node(curr.data, curr.next);
			curr.next = newNode;
			curr = curr.next.next;
		}
		
		//step2 : set the random pointers of duplicate nodes
		curr = head;
		while(curr!=null) {
			if(curr.rand != null)
				curr.next.rand = curr.rand.next;
			
			curr = curr.next.next;
		}
		
		//step3 : separate cloned and original lists
		Node clonedHead = head.next;
		Node clonedCurr = clonedHead;
		curr = head;
		while(clonedCurr.next!=null) {
			curr.next = curr.next.next;
			curr = curr.next;
			clonedCurr.next = clonedCurr.next.next;
			clonedCurr = clonedCurr.next;
		}
		
		//step4 : set end as null in both lists
		curr.next = null;
		clonedCurr.next = null;
		
		return clonedHead;
	}

	static void printList(Node head) {
		System.out.println();
		while(head!=null) {
			System.out.print(head.data+"("+head.rand.data+")->");
			head = head.next;
		}
	}
}
