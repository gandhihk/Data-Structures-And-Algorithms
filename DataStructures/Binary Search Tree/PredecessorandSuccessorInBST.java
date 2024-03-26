package ds.binarysearchtree;

public class PredecessorandSuccessorInBST {
	
	Node root;
	 
	PredecessorandSuccessorInBST() {
        root = null;
    }

	static Node predecessor=null, successor = null;
	
	public static void main(String[] args) {
		PredecessorandSuccessorInBST tree = new PredecessorandSuccessorInBST();
		 
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
//        tree.insert(tree.root, 65);
// 
        System.out.print("Original BST: ");
        tree.inorder(tree.root);
        
        findPredecessorAndSuccessor(tree.root, 70);
        System.out.println("Pred: "+predecessor.key);
        System.out.println("Succ: "+successor.key);
	}
	
	static void findPredecessorAndSuccessor(Node tree, int n) {
		if(tree==null)
			return;
		
		if(tree.key==n) {
			if(tree.left!=null) {
				Node temp = tree.left;
				while(temp.right!=null)
					temp = temp.right;
				predecessor = temp;
			}else
				predecessor = tree;
			
			if(tree.right!=null) {
				Node temp = tree.right;
				while(temp.left!=null)
					temp = temp.left;
				successor = temp;
			}else
				successor = tree;
			
			return;
		}
		
		if(n<tree.key) {
			successor = tree;
			findPredecessorAndSuccessor(tree.left, n);
		}else if(n> tree.key) {
			predecessor = tree;
			findPredecessorAndSuccessor(tree.right, n);
		}
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
