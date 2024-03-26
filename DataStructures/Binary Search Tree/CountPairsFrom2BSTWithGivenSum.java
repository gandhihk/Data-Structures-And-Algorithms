package ds.binarysearchtree;

import java.util.Stack;

public class CountPairsFrom2BSTWithGivenSum {

	public static void main(String[] args) {
		// formation of BST 1
        Node root1;
		root1 = new Node(5);       /*             5        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(7); /*         3     7     */
        root1.left.left = new Node(2); /*    / \   / \    */
        root1.left.right = new Node(4); /*  2   4 6   8    */
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);
      
        // formation of BST 2
        Node root2;
        root2 = new Node(10);        /*           10         */
        root2.left = new Node(6); /*           /   \        */
        root2.right = new Node(15); /*        6     15      */
        root2.left.left = new Node(3); /*    / \   /  \     */
        root2.left.right = new Node(8); /*  3  8  11  18    */
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);
      
        int x = 16;
        System.out.println("Pairs = "
             + countPairs(root1, root2, x));
	}
	
	static int countPairs(Node root1, Node root2, int x) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		int count=0;
		
		while(true) {
			while(root1!=null) {
				stack1.push(root1);
				root1 = root1.left;
			}
			while(root2!=null) {
				stack2.push(root2);
				root2 = root2.right;
			}
			
			if(stack1.isEmpty() || stack2.isEmpty())
				break;
			
			Node top1 = stack1.peek();
			Node top2 = stack2.peek();
			
			if(top1.key+top2.key == x) {
				count++;
				stack1.pop();
				stack2.pop();
				root1 = top1.right;
				root2 = top2.left;
			}else if(top1.key+top2.key < x) {
				stack1.pop();
				root1 = top1.right;
			}else {
				stack2.pop();
				root2 = top2.left;
			}
		}
		return count;
	}

}
