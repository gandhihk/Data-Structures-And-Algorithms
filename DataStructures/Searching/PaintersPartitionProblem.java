package ds.searching;

public class PaintersPartitionProblem {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		 
        // Calculate size of array.
        int n = arr.length;
        int k = 3;
        System.out.println(partition(arr, n, k));

	}
	
	static int partition(int[] arr, int n, int k) {
		int min=Integer.MIN_VALUE, max=0;			//min and max no. of boards that can be allotted to a painter
		for(int i=0; i<n; i++) {
			if(arr[i]>min)							//min=max of all boards
				min = arr[i];
			max+=arr[i];							//max=sum of all boards
		}
		
		int ans=0;
		while(min<=max) {
			int mid = min+(max-min)/2;
			
			if(findRequiredPainters(arr, mid) <= k) {		//if true, we can add more painters and minimize maxBoards
				ans = mid;									//store this mid as this is the possible min we have so far
				max = mid-1;
			}else {
				min = mid+1;								//if false, then need to increase the max boards i.e. go to right half
			}
		}
		return ans;
	}

	static int findRequiredPainters(int[] arr, int maxBoards) {
		int reqPainters=1, total=0;
		for(int i=0; i<arr.length; i++) {
			total+=arr[i];						//get the total boards to be allotted
			if(total > maxBoards) {				//if total board units>maxBoards
				reqPainters++;					//then we need to allot this board i to next painter so reqPainters++
				total = arr[i];					//since this board is allotted to new painter, start calculating total boards that can be allotted to this new painter
			}
		}
		return reqPainters;
	}
}
