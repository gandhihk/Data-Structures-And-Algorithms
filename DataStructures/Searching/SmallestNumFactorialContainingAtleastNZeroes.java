package ds.searching;

public class SmallestNumFactorialContainingAtleastNZeroes {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(findSmallestNum(n));

	}
	
	static int findSmallestNum(int n) {
		int low=0, high=n*5;				//max value whose factorial can contain n trailing zeroes is 5*n
		
		// If n equal to 1, return 5.
        if (n==1)
            return 5;
        
        while(low<high) {
        	int mid = (low+high)/2;
        	
        	if(countTrailingZeroes(mid) >= n)
        		high = mid;
        	else
        		low = mid+1;
        }
        return low;
	}
	
	static int countTrailingZeroes(int p) {
		int count=0;
		for(int i=1; i<=p; i++) {
			int temp=i;					//take this number
			while(temp%5 == 0) {		//calculate no. of factors of 5 of this number temp
				count++;
				temp/=5;
			}
		}
		return count;					//return total count of all numbers till p
	}

}
