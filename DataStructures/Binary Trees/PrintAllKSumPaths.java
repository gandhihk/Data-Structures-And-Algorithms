package ds.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllKSumPaths {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);
 
        int k = 5;
        List<Integer> path = new ArrayList<>();
        printKPaths(root, k, path);

	}
	
	static void printKPaths(Node tree, int sum, List<Integer> path) {
		if(tree==null)				//base case
			return;
		
		path.add(tree.key);			//add node to path list
		
		//recurr for left and right subtrees
		printKPaths(tree.left, sum, path);
		printKPaths(tree.right, sum, path);
		
		int j=0;
		//traverse the path till this node in reverse
		for(int i=path.size()-1; i>=0; i--) {
			j += path.get(i);
			
			if(j == sum)			//check if sum = req sum, then print path from i
				printPath(path, i);
		}
		
		path.remove(path.size()-1);		//remove last node from path
	}

	static void printPath(List<Integer> path, int i) {
		System.out.println();
		for(int j=i; j<path.size(); j++)
			System.out.print(path.get(j)+" ");
	}
}
