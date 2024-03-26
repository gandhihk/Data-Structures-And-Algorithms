package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class AddOneToNumberInLL {
	
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

		Node n1 = new Node(9, null);
		Node n2 = new Node(9, n1);
		Node n3 = new Node(9, n2);
		Node n4 = new Node(5, n3);
		Node n5 = new Node(4, n4);
		Node n6 = new Node(3, n5);
		Node n7 = new Node(2, n6);
		Node n8 = new Node(1, n7);
		list.add(n8); list.add(n7); list.add(n6); list.add(n5);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);

		printList(list.get(0));
		Node head = addOneIterative(list.get(0));
		printList(head);
	}
	
	static Node addOneRecursion(Node head) {
		int carry = addCarry(head);				//call rescursive method and get final carry
		
		if(carry > 0) {									//if final carry>0, add new node and make it head
			Node start = new Node(carry, head);
			return start;								//return this node as head
		}
		return head;									//return old node as head
	}
	
	static int addCarry(Node head) {
		if(head == null)								//set carry as 1 for null to add 1 to last node
			return 1;
		
		int res = head.data + addCarry(head.next);		//add right nodes carry to this node's data
		
		head.data = res%10;								//set modulo 10 value to this node
		
		return res/10;									//return this node's carry to previous node in recursion
	}
	
	static Node addOneIterative(Node head) {
		Node t = head;							//current node
		Node ln = null;							//last non-9 node
		
		while(t.next!=null) {					//loop to get last node and last non-9 node
			if(t.data!=9) {
				ln = t;
			}
			t = t.next;
		}
		
		if(t.data==9 && ln!=null) {				//if last node=9 and there is a non-0 node from previous nodes
			t = ln;								//set t to last non-9 node
			t.data += 1;						//add 1 as carry to it
			t = t.next;							//move to next node
			
			while(t!=null) {					//update all next nodes to 0
				t.data = 0;
				t = t.next;
			}
		}else if(t.data!=9) {					//if last node!=9, then we don't have to worry about carry, simply add 1 to it
			t.data += 1;						
		}else if(t.data==9 && ln==null) {		//if last node=9 but all previous nodes are also 9
			t = head;							//set t to head node
			t.data = 0;							//reset it to 0
			Node start = new Node(1, t);		//add a new node at the start with value as 1
			t = t.next;							//move to next node
			while(t!=null) {					//update all next nodes to 0
				t.data = 0;
				t = t.next;
			}
			return start;						//return new node as head
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
