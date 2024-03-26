package ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftRightViewOfBinaryTree {

	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	LeftRightViewOfBinaryTree() {
		root = null;
	}
	static int maxLevel = 0;
	
	public static void main(String[] args) {
		LeftRightViewOfBinaryTree tree = new LeftRightViewOfBinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Left view is ");
        printLeftViewIterative(tree.root);
        System.out.println("\nLeft view is ");
        printLeftViewRecursive(tree.root, 1);
        
        maxLevel = 0;
        System.out.println("\nRight view is ");
        printRightViewIterative(tree.root);
        System.out.println("\nRight view is ");
        printRightViewRecursive(tree.root, 1);
	}
	
	static void printLeftViewIterative(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			for(int i=1; i<=n; i++) {					//traverse all nodes of this level
				Node curr = queue.poll();
				
				if(i==1)								//print only the first node of this level
					System.out.print(curr.key+" ");
				
				if(curr.left!=null)						//add its left child
					queue.add(curr.left);
				
				if(curr.right!=null)					//add its right child
					queue.add(curr.right);
			}
		}
	}

	static void printLeftViewRecursive(Node root, int currLevel) {
		if(root==null)						//base case
			return;
		
		if(currLevel > maxLevel) {			//if this is a new level, then print it
			maxLevel = currLevel;
			System.out.print(root.key+" ");
		}
		
		printLeftViewRecursive(root.left, currLevel+1);			//go to left subtree as new level
		printLeftViewRecursive(root.right, currLevel+1);		//go to right subtree as new level
	}
	
	static void printRightViewIterative(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			for(int i=1; i<=n; i++) {					//traverse all nodes of this level
				Node curr = queue.poll();
				
				if(i==n)								//print only the last node of this level
					System.out.print(curr.key+" ");
				
				if(curr.left!=null)						//add its left child
					queue.add(curr.left);
				
				if(curr.right!=null)					//add its right child
					queue.add(curr.right);
			}
		}
	}

	static void printRightViewRecursive(Node root, int currLevel) {
		if(root==null)						//base case
			return;
		
		if(currLevel > maxLevel) {			//if this is a new level, then print it
			maxLevel = currLevel;
			System.out.print(root.key+" ");
		}
		
		printRightViewRecursive(root.right, currLevel+1);		//go to right subtree as new level
		printRightViewRecursive(root.left, currLevel+1);			//go to left subtree as new level
	}
}
