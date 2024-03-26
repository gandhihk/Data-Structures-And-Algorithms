package ds.searching;

public class KthElementOf2SortedArrays {

	public static void main(String[] args) {
		int array1[] = {2,3,6,7,9};
	    int array2[] = {1,4,8,10};
	    int m = array1.length;
	    int n = array2.length;
	    int k = 5;
	    System.out.println("The element at the kth position is "+kthElement(array1,array2,m,n,k));

	}
	
	static int kthElement(int[] a1, int[] a2, int m, int n, int k) {
		if(m>n)
			return kthElement(a2, a1, n, m, k);
		
		int low = Math.max(0, k-m);				//low of search space for cut1 in a1
		int high = Math.min(k, n);				//high of search space for cut1 in a1
		
		while(low<=high) {
			int cut1 = (low + high)/2; 			//cut in a1, acts as mid
        	int cut2 = k - cut1;				//cut in a2
        	int l1 = cut1==0 ? Integer.MIN_VALUE : a1[cut1-1];
        	int l2 = cut2==0 ? Integer.MIN_VALUE : a2[cut2-1];
        	int r1 = cut1==n ? Integer.MAX_VALUE : a1[cut1];
        	int r2 = cut2==m ? Integer.MAX_VALUE : a2[cut2];
        	
        	if(l1<=r2 && l2<=r1) {
        		return Math.max(l1, l2);
        	}else if(l1>r2) {
        		high = cut1-1;
        	}else {
        		low = cut1+1;
        	}
		}
		return -1;
	}

}
