package ds.string;

public class LongestPalindromicSubString {
	
	/*
	 * Given a string, find the longest substring which is a palindrome. 
	 * Solution 1: Using dp table. intuition: a string will be palindrome if its inner substring is palindrome and outer 2 elements are same
	 * 1. create dp table of nxn size. store whether substring(i,j) is palindrome at dp[i,j] by 2 loops
	 * 2. iterate over all substrings by increasing diff between start and end
	 * 	For each diff, iterate over string to check all possible substrings
	 * 		a. if diff==0, then store dp[i,j]=1; since all strings of 1 len are palindrome
	 * 		b. else if diff==1, then check if both chars are same, based on that update dp[i,j]
	 * 		c. else check palindrom based on intuition condition
	 * 		d. if this substring is palindrome(dp[i,j]>0), then update maxlength string
	 * TC=> O(N^2), SC=> O(N^2)
	 * 
	 * Solution 2: Using even odd method for each character
	 * Traverse the string from 2nd char. consider each char as middle element.
	 * 		1. point 2 pointers to prev and this char i.e. even len palindrome check
	 * 		2. if they are same, then move pointers out by 1 till both are same. also update maxlength
	 * 		3. point 2 pointers to prev and next char i.e. odd len palindrome check
	 * 		4. if they are same, then move pointers out by 1 till both are same. also update maxlength
	 * TC=> O(N^2), SC=> O(1)
	 */

	public static void main(String[] args) {
		String string = "forgeeksskeegfor";
		System.out.println(getLongestPalindromeByDP(string));
		System.out.println(getLongestPalindromeByEvenOdd("a"));
	}
	
	static String getLongestPalindromeByDP(String s) {
		String ans = "";
		int maxLength = 0;
		int n = s.length();
		
		int dp[][] = new int[n][n];
		int diff=0;
		for(; diff<n; diff++) {
			for(int i=0, j=diff; j<n; i++,j++) {
				if(diff==0) {
					dp[i][j] = 1; 
				}else if(diff==1) {
					dp[i][j] = s.charAt(i)==s.charAt(j) ? 2 : 0; 
				}else {			//check if this substring is palindromic
					if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>0)
						dp[i][j] = dp[i+1][j-1]+2;		//incrementing length of substring by 2 
				}
				
				if(dp[i][j]>0) {		//if this substring is palindromic
					if(j-i+1 > maxLength) {		//check if len of this substring is max
						maxLength = j-i+1;		
						ans = s.substring(i, i+maxLength);		//update ans
					}
				}
			}
		}
		
		return ans;
	}

	static String getLongestPalindromeByEvenOdd(String s) {
		int n = s.length();
		int l,h;
		int start=0, maxLen=1;
		String ans = s.substring(start, start+maxLen);
		
		for(int i=1; i<n; i++) {		//traverse from 2nd char
			l=i-1; h=i;			//even len palindrome check
			while(l>=0 && h<n && s.charAt(l)==s.charAt(h)) {		//if they are same, then keep checking outwards
				if(h-l+1 > maxLen) {			//update maxLen
					maxLen = h-l+1;
					start = l;
				}
				h++;			//move pointers out
				l--;
			}
			
			l=i-1; h=i+1;		//odd len palindrome check
			while(l>=0 && h<n && s.charAt(l)==s.charAt(h)) {		//if they are same, then keep checking outwards
				if(h-l+1 > maxLen) {			//update maxLen
					maxLen = h-l+1;
					start = l;
				}
				h++;			//move pointers out
				l--;
			}
			
			ans = s.substring(start, start+maxLen);
		}
		
		return ans;
	}
}
