package ds.binarysearchtree;

public class MergeTwoBST {
	
	static Node prev=null;

	public static void main(String[] args) {
		Node root = new Node(100);
	    root.left = new Node(50);
	    root.right = new Node(300);
	    root.left.left = new Node(20);
	    root.left.right = new Node(70);
	    
	    Node root2 = new Node(80);
	    root2.left = new Node(40);
	    root2.right = new Node(120);
	    
	    Node mergedTree = mergeBST(root, root2, 5, 3);
	    System.out.println("Merged : ");
	    printInorder(mergedTree);
	}

	static Node mergeBST(Node tree1, Node tree2, int m, int n) {
		Node head1[] = new Node[1];
		head1[0] = null;
		bstToDLL(tree1, head1);
		
		Node head2[] = new Node[1];
		head2[0] = null;
		prev = null;
		bstToDLL(tree2, head2);
		
		Node tree3 = merge(head1[0], head2[0]);
		
		return llToBST(new Node[] {tree3}, m+n);
	}
	
	static void bstToDLL(Node tree, Node[] head) {
		if(tree==null)
			return;
		
		bstToDLL(tree.left, head);
		
		if(prev==null)
			head[0] = tree;
		else {
			prev.right = tree;
			tree.left = prev;
		}
		prev = tree;
		
		bstToDLL(tree.right, head);
	}
	
	static Node merge(Node head1, Node head2) {
		Node head = null, tail = null;
		while(head1!=null && head2!=null) {
			if(head1.key<head2.key) {
				if(head==null)
					head = head1;
				else {
					tail.right = head1;
					head1.left = tail;
				}
				tail = head1;
				head1 = head1.right;
			}
			else {
				if(head==null)
					head = head2;
				else {
					tail.right = head2;
					head2.left = tail;
				}
				tail = head2;
				head2 = head2.right;
			}
		}
		
		while(head1!=null) {
			tail.right = head1;
			head1.left = tail;
			tail = head1;
			head1 = head1.right;
		}
		while(head2!=null) {
			tail.right = head2;
			head2.left = tail;
			tail = head2;
			head2 = head2.right;
		}
		
		return head;
	}
	
	static Node llToBST(Node head[], int n) {
		if(head[0]==null || n<=0)
			return null;
			
		Node left = llToBST(head, n/2);
		Node root = head[0];
		head[0] = head[0].right;
		root.left = left;
		
		root.right = llToBST(head, n-(n/2)-1);
		return root;
	}
	
	static void printInorder(Node root) {
		if(root!=null) {
			printInorder(root.left);
			System.out.print(root.key+" ");
			printInorder(root.right);
		}
	}
}
