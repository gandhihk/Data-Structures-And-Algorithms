package ds.searching;

import java.util.Arrays;

public class AggressiveCows {

	public static void main(String[] args) {
		int n = 5, cows = 3;
        int a[]={1,2,8,4,9};
        
        System.out.println(findMaxMinimumDistanceLinSearch(a, n, cows));
        System.out.println(findMaxMinimumDistanceBinSearch(a, n, cows));
	}

	static int findMaxMinimumDistanceLinSearch(int[] a, int n, int cows) {
		Arrays.sort(a);						//sort the input stalls
		
		int maxD = a[n-1] - a[0];			//max distance possible between 2 cows
		boolean possible = false;
		int ans=1;
		for(int i=1; i<=maxD; i++) {		//run loop starting with dist=1
			possible = isPossible(a, i, cows);		//check if its possible to arrange cows with this min dist
			if(possible) {					//if possible, check if this is max
				ans = Math.max(ans, i);
			}
		}
		return ans;
	}
	
	static int findMaxMinimumDistanceBinSearch(int[] a, int n, int cows) {
		Arrays.sort(a);						//first sort the input stalls
		
		int low=1, high = a[n-1]-a[0];		//set the lower/upper bounds of search space
		while(low<=high) {				
			int mid = low+(high-low)/2;		
					
			if(isPossible(a, mid, cows))	//check if its possible to arrange cows with min dist=mid
				low = mid+1;				//if possible, then check with min dist=mid+1
			else
				high = mid-1;				//else check with min dist=mid-1
		}
		return high;
	}
	
	static boolean isPossible(int[] a, int dist, int cows) {
		int k = a[0];
		cows--;
		for(int i=1; i<a.length; i++) {
			if(k+dist <= a[i]) {
				cows--;
				if(cows == 0)
					return true;
				k = a[i];
			}
		}
		return false;
	}
}
