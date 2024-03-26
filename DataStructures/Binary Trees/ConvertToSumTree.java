package ds.binarytree;

public class ConvertToSumTree {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	ConvertToSumTree(){
		root = null;
	}

	public static void main(String[] args) {
		ConvertToSumTree tree = new ConvertToSumTree();
		tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);
        convertToSumTree(tree.root);
        System.out.println("Sum tree: ");
        printTree(tree.root);
	}
	
	static int convertToSumTree(Node node) {
		//base case to set 0 for leaf nodes
		if(node==null)
			return 0;
		
		int leftSum = convertToSumTree(node.left);		//get left subtree sum
		int rightSum = convertToSumTree(node.right);	//get right subtree sum
		int currNode = node.key;						//store this node's value
		node.key = leftSum+rightSum;					//set this node's value as sum of its subtrees
		
		return leftSum+rightSum+currNode;				//return sum of subtrees and this node's value
	}
	
	public static void printTree(Node node)
	{
	    if (node == null)
	        return;
	    printTree(node.left);
	    System.out.println(node.key + " ");
	    printTree(node.right);
	}

}
