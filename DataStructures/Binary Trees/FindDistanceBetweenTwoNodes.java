package ds.binarytree;

public class FindDistanceBetweenTwoNodes {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 6) = "
                           + findDistance(root, 4, 6));
	}
	
	static int findDistance(Node tree, int n1, int n2) {
		Node lca = findLCA(tree, n1, n2);
		
		int d1 = findDistFromLCA(lca, n1, 0);
		int d2 = findDistFromLCA(lca, n2, 0);
		
		return d1+d2;
	}
	
	static Node findLCA(Node tree, int n1, int n2) {
		if(tree==null)
			return null;
		
		if(tree.key==n1 || tree.key==n2)
			return tree;
		
		Node l_LCA = findLCA(tree.left, n1, n2);
		Node r_LCA = findLCA(tree.right, n1, n2);
		
		if(l_LCA!=null && r_LCA!=null)
			return tree;
		
		return l_LCA!=null ? l_LCA : r_LCA;
	}
	
	static int findDistFromLCA(Node root, int n1, int level) {
		if(root==null)
			return -1;
		
		if(root.key==n1)
			return level;
		
		int left = findDistFromLCA(root.left, n1, level+1);
		
		return left!=-1 ? left : findDistFromLCA(root.right, n1, level+1);	
	}
}
