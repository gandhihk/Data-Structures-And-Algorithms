package ds.searching;

public class DoubleHelixSPOJ {

	public static void main(String[] args) {
		int[] a = {-5, 100, 1000, 1005};
		int[] b = {-12, 1000, 1001};
		
		System.out.println(findPath(a, b));
	}
	
	static int findPath(int[] a, int[] b) {
		int n=a.length, m=b.length;
		
		int s1=0, s2=0;					//sums till next bridge
		int i=0, j=0;					//pointers in the two sequences
		int ans=0;
		
		while(i<n && j<m) {				//while both pointers are within range
			if(a[i] < b[j])				//pointer of a is smaller, so move it to next element and add it sum1
				s1 += a[i++];
			else if(b[j] < a[i])		//pointer of b is smaller, so move it to next element and add to sum2
				s2 += b[j++];
			else {						//bridge is found
				ans += Math.max(s1, s2) + a[i];			//add max sum and bridge val to ans
				s1 = 0; s2 = 0;				//reset sums
				i++; j++;					//move both pointers
			}
		}
		
		while(i<n) {					//check if any elements in a after last bridge
			s1 += a[i++];
		}
		while(j<m) {					//check if any elements in b after last bridge
			s2 += b[j++];
		}
		ans += Math.max(s1, s2);		//add max sum
		
		return ans;
	}

}
