package ds.string;

public class PrintAllSubsequences {
	/*
	 * Generate all possible subsequences
	 * Solution 1: Bit manipulation
	 * 1. Run a loop from 0 to 2^n-1(because no. of subsequences is 2^n-1)
	 * 2. Initialize empty string. for each i from 0 to 2^n-1,
	 * 		a. Run loop j from 0 to n to pick/not pick char at j
	 * 			char is chosen based on whether bit is set at j in number i i.e. if(i & (1<<j))
	 * 			if bit is set, then add this char to string
	 * 		b. print this string
	 * TC=> O(n * 2^n), SC=> O(1)
	 * 
	 * Solution 2: Recursion backtracking
	 * Intuition - For generating subsequences we either pick a char or don't pick
	 * 1. First initialize ans with empty string and call generating method
	 * 2. base condn check - if(ans is empty) then print ans
	 * 3. pick this char, add to ans, and recur for next index
	 * 4. don't pick this char, and recur for next index
	 */

	public static void main(String[] args) {
		String s = "abcd";
		printAllSubsequencesByBitManipulation(s);
		printAllSubsequencesByRecursion(s, "");
	}

	static void printAllSubsequencesByBitManipulation(String s) {
		int n = s.length();
		String str="";
		for(int i=0; i< (1<<n); i++) {		//this decides number of subsequences
			str = "";
			for(int j=0; j<n; j++) {		//this decides number of chars in this subsequence
				if((i & (1<<j)) != 0)		//this decides whether to pick char at this pos
					str += s.charAt(j);
			}
			System.out.println(str);
		}
	}
	
	static void printAllSubsequencesByRecursion(String s, String ans) {
		if(s.length() == 0) {				//ifr s is empty, then print ans & backtrack
			System.out.println(ans);
			return;
		}
		//pick this char(1st pos) & recur for next substrings starting from next index
		printAllSubsequencesByRecursion(s.substring(1), ans+s.charAt(0));
		
		//don't pick this char(1st pos) & recur for next substrings starting from next index
		printAllSubsequencesByRecursion(s.substring(1), ans);
	}
}
