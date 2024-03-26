package ds.binarysearchtree;

public class CheckIfBST {
	
	static Node prev=null;

	public static void main(String[] args) {
		Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
 
        // Function call
        if (isBST(root))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
	}
	
	static boolean isBST(Node tree) {
		if(tree==null)
			return true;
		
		if(!isBST(tree.left))
			return false;
		
		if(prev!=null && prev.key>=tree.key)
			return false;
		
		prev = tree;
		
		if(!isBST(tree.right))
			return false;
		
		return true;
	}

}
