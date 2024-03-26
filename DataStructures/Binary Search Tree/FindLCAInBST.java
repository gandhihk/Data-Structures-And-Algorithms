package ds.binarysearchtree;

public class FindLCAInBST {

	public static void main(String[] args) {
		Node root = new Node(5);
        root.left = new Node(4);
        root.left.right = new Node(3);
        root.right = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        
        System.out.println(findLCA(root, 4, 3).key);
	}
	
	static Node findLCA(Node tree, int n1, int n2) {
		if(tree==null)
			return null;
		
		if(n1<tree.key && n2<tree.key)
			return findLCA(tree.left, n1, n2);
		else if(n1>tree.key && n2>tree.key)
			return findLCA(tree.right, n1, n2);
		else
			return tree;
	}

}
