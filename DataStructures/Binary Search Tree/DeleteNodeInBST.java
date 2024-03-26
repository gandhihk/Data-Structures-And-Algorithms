package ds.binarysearchtree;

public class DeleteNodeInBST {
	
	Node root;
	 
    DeleteNodeInBST() {
        root = null;
    }

	public static void main(String[] args) {
		DeleteNodeInBST tree = new DeleteNodeInBST();
		 
        /* Let us create following BST
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80 */
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 65);
 
        System.out.print("Original BST: ");
        tree.inorder(tree.root);
 
        System.out.println("\n\nDelete a Leaf Node: ");
        tree.root = tree.deleteNode(tree.root, 50);
        System.out.print("Modified BST tree after deleting Leaf Node:\n");
        tree.inorder(tree.root);
	}
	
	Node deleteNode(Node tree, int n) {
		if(tree==null)
			return null;
		
		if(tree.key==n) {
			if(tree.left==null && tree.right==null)
				return null;
			
			if(tree.left==null)
				return tree.right;
			else if(tree.right==null)
				return tree.left;
			else {
				Node successor = tree.right;
				Node succParent = tree;
				while(successor.left!=null) {
					succParent = successor;
					successor = successor.left;
				}
				
				tree.key = successor.key;
				
				if(succParent == tree)
					tree.right = successor.right;
				else
					succParent.left = successor.right;
				
				return tree;
			}
		}
		
		if(n<tree.key) {
			tree.left = deleteNode(tree.left, n);
		}else if(n>tree.key) {
			tree.right = deleteNode(tree.right, n);
		}
		return tree;
	}
	
	void inorder(Node tree) {
		if(tree==null)
			return;
		inorder(tree.left);
		System.out.print(tree.key+" ");
		inorder(tree.right);
	}
	
	Node insert(Node tree, int key) {
		if(tree==null)
			return new Node(key);
		
		if(key<tree.key)
			tree.left = insert(tree.left, key);
		else if(key>tree.key)
			tree.right = insert(tree.right, key);
		
		return tree;
	}

}
