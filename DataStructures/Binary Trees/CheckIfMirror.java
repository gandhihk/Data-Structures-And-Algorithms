package ds.binarytree;

public class CheckIfMirror {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node a, b;
	CheckIfMirror(){
		a = null; b = null;
	}

	public static void main(String[] args) {
		Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
 
        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);
 
        if (areMirror(a, b) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
	}

	static boolean areMirror(Node tree1, Node tree2) {
		if(tree1==null && tree2==null)		//if both are leaf nodes, return true
			return true;
		
		if(tree1==null || tree2==null)		//if one of them is leaf, return false
			return false;
		
		//for non-leaf nodes return true if the data is same
		//and if 1st tree's left subtree is same as 2nd tree's right subtree
		//and if 1st tree's right subtree is same as 2nd tree's left subtree
		return tree1.key==tree2.key 
				&& areMirror(tree1.left, tree2.right)
				&& areMirror(tree1.right, tree2.left);
	}
}
