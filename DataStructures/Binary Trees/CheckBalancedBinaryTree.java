package ds.binarytree;


public class CheckBalancedBinaryTree {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	CheckBalancedBinaryTree(){
		root = null;
	}

	public static void main(String[] args) {
		CheckBalancedBinaryTree tree = new CheckBalancedBinaryTree();
		tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(20);
        tree.root.right.right.left = new Node(123);

        System.out.println("Balanced : "+checkHeights(tree.root));
	}
	
	static int checkHeights(Node root) {
		if(root==null)				//base case, return height as 0 for leaf nodes
			return 0;
		
		int lHeight = checkHeights(root.left);			//recursively find left subtree height
		if(lHeight == -1)						//check if left subtree is balanced, return if not balanced
			return -1;
		
		int rHeight = checkHeights(root.right);			//recursively find right subtree height
		if(rHeight == -1)						//check if right subtree is balanced, return if not balanced
			return -1;
		
		if(Math.abs(lHeight - rHeight) > 1)				//check if diff of heights of left and right subtree is >1
			return -1;							//return, not balanced
		else									
			return Math.max(lHeight, rHeight)+1;		//else return max of height of left/right subtree + 1
		
	}

}
