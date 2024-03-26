package ds.string;

public class CountAllPalindromicSubsequence {
	
	/*
	 * Solution: DP
	 * Base case : All single chars are palindrome so return 1
	 * Take 2 pointers left and right of string-
	 * 1. If left and right match then no. of pal subs = 1 + no. of subs for substr(left+1,right) + no. of subs for substr(left,right-1)
	 * 2. If not match then, no. of subs = no. of subs for substr(left+1,right) + no. of subs for substr(left,right-1) - no. of common subs in substr(left+1,right-1)
	 */

	public static void main(String[] args) {
		String str = "abca";
		System.out.println(countAllPalindromicSubsequences(str));
	}

	static int countAllPalindromicSubsequences(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0;j<n;j++)
				dp[i][j]= -1;
		
		return countPS(s, 0, n-1, dp);
	}
	
	static int countPS(String s, int i, int j, int[][] dp) {
		if(i>j)			//left pointer has moved past right pointer
			return 0;
		
		if(dp[i][j]!=-1)		//using dp table to avoid recalculation
			return dp[i][j];
		
		if(i==j)		//base case
			return 1;
		else if(s.charAt(i) == s.charAt(j))		//match case
			return dp[i][j] = countPS(s, i+1, j, dp)
								+ countPS(s, i, j-1, dp) + 1;
		else
			return dp[i][j] = countPS(s, i+1, j, dp)		//not matching case
								+ countPS(s, i, j-1, dp)
								- countPS(s, i+1, j-1, dp);
	}
}
