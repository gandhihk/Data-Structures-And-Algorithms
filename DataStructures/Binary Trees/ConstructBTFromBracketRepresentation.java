package ds.binarytree;

import java.util.*;

public class ConstructBTFromBracketRepresentation {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	ConstructBTFromBracketRepresentation(){
		root = null;
	}

	public static void main(String[] args) {
		String s = "4(2(3)(1))(6(5))";
        
        System.out.println("Constructed BT : ");
        Node root = constructBinaryTree(s);
        printTree(root);
	}
	
	static Node constructBinaryTree(String s) {
		int index = 0;
		Stack<Node> stack = new Stack<>();
		Node root = new Node(Character.getNumericValue(s.charAt(index)));
		stack.push(root);
		index++;
		
		while(index<s.length()) {
			if(s.charAt(index)=='(' && s.charAt(index)==')') {
				index+=2;
				continue;
			}
			if(s.charAt(index)=='(') {
				index++;
				stack.push(createNode(s.charAt(index), stack.peek()));
				index++;
			}else if(s.charAt(index)==')') {
				stack.pop();
				index++;
			}
		}
		
		return root;
	}
	
	static Node createNode(char c, Node parent) {
		Node node = new Node(Character.getNumericValue(c));
		if(parent.left==null) {
			parent.left = node;
		}else {
			parent.right = node;
		}
		return node;
	}

	// Print tree function
	public static void printTree(Node node)
	{
	    if (node == null)
	        return;
	   
	    System.out.println(node.key + " ");
	    printTree(node.left);
	    printTree(node.right);
	}
}
