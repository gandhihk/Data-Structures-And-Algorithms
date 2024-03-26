package ds.binarytree;

import java.util.Stack;

public class PostorderTraversal {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	PostorderTraversal(){
		root = null;
	}

	public static void main(String[] args) {
		PostorderTraversal tree = new PostorderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        // Function call
        System.out.println(
            "Preorder traversal of binary tree is ");
        printRecursivePostorder(tree.root);
        System.out.println();
        iterativePostorderUsingTwoStacks(tree.root);
        System.out.println();
        iterativePostorderUsingOneStack(tree.root);
	}

	static void printRecursivePostorder(Node root) {
		if(root==null)
			return;
		
		printRecursivePostorder(root.left);
		printRecursivePostorder(root.right);
		System.out.print(root.key+" ");
	}
	
	static void iterativePostorderUsingTwoStacks(Node root) {
		Stack<Node> stk1 = new Stack<>();
		Stack<Node> stk2 = new Stack<>();
		
		// push root to first stack
		stk1.push(root);
		
		// Run while first stack is not empty
		while(!stk1.isEmpty()) {
			// Pop an item from s1 and push it to s2
			root = stk1.pop();
			stk2.push(root);
			
			// Push left and right children of removed item to s1
			if(root.left!=null)
				stk1.push(root.left);
			
			if(root.right!=null)
				stk1.push(root.right);
		}
		// Print all elements of second stack
		while(!stk2.isEmpty()) {
			root = stk2.pop();
			System.out.print(root.key+" ");
		}
	}
	
	static void iterativePostorderUsingOneStack(Node root) {
		Stack<Node> stack = new Stack<>();
		Node curr = root, temp;
		
		//run until both curr==null and stack is empty
		while(curr!=null || !stack.isEmpty()) {
			
			//first go all the way to left
			if(curr!=null) {						//keep checking left child and add to stack
				stack.push(curr);
				curr = curr.left;
			}
			else {									//once reached node where there is no left child, then check right child of stack's top node(current parent)
				temp = stack.peek().right;
				
				if(temp!=null) {					//if right child is present, then assign it to curr so that we can check for its left child nodes in next loop traversal
					curr = temp;					
				}
				else {								//if right child not present, then this must be a leaf node or all its child nodes must be printed
					temp = stack.pop();
					System.out.print(temp.key+" ");				//so print this node
					
					while(!stack.isEmpty() && temp==stack.peek().right) {			//traverse back to print parent node whose right child was this temp node
						temp = stack.pop();
						System.out.print(temp.key+" ");
					}
				}
			}
		}
	}
}
