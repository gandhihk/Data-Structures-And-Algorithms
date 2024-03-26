package ds.binarysearchtree;

public class KthLargestOrSmallestInBST {

	public static void main(String[] args) {
		Node root = new Node(4); 
	    root.left = new Node(2); 
	    root.right = new Node(7); 
	    root.left.left = new Node(1); 
	    root.left.right = new Node(3); 
	    root.right.left = new Node(6); 
	    root.right.right = new Node(10); 
	 
	    System.out.println("Finding K-th smallest Node in BST : " + 
	                    KthSmallestUsingMorrisTraversal(root, 5).key);
	    
	    System.out.println("Finding K-th largest Node in BST : " + 
                KthLargestUsingMorrisTraversal(root, 5).key);
	}

	static Node KthSmallestUsingMorrisTraversal(Node root, int k) {
		int count=0;
		Node ans = null;
		while(root!=null) {
			if(root.left==null) {
				if(++count==k)
					ans = root;
				root = root.right;
			}else {
				Node pred = root.left;
				while(pred.right!=null && pred.right!=root)
					pred = pred.right;
				
				if(pred.right==null) {
					pred.right = root;
					root = root.left;
				}else {
					pred.right=null;
					if(++count==k)
						ans = root;
					root = root.right;
				}
			}
		}
		return ans;
	}
	
	static Node KthLargestUsingMorrisTraversal(Node root, int k) {
		int count=0;
		Node ans = null;
		while(root!=null) {
			if(root.right==null) {
				if(++count==k)
					ans = root;
				root = root.left;
			}else {
				Node succ = root.right;
				while(succ.left!=null && succ.left!=root)
					succ = succ.left;
				
				if(succ.left==null) {
					succ.left = root;
					root = root.right;
				}else {
					succ.left=null;
					if(++count==k)
						ans = root;
					root = root.left;
				}
			}
		}
		return ans;
	}
}
