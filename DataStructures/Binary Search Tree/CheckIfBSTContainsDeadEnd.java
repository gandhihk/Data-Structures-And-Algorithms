package ds.binarysearchtree;

public class CheckIfBSTContainsDeadEnd {
	
	Node root;
	 
    // Constructor
	CheckIfBSTContainsDeadEnd() {
        root = null;
    }

	public static void main(String[] args) {
		CheckIfBSTContainsDeadEnd tree = new CheckIfBSTContainsDeadEnd();
				/*       8
		        /   \
		       5    11
		      /  \
		     2    7
		      \
		       3
		        \
		         4 */
		 tree.insert(8);
		 tree.insert(5);
		 tree.insert(2);
		 tree.insert(3);
		 tree.insert(7);
		 tree.insert(11);
		 tree.insert(4);
		
		 if (tree.deadEnd(tree.root , 1,
		         Integer.MAX_VALUE) == true)
		
		 System.out.println("Yes ");
		 else
		 System.out.println("No " );
	}
	
	boolean deadEnd(Node root, int min, int max) {
		if(root==null)
			return false;
		
		if(min==max)
			return true;
		
		return deadEnd(root.left, min, root.key-1) 
				|| deadEnd(root.right, root.key+1, max);
	}

	
	void insert(int data) {
    	root = insertRec(root, data);
    }
 
    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int data) {
 
        // If the tree is empty,
        // return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (data < root.key)
            root.left = insertRec(root.left, data);
        else if (data > root.key)
            root.right = insertRec(root.right, data);
 
        /* return the (unchanged) node pointer */
        return root;
    }
}
