package ds.binarytree;

import java.util.HashMap;
import java.util.Map;

public class CheckDuplicateSubtreesOfSize2 {

	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	CheckDuplicateSubtreesOfSize2(){
		root = null;
	}
	
	public static void main(String[] args) {
		Node root = new Node('A'); 
        root.left = new Node('B'); 
        root.right = new Node('C'); 
        root.left.left = new Node('D'); 
        root.left.right = new Node('E'); 
        root.right.right = new Node('B'); 
        root.right.right.right = new Node('E'); 
        root.right.right.left= new Node('D');
        
        Map<String, Integer> subtrees = new HashMap<>();
        duplicateSubtrees(root, subtrees);
        for(Map.Entry<String, Integer> e: subtrees.entrySet()) {		//check if any subtree with frequency>1
        	if(e.getValue()>1)
        		System.out.println("Duplicate subtree found: "+e.getKey());
        }
        
	}
	
	static String duplicateSubtrees(Node root, Map<String, Integer> subtrees) {
		String s = "";
		
		if(root == null)			//return delimiter for null children
			return "$";
		
		if(root.left==null && root.right==null) {		//don't add the subtree string of leaf nodes to map, just return it
			s = String.valueOf(root.key);
			return s;
		}
		
		//concatenate the data of root with left subtree string and right subtree string
		//use delimiter in between to differentiate
		s = s + String.valueOf(root.key);
		s = s + "$" + duplicateSubtrees(root.left, subtrees);
		s = s + "$" + duplicateSubtrees(root.right, subtrees);
		
		//for non-leaf nodes, add the subtree string to map and increase its frequency
		if(subtrees.containsKey(s))
			subtrees.put(s, subtrees.get(s)+1);
		else
			subtrees.put(s, 1);
		
		return s;			//return this subtree's string
	}

}
