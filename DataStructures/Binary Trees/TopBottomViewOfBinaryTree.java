package ds.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopBottomViewOfBinaryTree {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
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
	
	static class MinMaxPair {
		int min, max;
	}
	
	Node root;
	TopBottomViewOfBinaryTree(){
		root = null;
	}

	public static void main(String[] args) {
		TopBottomViewOfBinaryTree tree = new TopBottomViewOfBinaryTree();
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

        System.out.println("Top view of tree is ");
        Map<Integer, Integer> map = new HashMap<>();				//map to store the top nodes for each hd
        MinMaxPair minmax = new MinMaxPair();						//min and max hd
        printTopViewLevelOrderTraversal(tree.root, map, minmax);
        printMap(map, minmax);
        
        System.out.println("\nBottom view of tree is ");
        map = new HashMap<>();				//map to store the bottom nodes for each hd
        minmax = new MinMaxPair();						//min and max hd
        printBottomViewLevelOrderTraversal(tree.root, map, minmax);
        printMap(map, minmax);
	}
	
	static void printTopViewLevelOrderTraversal(Node root, Map<Integer, Integer> map, MinMaxPair minmax) {
		Queue<Qobj> queue = new LinkedList<>();						//queue for level order traversal
		queue.add(new Qobj(0, root));								//add root
		
		while(!queue.isEmpty()) {
			Qobj curr = queue.poll();
			
			if(!map.containsKey(curr.hd))							//if map does not contain any node with this hd, then add this node to map for this hd
				map.put(curr.hd, curr.node.key);
			
			minmax.min = Math.min(minmax.min, curr.hd);				//keep track of min hd
			minmax.max = Math.max(minmax.max, curr.hd);				//keep track of max hd
			
			if(curr.node.left!=null)								//if left child present, then add it to queue with hd=hd-1
				queue.add(new Qobj(curr.hd-1, curr.node.left));
			
			if(curr.node.right!=null)								//if right child present, then add it to queue with hd=hd+1
				queue.add(new Qobj(curr.hd+1, curr.node.right));
		}
	}
	
	static void printBottomViewLevelOrderTraversal(Node root, Map<Integer, Integer> map, MinMaxPair minmax) {
		Queue<Qobj> queue = new LinkedList<>();						//queue for level order traversal
		queue.add(new Qobj(0, root));								//add root
		
		while(!queue.isEmpty()) {
			Qobj curr = queue.poll();
			
			map.put(curr.hd, curr.node.key);						//replace the node in map for given hd, so that for every hd the node is always the last nodes
			
			minmax.min = Math.min(minmax.min, curr.hd);				//keep track of min hd
			minmax.max = Math.max(minmax.max, curr.hd);				//keep track of max hd
			
			if(curr.node.left!=null)								//if left child present, then add it to queue with hd=hd-1
				queue.add(new Qobj(curr.hd-1, curr.node.left));
			
			if(curr.node.right!=null)								//if right child present, then add it to queue with hd=hd+1
				queue.add(new Qobj(curr.hd+1, curr.node.right));
		}
	}
	
	static void printMap(Map<Integer, Integer> map, MinMaxPair minmax) {
		for(int i=minmax.min; i<=minmax.max; i++) {
			System.out.print(map.get(i)+" ");
		}
	}

}
