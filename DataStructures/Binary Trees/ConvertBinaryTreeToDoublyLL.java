package ds.binarytree;

public class ConvertBinaryTreeToDoublyLL {

	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	ConvertBinaryTreeToDoublyLL(){
		root = null;
	}
	static Node head = null, prev = null;
	
	public static void main(String[] args) {
		ConvertBinaryTreeToDoublyLL tree = new ConvertBinaryTreeToDoublyLL();
		tree.root = new Node(10); 
        tree.root.left = new Node(12); 
        tree.root.right = new Node(15); 
        tree.root.left.left = new Node(25); 
        tree.root.left.right = new Node(30); 
        tree.root.right.left = new Node(36); 

        
//        convertToDoublyLL(tree.root);
//        printDoublyLL(head);
        head = convertToDoublyLL2(tree.root);
        while(head.left!=null)
        	head = head.left;
        printDoublyLL(head);
	}
	
	static void convertToDoublyLL(Node curr) {
		
		if(curr == null)		//base case
			return;
		
		convertToDoublyLL(curr.left);		//traverse left subtree
		
		if(prev == null) {					//if this is the leftmost node, make this as head
			head = curr;
		}else {								//else set the left/right pointers
			prev.right = curr;
			curr.left = prev;
		}
		prev = curr;						//set current as prev
		
		convertToDoublyLL(curr.right);		//traverse right subtree
	}
	
	static Node convertToDoublyLL2(Node curr) {
		
		if(curr == null)		//base case
			return null;
		
		if(curr.left!=null) {				//this condition is to not process the leaf node as curr
			
			Node left = convertToDoublyLL2(curr.left);		//convert left subtree to DLL and its left node
			
			while(left.right!=null)			//find inorder predecessor
				left = left.right;
				
			left.right = curr;				//set predecessor's right as curr
			curr.left = left;				//set curr's left as predecessor
		}
		
		if(curr.right!=null) {			//this condition is to not process the leaf node as curr
			
			Node right = convertToDoublyLL2(curr.right);		//convert right subtree to DLL and return its right node
			
			while(right.left!=null)			//find successor
				right=right.left;
			
			right.left = curr;				//set successor's left as curr
			curr.right = right;				//set curr's right as successor
		}
		
		return curr;
	}
	
	static void printDoublyLL(Node head) {
		while(head!=null) {
			System.out.print(head.key+" ");
			head = head.right;
		}
	}

}
