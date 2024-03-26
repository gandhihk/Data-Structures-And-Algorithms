package ds.searching;

import java.util.ArrayList;
import java.util.List;

public class SortBySetBits {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		sortBySetBitCount(arr);
	}

	static void sortBySetBitCount(int[] arr) {
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i=1; i<32; i++) {
			List<Integer> list2 = new ArrayList<>();
			list.add(list2);
		}
		
		int bitCount = 0;
		for(int i=0; i<arr.length; i++) {
			bitCount = getBitCount(arr[i]);
			list.get(bitCount).add(arr[i]);
		}
		
		for(int i=31; i>=1; i--) {
			System.out.println(list.get(i));
		}
	}
	
	static int getBitCount(int n) {
		int count=0;
		while(n>0) {
			if((n&1) > 0)
				count++;
			n = n>>1;
		}
		return count;
	}
}
