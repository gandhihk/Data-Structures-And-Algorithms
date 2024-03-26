package ds.binarytree;

public class SumOfLongestPath {
	
	static class Node{
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	}
	
	static class Pair{
		int currLen;
		int currSum;
		Pair(int len, int sum){
			currLen = len; currSum = sum;
		}
	}
	
	Node root;
	SumOfLongestPath() {
		root = null;
	}

	static int maxLength = 0;
	static int maxSum = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Node root = new Node(4);         /*        4        */
        root.left = new Node(2);         /*       / \       */
        root.right = new Node(5);        /*      2   5      */
        root.left.left = new Node(7);    /*     / \ / \     */
        root.left.right = new Node(1);   /*    7  1 2  3    */
        root.right.left = new Node(2);   /*      /          */
        root.right.right = new Node(3);  /*     6           */
        root.left.right.left = new Node(6);
      
        sumOfLongestPath(root, 0, 0);
        System.out.println( "Sum = "
             + maxSum+" Path length= "+maxLength);
        System.out.println("Sum : "+sumOfLongestPath(root).currSum);
	}
	
	static Pair sumOfLongestPath(Node tree){
		if(tree == null)			//for leaf node, return height and sum both 0
			return new Pair(0, 0);
		
		//recursively get the heights and sums of left and right subtree
		Pair a = sumOfLongestPath(tree.left);
		Pair b = sumOfLongestPath(tree.right);
		
		//return longer subtree's length+1 and sum
		if(a.currLen>b.currLen)
			return new Pair(a.currLen+1, a.currSum+tree.key);
		else if(b.currLen>a.currLen)
			return new Pair(b.currLen+1, b.currSum+tree.key);
		else			//if both have same heights then return larger sum
			return new Pair(a.currLen+1, Math.max(a.currSum, b.currSum)+tree.key);
	}
	
	static void sumOfLongestPath(Node tree, int currLen, int currSum) {
		if(tree == null) {				//if leaf node is reached, check for lengths
			if(currLen > maxLength) {	//if this path has max length, then update max length and max sum
				maxLength = currLen;
				maxSum = currSum;
			}else if(currLen==maxLength) {	//else if it has same length, then update max sum
				maxSum = currSum;
			}
			return;			//return from this path
		}
		
		//recursively call left and right subtrees by increasing lengths and adding current node's data in sum
		sumOfLongestPath(tree.left, currLen+1, currSum+tree.key);
		sumOfLongestPath(tree.right, currLen+1, currSum+tree.key);
	}

}
