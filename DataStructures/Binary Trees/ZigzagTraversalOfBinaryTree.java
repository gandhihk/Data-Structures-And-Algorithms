package ds.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversalOfBinaryTree {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	ZigzagTraversalOfBinaryTree(){
		root = null;
	}

	public static void main(String[] args) {
		ZigzagTraversalOfBinaryTree tree = new ZigzagTraversalOfBinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Zigzag traversal is ");
        List<List<Integer>> ans = new ArrayList<>();
        zigzagTraversalLevelOrder(tree.root, ans);
        reverseAndPrintAns(ans);
        
        System.out.println("\n\nZigzag traversal is ");
        ans = new ArrayList<>();
        zigzagTraversalRecursive(tree.root, 0, ans);
        reverseAndPrintAns(ans);
	}
	
	static void zigzagTraversalLevelOrder(Node root, List<List<Integer>> ans) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		
		//simple level order traversal to get list of list of nodes for each level in left to right fashion
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			
			for(int i=0; i<size; i++) {
				Node curr = queue.poll();
				temp.add(curr.key);
				
				if(curr.left!=null)
					queue.add(curr.left);
				if(curr.right!=null)
					queue.add(curr.right);
			}
			ans.add(temp);
		}
	}
	
	static void zigzagTraversalRecursive(Node root, int level, List<List<Integer>> ans) {
		if(root==null)				//base case
			return;
		
		//simple preorder traversal to get list of list of nodes at each level
		List<Integer> temp;
		if(level >= ans.size()) {
			temp = new ArrayList<>();
			ans.add(temp);
		}else {
			temp = ans.get(level);
		}
		
		temp.add(root.key);
		
		zigzagTraversalRecursive(root.left, level+1, ans);
		zigzagTraversalRecursive(root.right, level+1, ans);
	}

	static void reverseAndPrintAns(List<List<Integer>> ans) {
		//reverse lists of alternate levels
		for(int i=1; i<ans.size(); i+=2) {
			Collections.reverse(ans.get(i));
		}
		
		for(List<Integer> list : ans) {
			for(Integer n: list)
				System.out.print(n+" ");
			System.out.println();
		}
	}
}
