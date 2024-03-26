package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodesWithGreaterRightNodes {
	
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

		Node n1 = new Node(3, null);
		Node n2 = new Node(2, n1);
		Node n3 = new Node(6, n2);
		Node n4 = new Node(5, n3);
		Node n5 = new Node(11, n4);
		Node n6 = new Node(10, n5);
		Node n7 = new Node(15, n6);
		Node n8 = new Node(12, n7);
		list.add(n8); list.add(n7); list.add(n6); list.add(n5);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);

		printList(list.get(0));
		Node head = deleteNodesWithGreaterRightNodes(list.get(0));
		printList(head);
	}
	
	static Node deleteNodesWithGreaterRightNodes(Node curr) {
		//base case to return from last node
		if(curr==null || curr.next==null)
			return curr;
		
		//go till the last node and return last node
		Node rightNode = deleteNodesWithGreaterRightNodes(curr.next);
		
		//check if right node's data> curr node's data
		if(rightNode.data > curr.data)
			return rightNode;					//then skip curr node and return right node to be linked to curr's prev node
		
		//link curr node to the right node which has less value than curr node
		curr.next = rightNode;		
		
		return curr;
	}
	
	static void printList(Node head) {
		System.out.println();
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}

}
