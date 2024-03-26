package ds.searching;

public class RotiPrataSPOJ {

	public static void main(String[] args) {
		int p = 10, cooks=4;
		int[] rankings = {1, 2, 3, 4};

		System.out.println(findMinTime(rankings, cooks, p));
	}

	static int findMinTime(int[] r, int cooks, int p) {
		int min=0, max=0;						//min/max time that can be taken to make p parathas
		max = r[cooks-1] * p * (p-1)/2;			//max will happen when max_ranking cook alone prepares all p parathas
		
		int ans=0;
		while(min<=max) {						
			int mid = min+(max-min)/2;
			
			if(findParathas(r, mid, p) >= p) {		//if total parathas made in mid time by all cooks > req parathas
				ans = mid;							//since this is the min time so far
				max = mid-1;						//minimize min time
			}else {
				min = mid+1;						//since req parathas cannot be made, increase min time
			}
		}
		return ans;
	}
	
	static int findParathas(int[] r, int maxTime, int p) {
		int total=0, time=0;
		for(int i=0; i<r.length; i++) {			//loop through all cooks
			time = r[i];						//cook i takes r[i] time for 1st paratha
			int j = 2;							//multiplier
			while(time<=maxTime) {				//if time is left
				total++;						//make paratha
				time += (j*r[i]);				//check time that will be taken to make next paratha
				j++;
			}
		}
		return total;
	}
}
