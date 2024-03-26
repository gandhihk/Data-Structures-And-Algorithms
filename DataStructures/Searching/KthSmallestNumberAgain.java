package ds.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval{
	int start;
	int end;
	public Interval(int s, int e) {
		start =s; end = e;
	}
	@Override
	public String toString() {
		return this.start+","+this.end;
	}
}

public class KthSmallestNumberAgain {

	public static void main(String[] args) {
		List<Interval> arr = new ArrayList<>();
		arr.add(new Interval(1, 4));
		arr.add(new Interval(6, 8));
		
		int[] q = {2, 6, 10};
		List<Interval> merged = new ArrayList<>();
		merged = sortAndMerge(arr);
		System.out.println(merged);
		for(int i=0; i<q.length; i++)
			System.out.println(findKthSmallest(merged, q[i]));
	}
	
	static List<Interval> sortAndMerge(List<Interval> arr){
		List<Interval> merged = new ArrayList<>();
		
		Collections.sort(arr, new SortByStart());
		
		merged.add(arr.get(0));
		for(int i=1; i<arr.size(); i++) {
			Interval prev = merged.get(merged.size()-1);
			Interval curr = arr.get(i);
			
			if(curr.start<=prev.end && curr.start>=prev.start && curr.end>prev.end) {
				merged.get(merged.size()-1).end = curr.end;
			}else {
				merged.add(curr);
			}
		}
		return merged;
	}

	static int findKthSmallest(List<Interval> merged, int k) {
		for(Interval i: merged) {
			if(k <= (i.end-i.start+1)) {
				return i.start+k-1;
			}else {
				k = k - (i.end-i.start+1);
			}
		}
		if(k!=0)
			return -1;
		return 0;
	}
}

class SortByStart implements Comparator<Interval>{

	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.start-o2.start;
	}
}
