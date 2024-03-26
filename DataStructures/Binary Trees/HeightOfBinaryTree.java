package ds.binarytree;


public class HeightOfBinaryTree {

	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	HeightOfBinaryTree() {
		root = null;
	}
	
	public static void main(String[] args) {
		HeightOfBinaryTree tree = new HeightOfBinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        System.out.println("Height of binary tree is "+findHeight(tree.root));

	}
	
	static int findHeight(Node root) {
		if(root==null)
			return 0;
		
		int lHeight = findHeight(root.left);
		int rHeight = findHeight(root.right);
		
		return Math.max(lHeight, rHeight)+1;
	}

}
