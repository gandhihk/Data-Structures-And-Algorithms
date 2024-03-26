package ds.binarytree;

import java.util.ArrayList;
import java.util.List;

public class FindKthAncestorOfNode {
	
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
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Kth ancestor = "
                           + findKthAncestor(root, 8, 3));
	}

	static int findKthAncestor(Node root, int n, int k) {
		List<Integer> path = new ArrayList<>();
		findPath(root, n, path);
		
		return path.get(path.size()-k-1);
	}
	
	static boolean findPath(Node tree, int n, List<Integer> path) {
		if(tree==null)				//base case to return
			return false;
		
		path.add(tree.key);			//add curr node to path
		
		if(tree.key==n)				//if curr node is the required node, then return true
			return true;
		
		boolean left = findPath(tree.left, n, path);		//check in left subtree if node is present
		boolean right = false;
		if(!left)					//if not present in left subtree, check in right subtree
			right = findPath(tree.right, n, path);
		
		if(left || right)			//return true if found in left OR right subtree
			return true;
		
		path.remove(path.size()-1);		//if not found, remove the curr node from path list and return false
		return false;
	}
}
