package ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	LevelOrderTraversal(){
		root = null;
	}

	public static void main(String[] args) {
		LevelOrderTraversal tree = new LevelOrderTraversal();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
            printLevelOrder(tree.root);
	}
	
	static void printLevelOrder(Node root) {
		if(root==null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			System.out.print(curr.key+" ");
			
			if(curr.left!=null)
				queue.add(curr.left);
			if(curr.right!=null)
				queue.add(curr.right);
		}
	}

}
