package ds.searching;

import java.util.Arrays;

public class MergeSortInPlace {

	public static void main(String[] args) {
		int[] nums = new int[] { 12, 11, 13, 5, 6, 7 };
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

	}
	
	static void mergeSort(int[] nums, int start, int end) {
		if(start<end) {
			int mid = start+(end-start)/2;
			
			mergeSort(nums, start, mid);
			mergeSort(nums, mid+1, end);
			
			mergeInPlace(nums, start, end);
		}
	}
	
	static void mergeInPlace(int[] nums, int start, int end) {
		int gap = start+(end-start)/2;
		
		for(; gap>0; gap=nextGap(gap)) {
			for(int i=start; i+gap<nums.length; i++) {
				if(nums[i] > nums[i+gap]) {
					swap(nums, i, i+gap);
				}
			}
		}
	}
	
	static int nextGap(int currGap) {
		if(currGap<=1)
			return 0;
		return (int)Math.ceil(currGap/2.0);
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp; 
	}

}
