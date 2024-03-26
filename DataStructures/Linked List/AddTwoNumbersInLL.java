package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

import ds.linkedlist.AddOneToNumberInLL.Node;

public class AddTwoNumbersInLL {

	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();

		Node n1 = new Node(9, null);
		Node n2 = new Node(9, n1);
		Node n3 = new Node(9, n2);
		Node n4 = new Node(5, n3);
		Node n5 = new Node(4, n4);
		Node n6 = new Node(3, n5);
		Node n7 = new Node(9, n6);
		list.add(n7); list.add(n6); list.add(n5);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);
		
		List<Node> list2 = new ArrayList<>();

		n1 = new Node(9, null);
		n2 = new Node(9, n1);
		n3 = new Node(9, n2);
		n4 = new Node(5, n3);
		n5 = new Node(4, n4);
		n6 = new Node(3, n5);
		n7 = new Node(2, n6);
		Node n8 = new Node(1, n7);
		list2.add(n8); list2.add(n7); list2.add(n6); list2.add(n5);
		list2.add(n4); list2.add(n3); list2.add(n2); list2.add(n1);

		printList(list.get(0));
		printList(list2.get(0));
		
//		Node head = addTwoNumbers(list.get(0), list2.get(0));
//		printList(head);
		
		Node head = addTwoNumbersIterative(list.get(0), list2.get(0));
		printList(head);
	}
	
	//Solution 1
	static Node addTwoNumbers(Node head1, Node head2) {
		int size1=0, size2=0;
		Node t1=head1, t2=head2;
		
		size1 = getSize(t1);
		size2 = getSize(t2);
		
		int carry=0;
		Node head;
		if(size1>size2) {					//based on size send the longer list first
			head = t1;
			carry = addTwoNumbersRecursive(t1, t2, size1, size2);
		}else {
			head = t2;
			carry = addTwoNumbersRecursive(t2, t1, size2, size1);
		}
		
		if(carry>0) {						//if the final carry>0
			Node start = new Node(carry, head);				//create new node as head
			return start;
		}
		return head;
	}
	
	static int addTwoNumbersRecursive(Node t1, Node t2, int size1, int size2) {
		if(t1==null && t2==null)				//base case to return 0 as carry if any list is traversed fully
			return 0;
		
		int res=0;
		if(size1==size2) {						//if rest of the lists have same size
			res = t1.data + t2.data + addTwoNumbersRecursive(t1.next, t2.next, size1-1, size2-1);		//add both nodes data and decerement both sizes
		}else {
			res = t1.data + addTwoNumbersRecursive(t1.next, t2, size1-1, size2);				//assume list1 is longer so just add its data and decrement its size
		}
		
		t1.data = res%10;						//update the sum to list1's node
		return res/10;							//return carry of this node
	}
	
	//Solution 2
	static Node addTwoNumbersIterative(Node head1, Node head2) {
		//reverse both lists
		head1 = reverseList(head1);				
		head2 = reverseList(head2);
		
		int carry=0;
		Node head = null;								//handle to head node
		while(head1!=null || head2!=null || carry>0) {		//run loop to traverse longer list and carry, if any
			int sum=0;
			
			if(head1!=null) {					//if list1 has node, then add its data to sum and move to next node
				sum+=head1.data;
				head1 = head1.next;
			}
			
			if(head2!=null) {					//if list1 has node, then add its data to sum and move to next node
				sum+=head2.data;
				head2 = head2.next;
			}
			
			sum+=carry;							//add previous carry
			
			Node newNode = new Node(sum%10, head);		//create new node for sum, and append it to beginning of ans list
			head = newNode;
			
			carry = sum/10;						//update carry for next node
		}
		return head;
	}
	
	static int getSize(Node t1) {
		int size1=0;
		while(t1.next!=null) {
			size1++;
			t1 = t1.next;
		}
		return size1;
	}
	
	static void printList(Node head) {
		System.out.println();
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
	}
	
	static Node reverseList(Node head) {
		Node curr = head, prev = null, next = head.next;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
