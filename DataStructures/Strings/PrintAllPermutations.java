package ds.string;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {

	/*
	 * Print all permutations of given array or string
	 * Solution: Recursion backtracking
	 * 1. base case if all indexes are swapped
	 * 2. run loop from curr index to end of string
	 * 		swap curr index with next index
	 * 		mark curr index as already swapped, recur for next index
	 * 		reswap for backtracking
	 * TC=> O(n! * n)
	 * SC=> O(1)
	 */
	
	public static void main(String[] args) {
		String string = "ABC";
//		printPermutationsOfString(0, string.length()-1, string);
		
		List<List<Integer>> ans = new ArrayList<>();
		int[] nums = {1,2,3};
		printAllPermutationsOfArray(0, nums, ans);
	}

	static void printPermutationsOfString(int l, int r, String str) {
		if(l==r) {		//base case if all indexes are swapepd
			System.out.println(str);
		}
		
		for(int i=l; i<=r; i++) {		//loop through all indexes to swap
			str = swap(str, l, i);		//swap current index l with index i
			printPermutationsOfString(l+1, r, str);		//mark l as already swapped, recur to get next permutation
			str = swap(str, l, i);		//reswap to backtrack
		}
	}
	
	static String swap(String a, int i, int j) {
		char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
	}
	
	static void swap(int i, int j, int[] arr) {
		int t = arr[i];
		arr[i]= arr[j];
		arr[j]= t; 
	}
	
	static void printAllPermutationsOfArray(int index, int[] nums, List<List<Integer>> ans) {
		if(index == nums.length) {
			List<Integer> ds = new ArrayList<>();
			for(int i=0; i<nums.length; i++)		//copy all elements of nums to ds
				ds.add(nums[i]);
			ans.add(new ArrayList<>(ds));
			return;
		}
		
		for(int j=index; j<nums.length; j++) {
			swap(j, index, nums);
			printAllPermutationsOfArray(index+1, nums, ans);
			swap(j, index, nums);
		}
	}
}
