package ds.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Job{
	char id;
	int deadline;
	int profit;
	public Job(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}

public class JobSequencing {

	public static void main(String[] args) {
		ArrayList<Job> arr = new ArrayList<Job>();
        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
 
        System.out.println(
            "Following is maximum profit sequence of jobs");
        scheduleGreedy(arr);
        
        System.out.println(
                "\nFollowing is maximum profit sequence of jobs");
        scheduleMaxHeap(arr);
	}
	
	static void scheduleGreedy(List<Job> arr) {
		Collections.sort(arr, (a,b) -> b.profit-a.profit);
		
		boolean[] slots = new boolean[arr.size()];
		List<Job> ans = new ArrayList<>();
		int n=arr.size();
		
		for(int i=0; i<n; i++) {
			for(int j= Math.min(n, arr.get(i).deadline)-1; j>=0; j--) {
				if(slots[j]==false) {
					ans.add(arr.get(i));
					slots[j]=true;
					break;
				}
			}
		}
		
		for(Job j: ans)
			System.out.print(j.id+" ");
	}
	
	static void scheduleMaxHeap(List<Job> arr) {
		Collections.sort(arr, (a,b) -> a.deadline-b.deadline);
		
		int n = arr.size();
		List<Job> ans = new ArrayList<>();
		PriorityQueue<Job> maxHeap = new PriorityQueue<>((a,b) -> b.profit-a.profit);
		
		for(int i=n-1; i>=0; i--) {
			int slot_availble;
			if(i==0) {
				slot_availble = arr.get(i).deadline;
			}else {
				slot_availble = arr.get(i).deadline - arr.get(i-1).deadline;
			}
			
			maxHeap.add(arr.get(i));
			
			while(slot_availble>0 && maxHeap.size()>0) {
				ans.add(maxHeap.remove());
				slot_availble--;
			}
		}
		
		Collections.sort(ans, (a,b) -> a.deadline-b.deadline);
		
		for(Job j: ans)
			System.out.print(j.id+" ");
	}

}
