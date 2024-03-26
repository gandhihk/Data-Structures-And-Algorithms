package ds.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderAndPreorder {
	
	static class Node{
		char key;
		Node left, right;
		Node(char key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	static int preIndex=0;
	ConstructBTFromInorderAndPreorder(){
		root = null;
	}

	public static void main(String[] args) {
		char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
	    char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
		
	    Map<Character, Integer> map = new HashMap<>();
	    Node root = buildTreeUtil(in, pre, in.length, map);
	    printTree(root);
	}
	
	static Node buildTreeUtil(char[] inorder, char[] preorder, int len, Map<Character, Integer> map) {
		//creating a map to search in inorder
		for(int i=0; i<inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildTree(map, preorder, 0, len-1);
	}
	
	static Node buildTree(Map<Character, Integer> map, char[] preorder, int inStart, int inEnd) {
		//base case
		if(inStart>inEnd)
			return null;
		
		//get the next char from preorder traversal and create a node for it
		char curr = preorder[preIndex++];
		Node tNode = new Node(curr);
		
		//if start and end of inorder are same, that means this new node will be a leaf node, so return it without creating child nodes
		if(inStart == inEnd)
			return tNode;
		
		//search index of this char in inorder traversal to get its left and right subtrees
		int inIndex = map.get(curr);
		
		//using index in inorder traversal, construct left and right subtrees
		tNode.left = buildTree(map, preorder, inStart, inIndex-1);
		tNode.right = buildTree(map, preorder, inIndex+1, inEnd);
		
		return tNode;
	}

	public static void printTree(Node node)
	{
	    if (node == null)
	        return;
	    printTree(node.left);
	    System.out.println(node.key + " ");
	    printTree(node.right);
	}
}
