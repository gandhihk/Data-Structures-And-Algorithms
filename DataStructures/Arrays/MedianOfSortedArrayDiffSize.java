package ds.arrays;

public class MedianOfSortedArrayDiffSize {
	
	/*
	 * Solution 1: Efficient merge sort
	 * 1. Instead of creating new array for merging, keep count variable
	 * 2. do merge sort till count<=medianPos
	 * 3. while doing merge sort, keep 2 variables for storing median 
	 * candidates if arr len is even, else keep 1 variable
	 * Solution 2: Binary search in smaller array
	 * 1. Divide arrays A and B such that sum(left part of A,left part of B) = sum(left part of merged arr)
	 * 2. For cutting the arrays, consider 2 variables: leftASize, leftBSize
	 * 3. To know whether the partition is valid, consider 4 variables: leftMaxA, leftMaxB, rightMinA, rightMinB
	 *    find mid of arr1, set leftASize to mid, leftBSize to medianPos-mid
	 *    based on leftASize, leftBSize, find all 4 variables
	 *    Partition is correct if(leftMaxA<=rightMinB && leftMaxB<=rightMinA)
	 *    	then we have the median, calculate it based on arr len and return it
	 *    Else
	 *    	if(leftMaxA>rightMinB) -> we have to decrease size of A's left part, so end=mid-1
	 *    else
	 *    	if(leftMaxB>rightMinA) -> we have to decrease size of A's right part, so start=mid+1
	 */

	public static void main(String[] args) {
		int ar1[] = { -5, 3, 6, 12, 15 };
	    int ar2[] = { -12, -10, -6, -3, 4, 10 };
	 
	    int n1 = ar1.length;
	    int n2 = ar2.length;
	 
	    System.out.println(getMedianByMerge(ar1, ar2, n1, n2));
	    System.out.println(getMedianByBinarySearch(ar1, ar2, n1, n2));
	}

	private static double getMedianByMerge(int[] arr1, int[] arr2, int n, int m) {
		
		int count=0, m1=-1, m2=-1, i=0, j=0;
		int medianPos = (n+m)/2;
		
		if((n+m)%2 == 0) {	//even len
			while(count<=medianPos) {		//merge till count<medianPos
				m2 = m1;
				if(i<n && j<m) {			//move m1 till both arr ends
					m1 = arr1[i]>arr2[j] ? arr2[j++] : arr1[i++];  
				}else if(i<n)				//move m1 in arr1
					m1 = arr1[i++];
				else						//move m1 in arr2
					m1 = arr2[j++];
				count++;
			}
			
			return (m1+m2)/2;
		}else {
			while(count<=medianPos) {
				if(i<n && j<m)
					m1 = arr1[i]>arr2[j] ? arr2[j++] : arr1[i++];
				else if(i<n)
					m1 = arr1[i++];
				else
					m1 = arr2[j++];
				count++;
			}
			
			return m1;
		}	
	}

	private static double getMedianByBinarySearch(int[] arr1, int[] arr2, int n, int m) {
		
		if(n>m)		//swapping array if arr2 is smaller
			return getMedianByBinarySearch(arr2, arr1, m, n);
		
		int start=0, end=n;		//pointers to be used for BS in smaller array
		int leftASize, leftBSize; 		//cuts/partition pos in A and B
		int leftMaxA, leftMaxB, rightMinA, rightMinB; 
		int medianPos = (n+m+1)/2;		//medianPos denotes total no of elements in left of A+left of B
		
		int mid;
		while(start<=end) {
			mid = (start+end)/2;
			leftASize = mid;		//initially 
			leftBSize = medianPos-mid;
			
			leftMaxA = leftASize>0 ? arr1[leftASize-1] : Integer.MIN_VALUE;
			rightMinA = leftASize<n ? arr1[leftASize] : Integer.MAX_VALUE;
			leftMaxB = leftBSize>0 ? arr2[leftBSize-1] : Integer.MIN_VALUE;
			rightMinB = leftBSize<n ? arr2[leftBSize] : Integer.MAX_VALUE;
			
			if(leftMaxA<=rightMinB && leftMaxB<=rightMinA) {		//correct partition
				if((m+n)%2 == 0) {		//even len
					return (Math.max(leftMaxA, leftMaxB) + Math.min(rightMinA, rightMinB))/2;
				}else {		//odd len
					return Math.max(leftMaxA, leftMaxB);
				}
			}else if(leftMaxA>rightMinB) {		//decrease left part of A
				end = mid-1;
			}else {								//decrease right part of A
				start = mid+1;
			}
		}
		return 0;
	}
}
