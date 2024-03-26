package ds.binarysearchtree;

public class ConstructBSTFromPreorder {

	static int preIndex=0;
	
	public static void main(String[] args) {
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
        int size = pre.length;
        
        Node root = constructTree(pre, Integer.MAX_VALUE, size);
        
        printInorder(root);
	}
	
	static Node constructTree(int[] pre, int rootMax, int size) {
		//two base cases: if traversal is complete or new node cannot be added in this subtree
		if(preIndex>=size || pre[preIndex]>rootMax)
			return null;
		
		Node tree = new Node(pre[preIndex++]);			//create new node
		
		//create its left subtree and set it to its left
		tree.left = constructTree(pre, tree.key, size);			//pass curr node's key as max bound
		
		//create its right subtree and set it to its right
		tree.right = constructTree(pre, rootMax, size);			//pass root's key as max bound
		
		return tree;
	}

	static void printInorder(Node tree) {
		if(tree!=null) {
			printInorder(tree.left);
			System.out.print(tree.key+" ");
			printInorder(tree.right);
		}
	}
}
