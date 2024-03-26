package ds.binarytree;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfNonAdjacentNodes {
	
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
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left = new Node(1);
        HashMap<Node, Integer> mp = new HashMap<>();
        System.out.print(getMaxSum(root, mp));

	}

	static int getMaxSum(Node tree, Map<Node, Integer> dp) {
		if(tree == null)			//base case for leaf nodes
			return 0;
		
		if(dp.containsKey(tree))		//if dp already has ans, return that
			return dp.get(tree);
		
		int inc = tree.key;				//include this node
		if(tree.left!=null) {			//if it has left node, then add its left grandchildren
			inc+= getMaxSum(tree.left.left, dp);
			inc+= getMaxSum(tree.left.right, dp);
		}
		if(tree.right!=null) {			//if it has right node, then add its right grandchildren
			inc+= getMaxSum(tree.right.left, dp);
			inc+= getMaxSum(tree.right.right, dp);
		}
		
		//exclude this node i.e include this node's left and right children
		int exc = getMaxSum(tree.left, dp) + getMaxSum(tree.right, dp);
		
		dp.put(tree, Math.max(inc, exc));		//store it in dp
		
		return Math.max(inc, exc);				//return to parent nodes
	}
}
