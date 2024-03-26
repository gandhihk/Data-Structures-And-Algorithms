package ds.binarytree;

import java.util.Stack;

public class InorderTraversal {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}

	Node root;
	InorderTraversal(){
		root = null;
	}
	
	public static void main(String[] args) {
		InorderTraversal tree = new InorderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        // Function call
        System.out.println(
            "Preorder traversal of binary tree is ");
        printRecursiveInorder(tree.root);
        System.out.println();
        morrisTraversalInorder(tree.root);
        System.out.println();
        iterativeInorderUsingStack(tree.root);
	}
	
	static void printRecursiveInorder(Node root) {
		if(root == null)
			return;
		
		printRecursiveInorder(root.left);
		System.out.print(root.key+" ");
		printRecursiveInorder(root.right);
	}
	
	static void morrisTraversalInorder(Node root) {
		while(root!=null) {
			if(root.left==null) {
				System.out.print(root.key+" ");
				root = root.right;			//go back to inorder successor linked already
			}else {
				Node predecessor = root.left;
				while(predecessor.right!=null && predecessor.right!=root) {			//finding inorder predecessor from left subtree
					predecessor = predecessor.right;
				}
				
				if(predecessor.right==root) {						//check if predecessor is already linked to root
					System.out.print(root.key+" ");
					predecessor.right = null;
					root = root.right;
				}else {												//else link it and move forward in left subtree
					predecessor.right = root;
					root = root.left;
				}
			}
		}
	}
	
	static void iterativeInorderUsingStack(Node root) {
		Stack<Node> stack = new Stack<>();
		
		while(root!=null || stack.size()>0) {
			// Reach the left most Node of the curr Node
			while(root!=null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			System.out.print(root.key+" ");
			
			// we have visited the node and its left subtree. Now, it's right subtree's turn
			root = root.right;
		}
	}

}
