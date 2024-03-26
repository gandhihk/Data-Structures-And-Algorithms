package ds.string;

import java.util.Arrays;

public class WildcardPatternMatching {

	public static void main(String[] args) {
		String pattern = "*?c*d";
		String string = "abcd";
		
		int[][] dp = new int[pattern.length()][string.length()];
		for(int i=0; i<dp.length; i++)
			Arrays.fill(dp[i], -1);
		System.out.println(match(pattern, string, pattern.length()-1, string.length()-1, dp));

	}
	
	static int match(String pattern, String string, int n1, int n2, int[][] dp) {
		if(n1==-1 && n2==-1)		//if both strings ended
			return 1;
		
		if(n2==-1) {			//if string has ended but pattern hasn't
			for(int k=0; k<=n1; k++) {		//check if there is any char other than *
				if(pattern.charAt(k)!='*')
					return 0;
			}
			return 1;			//if not then return 1
		}
		
		if(n1==-1)				//if pattern has ended
			return 0;
		
		if(dp[n1][n2]!=-1)		
			// if we have already calculated the whether pattern and string 
			//of lengths n1, n2 are matching or not then return that value
			return dp[n1][n2];
		
		//else we need to find whether string and pattern of this length matches or not
		if(pattern.charAt(n1)=='?' || pattern.charAt(n1)==string.charAt(n2))		//1st case
			return dp[n1][n2] = match(pattern, string, n1-1, n2-1, dp);
		
		if(pattern.charAt(n1)=='*') {		//2nd case
			int v1 = match(pattern, string, n1, n2-1, dp);		//take string char
			int v2 = match(pattern, string, n1-1, n2, dp);		//don't tale string char
			return dp[n1][n2] = v1|v2; 
		}
		return dp[n1][n2] = 0;			//3rd case
	}

}
