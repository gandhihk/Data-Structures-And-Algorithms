package ds.searching;

public class EKOSPOJ {

	public static void main(String[] args) {
		int n=5, m=20;
		int[] trees = {4, 42, 40, 26, 46};
		System.out.println(findMaxHeight(trees, n, m));

	}
	
	static int findMaxHeight(int[] trees, int n, int m) {
		int low=0, high=Integer.MIN_VALUE;
		for(int i=0; i<trees.length; i++)
			if(trees[i]>high)
				high = trees[i];
		
		int ans=0, mid;
		while(low<=high) {
			mid = low+(high-low)/2;
			
			if(possible(trees, mid, m)) {
				ans = mid;
				
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return ans;
	}
	
	static boolean possible(int[] trees, int height, int m) {
		int curr_wood=0;
		for(int i=0; i<trees.length; i++) {
			if(trees[i]>height) {
				curr_wood+=trees[i]-height;
			}
		}
		return curr_wood>=m;
	}

}
