package algorithms.twoPointer;

public class TrappingRainWater {

	public static void main(String[] args) {
		int arr[] = {3, 0, 2, 0, 4};
		int N = arr.length;
        System.out.println(maxRainWaterByPrefix(arr, N));
        System.out.println(maxRainWaterByTwoPointer(arr, N));
	}

	
	private static int maxRainWaterByPrefix(int[] arr, int n) {
		//two arrays for storing left_max and right_max of each element
		int[] max_left = new int[n];
		int[] max_right = new int[n];
		int ans=0;
		
		max_left[0] = arr[0];
		max_right[n-1] = arr[n-1];
		//calculating left and right max
		for(int i=1, j=n-2; i<n && j>=0; i++, j--) {
			max_left[i] = Math.max(max_left[i-1], arr[i]);
			max_right[j] = Math.max(max_right[j+1], arr[j]);
		}
		
		//calculating water trapped at i= min(leftmax,rightmax)-arr[i]
		for(int i=0; i<n; i++) {
			ans+=(Math.min(max_left[i], max_right[i]) - arr[i]);
		}
		
		return ans;
	}
	
	
	private static int maxRainWaterByTwoPointer(int[] arr, int n) {
		int l=0, r=n-1, leftmax=-1, rightmax=-1;
		int ans=0;
		
		while(l<=r) {
			if(arr[l]<=arr[r]) {		//make sure we consider correct max element
				if(arr[l]>leftmax)		//if element is leftmax, it will not store water
					leftmax = arr[l];
				else
					ans+= (leftmax-arr[l]);		//add water stored at i
				l++;		//move left pointer
			}else {
				if(arr[r]>rightmax)		//if element is rightmax, it will not store water
					rightmax = arr[r];
				else
					ans+= (rightmax-arr[r]);		//add water stored at i
				r--;		//move right pointer
			}
		}
		
		return ans;
	}

}
