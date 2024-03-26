package ds.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LCA {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	LCA(){
		root = null;
	}

	public static void main(String[] args) {
		LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = "
                           + tree.findLCA(4, 5));
        
        System.out.println("LCA(4, 5) = "
                + tree.findLCA2(4, 5, tree.root).key);

	}
	
	int findLCA(int n1, int n2) {
		List<Integer> path1 = new ArrayList<>();
		findPath(root, n1, path1);
		
		List<Integer> path2 = new ArrayList<>();
		findPath(root, n2, path2);
		
		int i=0;
		for(i=0; i<path1.size(); i++) {
			if(path1.get(i)!=path2.get(i))
				break;
		}
		return path1.get(i-1);
	}
	
	static boolean findPath(Node tree, int n, List<Integer> path){
		if(tree==null)
			return false;
		
		path.add(tree.key);
		
		if(tree.key==n || findPath(tree.left, n, path)
				|| findPath(tree.right, n, path))
			return true;
		
		path.remove(path.size()-1);
		
		return false;
	}
	
	Node findLCA2(int n1, int n2, Node tree){
		if(tree==null)
			return null;
		
		if(tree.key==n1 || tree.key==n2)
			return tree;
		
		Node l_LCA = findLCA2(n1, n2, tree.left);
		Node r_LCA = findLCA2(n1, n2, tree.right);
		
		if(l_LCA!=null && r_LCA!=null)
			return tree;
		
		return l_LCA!=null ? l_LCA : r_LCA;
	}

}
