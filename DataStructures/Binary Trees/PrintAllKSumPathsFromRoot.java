package ds.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllKSumPathsFromRoot {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10); 
	    root.left = new Node(28); 
	    root.right = new Node(13); 
	  
	    root.right.left = new Node(14); 
	    root.right.right = new Node(15); 
	  
	    root.right.left.left = new Node(21); 
	    root.right.left.right = new Node(22); 
	    root.right.right.left = new Node(23); 
	    root.right.right.right = new Node(24); 
	  
	    int sum = 38; 
	  
	    List<Integer> path = new ArrayList<>();
	    printPaths(root, sum, 0, path); 

	}
	
	static void printPaths(Node tree, int sum, int sumSoFar, List<Integer> path) {
		if(tree==null)		//base case
			return;
		
		sumSoFar += tree.key;			//find sum till this node
		
		path.add(tree.key);				//add this node to path
		
		if(sumSoFar == sum) {			//if sum equals req sum, then print the path till now
			printPath(path);
		}
		
		//recur for left and right subtrees with updated sumSoFar
		if(tree.left!=null)
			printPaths(tree.left, sum, sumSoFar, path);
		
		if(tree.right!=null)
			printPaths(tree.right, sum, sumSoFar, path);
		
		path.remove(path.size()-1);			//remove the last added node to get a fresh path
	}
	
	static void printPath(List<Integer> path) {
		System.out.println("\nPath found ");
		for(int i: path)
			System.out.print(i+" ");
	}

}
