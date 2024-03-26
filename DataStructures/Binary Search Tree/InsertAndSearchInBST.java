package ds.binarysearchtree;

public class InsertAndSearchInBST {
	
	Node root;
	 
    // Constructor
	InsertAndSearchInBST() {
        root = null;
    }

	public static void main(String[] args) {
		InsertAndSearchInBST tree = new InsertAndSearchInBST();
		 
        // Inserting nodes
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);
 
        // Key to be found
        int key = 20;
 
        // Searching in a BST
        if (tree.search(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");
	}

	Node insert(Node root, int key) {
		if(root==null)
			return new Node(key);
		
		if(key<root.key)
			root.left = insert(root.left, key);
		else if(key>root.key)
			root.right = insert(root.right, key);
		
		return root;
	}
	
	Node search(Node root, int key) {
		if(root==null || root.key==key)
			return root;
		
		if(key<root.key)
			return search(root.left, key);
		
		return search(root.right, key);
	}
}
