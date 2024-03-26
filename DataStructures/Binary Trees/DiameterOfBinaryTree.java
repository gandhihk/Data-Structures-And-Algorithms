package ds.binarytree;

public class DiameterOfBinaryTree {

	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}

	Node root;
	DiameterOfBinaryTree(){
		root = null;
	}
	static int max=0;
	
	public static void main(String[] args) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        findDiameter(tree.root);
        System.out.println("Diameter= "+max);

	}
	
	static int findDiameter(Node root) {
		if(root==null)
			return 0;
		
		int lHeight = findDiameter(root.left);
		int rHeight = findDiameter(root.right);
		
		max = Math.max(max, 1 + lHeight + rHeight);
		
		return 1 + Math.max(lHeight, rHeight);
	}

}
