package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

import ds.linkedlist.ReverseLLinGroups.Node;

public class DetectLoopInLL {

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
		n1.next = n6;	
		list.add(n8); list.add(n7); list.add(n6); list.add(n5);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);
		
		detectLoop(list.get(0));
	}
	
	static void detectLoop(Node head) {
		Node fast_P = head, slow_P = head;
		
		while(fast_P!=null && slow_P!=null && fast_P.next!=null) {
			slow_P = slow_P.next;
			fast_P = fast_P.next.next;
			if(slow_P == fast_P) {
				System.out.println("Loop detected at"+slow_P.data);
				break;
			}
		}
	}

}
