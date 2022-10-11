package ds.arrays;

public class MedianOfSortedArraySameSize {
	
	/*
	 * A Java program to divide and conquer based efficient solution to find 
	 * median of two sorted arrays of same size.
	 * Solution: Binary search
	 * 1. get medians of two arrays by getting middle element
	 * 2. compare these medians m1,m2. if they are equal, return them
	 * 3. else if m1<m2, then our median must lie in ar1[m1....] and ar2[....m2]
	 * 4. else if m1>m2, then our median must lie in ar1[....m1] and ar2[m2...]
	 * repeat 1 to 4 till size of two subarrays become 2. after that compare the 4 elements 
	 * of 2 subarrays to get median out of them
	 */

	public static void main(String[] args) {
		int ar1[] = { 1, 12, 15, 26, 38 };
        int ar2[] = { 2, 13, 17, 30, 45 };
        int n1 = ar1.length;
        int n2 = ar2.length;
        if (n1 == 0) {
            System.out.println("Arrays are empty.");
        }
        else if (n1 == 1) {
            System.out.println((ar1[0] + ar2[0]) / 2);
        }
        else {
            System.out.println("Median is "+ getMedian(ar1, ar2, 0,
                      n1- 1, 0, n2 - 1));
        }
	}

	private static double getMedian(int[] arr1, int[] arr2, int startA, int endA, 
			int startB, int endB) {
		
		//base case if two subarrays size is 2, then find median in those 4 elements
		if(endA-startA==1)
			return (double)((Math.max(arr1[startA], arr2[startB]) + Math.min(arr1[endA], arr2[endB]))/2);
		
		//else get medians of the 2 subarrays
		double m1 = median(arr1, startA, endA);
		double m2 = median(arr2, startB, endB);
		
		if(m1==m2)
			return m1;
		else if(m1<m2) {
			return getMedian(arr1, arr2, (startA+endA+1)/2, endA, startB, (startB+endB+1)/2);
		}else {
			return getMedian(arr1, arr2, startA, (startA+endA+1)/2, (startB+endB+1)/2, endB);
		}
	}

	private static double median(int[] arr, int start, int end) {
		//caculate median based on number of elements in the array
		int n = end-start+1;
		if(n%2 == 0)
			return (double)((arr[start + n/2] + arr[start + n/2 -1]) / 2);
		else
			return arr[start + n/2];
	}

}
