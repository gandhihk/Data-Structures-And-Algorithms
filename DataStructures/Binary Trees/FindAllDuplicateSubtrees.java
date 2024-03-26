package ds.binarytree;

import java.util.HashMap;
import java.util.Map;

public class FindAllDuplicateSubtrees {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        printAllDups(root);
	}

	static void printAllDups(Node root) {
		Map<String, Integer> subtrees = new HashMap<>();
		findAllDuplicateSubtrees(root, subtrees);
		for(Map.Entry<String, Integer> e: subtrees.entrySet()) {		//check if any subtree with frequency>1
        	if(e.getValue()>1)
        		System.out.println("Duplicate subtree found: "+e.getKey());
        }
	}
	
	static String findAllDuplicateSubtrees(Node tree, Map<String, Integer> subtrees) {
		if(tree==null)
			return "$";
		
		//concatenate the data of root with left subtree string and right subtree string
		//use delimiter in between to differentiate
		String s= "";
		s = s + String.valueOf(tree.key);
		s = s + "$" + findAllDuplicateSubtrees(tree.left, subtrees);
		s = s + "$" + findAllDuplicateSubtrees(tree.right, subtrees);
		
		if(subtrees.containsKey(s))
			subtrees.put(s, subtrees.get(s)+1);
		else
			subtrees.put(s, 1);
		
		return s;			//return this subtree's string
	}
}
