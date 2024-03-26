package ds.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalTraversal {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	DiagonalTraversal(){
		root = null;
	}

	public static void main(String[] args) {
		DiagonalTraversal tree = new DiagonalTraversal();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        System.out.println("Diagonal traversal : ");
        diagonalTraversal(tree.root);
	}
	
	static void diagonalTraversal(Node root) {
		Queue<Node> leftQueue = new LinkedList<>();
		Node curr = root;
		List<Node> ans = new ArrayList<>();
		
		while(curr!=null) {					//run loop while there is pointer to start diagonal
			
			ans.add(curr);					//add this node to ans
			
			if(curr.left!=null)				//if left child present, add it to queue
				leftQueue.add(curr.left);
			
			if(curr.right!=null)			//if right child present, move to that node for diagonal traversal
				curr = curr.right;
			else {							//else check if there are left nodes in queue for new diagonal
				if(!leftQueue.isEmpty()) {		
					curr = leftQueue.poll();
				}else						//if not, then end here
					curr = null;
			}
		}
		
		for(Node n: ans)
			System.out.print(n.key+" ");
	}

}
