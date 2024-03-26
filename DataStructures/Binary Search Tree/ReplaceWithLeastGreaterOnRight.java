package ds.binarysearchtree;

public class ReplaceWithLeastGreaterOnRight {
	
	static Node succ, root;

	public static void main(String[] args) {
		int arr[]
	            = new int[] { 8,  58, 71, 18, 31, 32, 63, 92,
	                          43, 3,  91, 93, 25, 80, 28 };
	        int n = arr.length;
	 
	        replace(arr, n);
	 
	        for (int i = 0; i < n; i++)
	            System.out.print(arr[i] + " ");
	}

	static void replace(int[] arr, int n) {
		for(int i=n-1; i>=0; i--) {
			succ = null;
			
			root = insert(root, arr[i]);
			
			if(succ!=null)
				arr[i] = succ.key;
			else
				arr[i] = -1;
		}
	}
	
	static Node insert(Node root, int key) {
		if(root==null)
			return new Node(key);
		
		if(key<root.key) {
			succ = root;
			root.left = insert(root.left, key);
		}else
			root.right = insert(root.right, key);
		
		return root;
	}
}
