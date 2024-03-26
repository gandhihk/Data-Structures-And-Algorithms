package ds.binarytree;

import java.util.ArrayList;
import java.util.List;

public class ReverseLevelOrderTraversal {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	ReverseLevelOrderTraversal(){
		root = null;
	}

	public static void main(String[] args) {
		ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        System.out.println("Preorder traversal of binary tree is ");
        printReverseLevelOrder(tree.root);

	}

	static void printReverseLevelOrder(Node root) {
		int index = 0;
		List<Node> list = new ArrayList<>();
		list.add(root);
		
		while(index!=list.size()) {
			Node curr = list.get(index);
			if(curr.right!=null)
				list.add(curr.right);
			if(curr.left!=null)
				list.add(curr.left);
			index++;
		}
		
		index--;
		while(index>=0) {
			System.out.print(list.get(index--).key+" ");
		}
	}
}
