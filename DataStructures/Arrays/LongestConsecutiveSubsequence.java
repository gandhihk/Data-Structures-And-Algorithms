package ds.arrays;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
	
	/*
	 * 1. add all elements to set
	 * 2. for each element
	 * 	a. check if arr[i] is starting of LCS i.e. if set.contains(arr[i]-1)
	 * 	b. if contains then ignore this element. else consider this as starting of LCS
	 * 	c. increment element and check if all its subsequent elements are present
	 * 	d. calc length of this subsequence and update max len if max_len<curr_len
	 */

	public static void main(String[] args) {
		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int n = arr.length;
        System.out.println(
            "Longest consecutive subsequence is "
            + findLongestConseqSubseq(arr, n));
	}
	
	static int findLongestConseqSubseq(int[] arr, int n){
		HashSet<Integer> set = new HashSet<>();
		int len=0;
		
		for(int i=0; i<n; ++i) {
			set.add(arr[i]);
		}
		
		for(int i=0; i<n; ++i) {
			// if current element is the starting element of a sequence
			if(!set.contains(arr[i]-1)) {
				// Then check for next elements in the sequence
				int j = arr[i];
				while(set.contains(j))
					j++;
				
				// update max length if this length is more
				if(len < j-arr[i])
					len = j-arr[i];
			}
		}
		
		return len;
	}

}
