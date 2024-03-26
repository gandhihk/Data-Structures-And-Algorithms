package ds.binarytree;

public class CheckIfIsomorphic {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root1, root2;
	CheckIfIsomorphic(){
		root1 = null; root2 = null;
	}

	public static void main(String[] args) {
		CheckIfIsomorphic tree = new CheckIfIsomorphic();
        
        // Let us create trees shown in above diagram
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
        tree.root1.right.left = new Node(6);
        tree.root1.left.right.left = new Node(7);
        tree.root1.left.right.right = new Node(8);
  
        tree.root2 = new Node(1);
        tree.root2.left = new Node(3);
        tree.root2.right = new Node(2);
        tree.root2.right.left = new Node(4);
        tree.root2.right.right = new Node(5);
        tree.root2.left.right = new Node(6);
        tree.root2.right.right.left = new Node(8);
        tree.root2.right.right.right = new Node(7);
  
        if (tree.isIsomorphic(tree.root1, tree.root2) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
	}

	boolean isIsomorphic(Node tree1, Node tree2) {
		if(tree1==null && tree2==null)		//if both are leaf nodes, return true
			return true;
		
		if(tree1==null || tree2==null)		//if one of them is leaf, return false
			return false;
		
		//for non-leaf nodes return false if the data is not same
		if(tree1.key!=tree2.key)
			return false;
		
		//if the subtrees are flipped then their alternate children should be isomorphic
		return ((isIsomorphic(tree1.left, tree2.right) && isIsomorphic(tree1.right, tree2.left))
				//OR if they are not flipped, their same children should be isomorphic
					|| (isIsomorphic(tree1.left, tree2.left) && isIsomorphic(tree1.right, tree2.right)));
	}
}
