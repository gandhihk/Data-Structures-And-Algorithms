package ds.binarytree;

import java.util.Stack;

class Node{
	int key;
	Node left, right;
	Node(int key){
		this.key = key;
		left = right = null;
	}
}

public class PreorderTraversal {

	Node root;
	PreorderTraversal(){
		root = null;
	}
	
	public static void main(String[] args) {
		PreorderTraversal tree = new PreorderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        // Function call
        System.out.println(
            "Preorder traversal of binary tree is ");
        printRecursivePreorder(tree.root);
        System.out.println();
        morrisTraversalPreorder(tree.root);
        System.out.println();
        iterativePreorderUsingStack(tree.root);
	}
	
	static void printRecursivePreorder(Node root) {
		if(root==null)
			return;
		
		System.out.print(root.key+" ");
		printRecursivePreorder(root.left);
		printRecursivePreorder(root.right);
	}
	
	static void morrisTraversalPreorder(Node root) {
		while(root!=null) {
			if(root.left==null) {
				System.out.print(root.key+" ");
				root = root.right;
			}else {
				Node predecessor = root.left;
				while(predecessor.right!=null && predecessor.right!=root) {			//finding inorder predecessor from left subtree
					predecessor = predecessor.right;
				}
				
				if(predecessor.right==root) {								//check if predecessor is already linked to root
					predecessor.right = null;
					root = root.right;
				}else {
					System.out.print(root.key+" ");							//else link it and move forward in left subtree
					predecessor.right = root;
					root = root.left;
				}
			}
			
		}
	}
	
	static void iterativePreorderUsingStack(Node root) {
		// Create an empty stack and push root to it
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
        /* Pop all items one by one. Do following for every popped item
        a) print it
        b) push its right child
        c) push its left child
        Note that right child is pushed first so that left is processed first */
		while(!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.key+" ");
			
			if(root.right!=null)
				stack.push(root.right);
			
			if(root.left!=null)
				stack.push(root.left);
		}
	}

}
