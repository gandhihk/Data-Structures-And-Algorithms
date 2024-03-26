package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseDoublyLLInGroups {

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

		Node n1 = new Node(20, null);
		Node n2 = new Node(4, n1);
		Node n3 = new Node(15, n2);
		Node n4 = new Node(85, n3);
		Node n5 = new Node(4, n4);
		Node n6 = new Node(43, n5);
		n1.setPrev(n2); n2.setPrev(n3); n3.setPrev(n4); n4.setPrev(n5); n5.setPrev(n6); n6.setPrev(null);
		list.add(n6); list.add(n5); list.add(n4); list.add(n3); list.add(n2); list.add(n1);

		printList(list.get(0));
		System.out.println();
		printList(reverseDoublyLLInGroups(list.get(0), 4));
	}
	
	static Node reverseDoublyLLInGroups(Node head, int k) {
		if(head == null)
			return head;
		
		Node prevLast = null;		//this will store last node of previous group
		Node ans = null;			//this will store the head of final LL
		
		while(head!=null) {
			int count = 1;			//to count nodes in a group
			Node curr = head, next = head, prev = null;			//3 pointers for reversing
			
			while(curr!=null && count<=k) {		//same as reversing DLL only till k nodes
				next = curr.next;
				curr.next = prev;
				curr.prev = next;
				prev = curr;
				curr = next;
				count++;
			}
			
			if(ans == null) {					//set ans to prev of 1st group
				ans = prev;
				ans.prev = null;
			}
			
			if(prevLast == null) {				//for 1st group, initial head will be the last after reversing
				prevLast = head;
			}else {								//for other groups, connect last node of previous group to 1st node of this grp
				prevLast.next = prev;
				prev.prev = prevLast;
				prevLast = head;
			}
			head = curr;						//move to next group
		}
		return ans;
	}
	
	static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}

}
