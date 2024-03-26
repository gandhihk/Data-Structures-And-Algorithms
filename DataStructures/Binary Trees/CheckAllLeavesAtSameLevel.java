package ds.binarytree;

public class CheckAllLeavesAtSameLevel {
	static int leafLevel=0;
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	CheckAllLeavesAtSameLevel(){
		root = null;
	}

	public static void main(String[] args) {
		CheckAllLeavesAtSameLevel tree = new CheckAllLeavesAtSameLevel();
		tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);
        System.out.println("All leaves are at same level: "+checkLeavesLevel(tree.root, 0));

	}

	static boolean checkLeavesLevel(Node node, int currLevel) {
		if(node==null)				//base case
			return true;
		
		// If a leaf node is encountered
		if(node.left==null && node.right==null) {
			// When a leaf node is found first time
			if(leafLevel == 0) {
				// Set first found leaf's level
				leafLevel = currLevel;
				return true;
			}
			
			// If this is not first leaf node, compare its level with
            // first leaf's level
			return (leafLevel == currLevel);
		}
		
		// If this node is not leaf, recursively check left and right subtrees
		return checkLeavesLevel(node.left, currLevel+1) 
				&& checkLeavesLevel(node.right, currLevel+1);
	}
}
