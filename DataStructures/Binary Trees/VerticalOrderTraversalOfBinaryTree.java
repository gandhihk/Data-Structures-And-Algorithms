package ds.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversalOfBinaryTree {

	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	VerticalOrderTraversalOfBinaryTree(){
		root = null;
	}
	
	static class MinMaxPair {
		int min, max;
	}
	
	public static void main(String[] args) {
		VerticalOrderTraversalOfBinaryTree tree = new VerticalOrderTraversalOfBinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.right.right.left = new Node(10);
        tree.root.right.right.left.right = new Node(11);
        tree.root.right.right.left.right.right = new Node(12);
        
        System.out.println("Vertical order traversal is ");
        Map<Integer, List<Integer>> map = new HashMap<>();				//map to store lists of nodes with same hd
        MinMaxPair minmax = new MinMaxPair();							//min max pair to get the min and max hd
        printVerticalOrderTraversalPreOrder(tree.root, 0, map, minmax);
        printMap(map, minmax);									//print lists in order from min and max keys in map
        
        System.out.println("Vertical order traversal is ");
        map = new HashMap<>();						//map to store lists of nodes with same hd
        minmax = new MinMaxPair();					//min max pair to get the min and max hd
        printVerticalOrderTraversalLevelOrder(tree.root, map, minmax);
        printMap(map, minmax);						//print lists in order from min and max keys in map
        
	}
	
	static void printVerticalOrderTraversalPreOrder(Node root, int hd, Map<Integer, List<Integer>> map, MinMaxPair minmax) {
		if(root==null)				//base case
			return;
		
		if(map.containsKey(hd)) {				//if map contains list for this hd, then just add node to that list
			map.get(hd).add(root.key);
		}else {
			List<Integer> list = new ArrayList<>();			//else create list and add this node to it
			list.add(root.key);
			map.put(hd, list);
		}
		
		if(hd < minmax.min)							//keep track of minimum hd
			minmax.min = hd;
		
		if(hd > minmax.max)							//keep track of max hd
			minmax.max = hd;
			
		printVerticalOrderTraversalPreOrder(root.left, hd-1, map, minmax);				//traverse left subtree with hd=hd-1
		
		printVerticalOrderTraversalPreOrder(root.right, hd+1, map, minmax);				//traverse right subtree with hd=hd+1
	}
	
	static class Qobj {
	    int hd;
	    Node node;
	    Qobj(int hd, Node node)
	    {
	        this.hd = hd;
	        this.node = node;
	    }
	}
	
	static void printVerticalOrderTraversalLevelOrder(Node root, Map<Integer, List<Integer>> map, MinMaxPair minmax) {
		Queue<Qobj> queue = new LinkedList<>();					//queue for level order traversal
		Qobj q = new Qobj(0, root);								//add root to queue with hd=0
		queue.add(q);
		
		while(!queue.isEmpty()) {
			Qobj q1 = queue.poll();
			
			if(map.containsKey(q1.hd)) {						//if map contains list for this hd, then just add this node to that list
				map.get(q1.hd).add(q1.node.key);
			}else {
				List<Integer> list = new ArrayList<>();			//else create new list and add this node to it
				list.add(q1.node.key);
				map.put(q1.hd, list);
			}
			
			minmax.min = Math.min(minmax.min, q1.hd);			//keep track of min hd
			minmax.max = Math.max(minmax.max, q1.hd);			//keep track of max hd
			
			if(q1.node.left!=null)								//if left child present, then add it to queue with hd=hd-1
				queue.add(new Qobj(q1.hd-1, q1.node.left));
			
			if(q1.node.right!=null)								//if right child present, then add it to queue with hd=hd+1
				queue.add(new Qobj(q1.hd+1, q1.node.right));
		}
	}
	
	static void printMap(Map<Integer, List<Integer>> map, MinMaxPair minmax) {
		for(int i=minmax.min; i<=minmax.max; i++) {
			for(Integer val: map.get(i))
				System.out.print(val+" ");
			System.out.println();
		}
	}

}
