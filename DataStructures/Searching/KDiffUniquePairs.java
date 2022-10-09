package ds.searching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class KDiffUniquePairs {

	/*
	 * [3,1,4,1,5], k = 2
	 * [1,2,3,4,5], k = 1
	 * [1,3,1,5,4], k = 0
	 */
	
	public static void main(String[] args) {
		int arr[] = { 6,3,5,7,2,3,3,8,2,4 };
        int k = 2;
        System.out.println("Count of pairs with given diff is "+ countPairsWithDiffK(arr, k));

	}
	
	static int countPairsWithDiffK(int[] arr, int k) {
		int count=0, count1=0;
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		if(k!=0) {
			for(int i=0; i<arr.length; i++) {
				
				if(!set.contains(arr[i])) {
					if(set.contains(arr[i]+k))
						count++;
					if(set.contains(arr[i]-k))
						count++;
				}
				set.add(arr[i]);
			}
		}else {
			for(int i=0; i<arr.length; i++) {
				if(map.containsKey(arr[i]))
					map.put(arr[i], map.get(arr[i])+1);
				else
					map.put(arr[i], 1);
			}
			for(Entry<Integer, Integer> e: map.entrySet())
				if(e.getValue()>1)
					count1++;
		}
		
		return k==0?count1:count;
	}

}
