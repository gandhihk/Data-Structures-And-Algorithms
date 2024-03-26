package ds.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
	
	static class Interval{
		int start, end;
		Interval(int s, int e){
			start = s; end = e;
		}
	}

	public static void main(String[] args) {
		Interval arr[] = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        mergeIntervals(arr);
	}

	static void mergeIntervals(Interval[] arr) {
		//first sort the intervals based on start
		Arrays.sort(arr, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start-b.start;
			}
		});
		
		//consider first interval as current interval
		Interval currInterval = arr[0];
		List<Interval> output = new ArrayList<>();
		
		//compare each interval with current interval
		for(int i=1; i<arr.length; i++) {
			if(currInterval.end>=arr[i].start)		//if overlaps, then update currInterval's end
				currInterval.end = Math.max(currInterval.end, arr[i].end);
			else {						//else add currInterval to output list and set this interval as currInterval
				output.add(currInterval);
				currInterval = arr[i];
			}
		}
		output.add(currInterval);			//finally add currInterval to output list
		
		System.out.print("The Merged Intervals are: ");
        for (Interval i: output) {
            System.out.print("[" + i.start + ","
                             + i.end + "]");
        }
	}
}
