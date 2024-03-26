package ds.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertBinaryTreeToBST {
	
	static int index=0;

	public static void main(String[] args) {
		Node root = new Node(10);
	    root.left = new Node(30);
	    root.right = new Node(15);
	    root.left.left = new Node(20);
	    root.left.right = new Node(5);
	 
	    // Convert binary tree to binary search tree
	    Node bst = convertToBST(root);
	 
	    System.out.println("Following is Inorder Traversal of the converted BST:");
	    printInorder(bst);
	}

	static Node convertToBST(Node root) {
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		
		Collections.sort(list);
		inorderInsert(root, list);
		return root;
	}
	
	static void inorderInsert(Node root, List<Integer> list) {
		if(root!=null) {
			inorderInsert(root.left, list);
			root.key = list.get(index++);
			inorderInsert(root.right, list);
		}
	}
	
	static void inorder(Node root, List<Integer> list) {
		if(root!=null) {
			inorder(root.left, list);
			list.add(root.key);
			inorder(root.right, list);
		}
	}
	
	static void printInorder(Node root) {
		if(root!=null) {
			printInorder(root.left);
			System.out.print(root.key+" ");
			printInorder(root.right);
		}
	}
}
