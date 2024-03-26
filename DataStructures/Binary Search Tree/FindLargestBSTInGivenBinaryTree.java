package ds.binarysearchtree;

public class FindLargestBSTInGivenBinaryTree {
	static int minInt=Integer.MIN_VALUE;
	static int maxInt=Integer.MAX_VALUE;
	
	static class Answer{
		int min, max, size;
		Answer(int min, int max, int size){
			this.min=min; this.max=max; this.size=size;
		}
		public Answer() {}
	}

	public static void main(String[] args) {
		Node root = new Node(50);
        root.left = new Node(75);
        root.right = new Node(45);
        root.left.left = new Node(40);
        System.out.println("Size of the largest BST is "
                           + largestBSTInBT(root).size);
	}
	
	static Answer largestBSTInBT(Node root) {
		if(root==null)				//base case if tree is empty
			return new Answer(maxInt, minInt, 0);
		
		//return the leaf node itself as min/max and size as 1
		if(root.left==null && root.right==null)
			return new Answer(root.key, root.key, 1);
		
		//recur in left and right subtrees
		Answer left = largestBSTInBT(root.left);
		Answer right = largestBSTInBT(root.right);
		
		Answer ans = new Answer();
		//if the root and subtrees satisfy BST condition
		if(left.max<root.key && right.min>root.key) {
			ans.min = Math.min(root.key, Math.min(left.min, right.min));			//set min as min of (root, left_min, right_min)
			ans.max = Math.max(root.key, Math.max(left.max, right.max));			//set max as max of(root, left_max, right max)
			ans.size = 1+left.size+right.size;			//set size as 1+leftsize+rightsize
			return ans;
		}
		
		//if doesn't satisfy BST condition then return min/max such that its parent can't satisfy BST condition
		ans.min = minInt;
		ans.max = maxInt;
		ans.size = Math.max(left.size, right.size);		//return size as max size found in its subtrees
		return ans;
	}

}
