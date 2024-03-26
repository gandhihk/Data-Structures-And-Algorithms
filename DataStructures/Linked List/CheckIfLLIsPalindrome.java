package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class CheckIfLLIsPalindrome {
	static Node left;			//static reference to left part of list

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
		Node n2 = new Node(53, n1);
		Node n3 = new Node(2, n2);
		Node n4 = new Node(3, n3);
		Node n5 = new Node(3, n4);
		Node n6 = new Node(2, n5);
		Node n7 = new Node(53, n6);
		Node n8 = new Node(8, n7);
		list.add(n8); list.add(n7); list.add(n6); list.add(n5);
		list.add(n4); list.add(n3); list.add(n2); list.add(n1);

		left = list.get(0);					//point to head
		System.out.println(isPalindrome(left));
	}

	static boolean isPalindrome(Node right) {
		
		if(right==null)						//base case to return true if reached end of list
			return true;
		
		boolean isRightPartPalindrome = isPalindrome(right.next);		//recursive call to right node
		if(!isRightPartPalindrome)			//if right part is not palindrome then no need to check further, return false
			return false;
			
		boolean isThisNodePalindrome = left.data==right.data;	//check if this node is part of palindrom
		
		left = left.next;					//move left pointer of list
		
		return isThisNodePalindrome;
	}
}
