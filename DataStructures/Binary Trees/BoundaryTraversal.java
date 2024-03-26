package ds.binarytree;


public class BoundaryTraversal {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	BoundaryTraversal(){
		root = null;
	}

	public static void main(String[] args) {
		BoundaryTraversal tree = new BoundaryTraversal();
		tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        
        System.out.println("Boundary traversal : ");
        boundaryTraversal(tree.root);

	}
	
	static void boundaryTraversal(Node root) {
		System.out.print(root.key+" ");
		// Print the left boundary in top-down manner.
		printLeftBoundary(root.left);
		
		// Print all leaf nodes
		printLeaves(root.left);
		printLeaves(root.right);
		
		// Print the right boundary in bottom-up manner
		printRightBoundary(root.right);
	}
	
	static void printLeftBoundary(Node curr) {
		if(curr == null)
			return;
		
		if(curr.left!=null) {
			// to ensure top down order, print the node
            // before calling itself for left subtree
			System.out.print(curr.key+" ");
			printLeftBoundary(curr.left);
		}else if(curr.right!=null) {
			System.out.print(curr.key+" ");
			printLeftBoundary(curr.right);
		}
	}
	
	static void printRightBoundary(Node curr) {
		if(curr==null)
			return;
		
		if(curr.right!=null) {
			// to ensure bottom up order, first call for right
            // subtree, then print this node
			printRightBoundary(curr.right);
			System.out.print(curr.key+" ");
		}else if(curr.left!=null) {
			printRightBoundary(curr.left);
			System.out.print(curr.key+" ");
		}
	}
	
	static void printLeaves(Node curr) {
		if(curr==null)
			return;
		
		//Do inorder traversal and print only if its leaf node
		
		printLeaves(curr.left);
		// Print it if it is a leaf node
		if(curr.left==null && curr.right==null)
			System.out.print(curr.key+" ");
		printLeaves(curr.right);
	}

}
