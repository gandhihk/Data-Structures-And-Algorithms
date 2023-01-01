package ds.string;

public class EditDistance {
	/*
	 * Solution 1: Recursive
	 * 1. Start with last chars of both strings. If they are same, ignore lsat char, recur for remaining
	 * 2. If not same, then get minimum of all 3 possible operations
	 * TC => O(3^m)
	 * 
	 * Solution 2: Using DP
	 * Keep table of M*N, where dp[i][j] = min(3 operations i.e. dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
	 * TC => O(m*n), SC => O(m*n)
	 * 
	 * Solution 3: Using DP with only 2 rows
	 * Use same logic as above solution, only use 2 rows, because only previous row is required to fill this row
	 * TC => O(m*n), SC => O(k)
	 */

	public static void main(String[] args) {
		String s1 = "sunday";
		String s2 = "saturday";
		System.out.println("Minimum edit distance: "+findEditDistance3(s1, s2, s1.length(), s2.length()));
	}
	
	static int getMin(int x, int y, int z) {
		if(x<=y && x<=z)
			return x;
		else if(y<=x && y<=z)
			return y;
		else return z;
	}

	static int findEditDistance(String s1, String s2, int m, int n) {
		// If first string is empty, then insert all chars of second string into first
		if(m==0)
			return n;
		
		// If second string is empty, then remove all characters of first string
		if(n==0)
			return m;
		
		// If last characters are same, then ignore them and get count for remaining string
		if(s1.charAt(m) == s2.charAt(n))
			return findEditDistance(s1, s2, m-1, n-1);
		
		// If last characters are not same, there are three operations possible
        // recursively compute minimum cost for all three and take min
		return 1 + getMin(findEditDistance(s1, s2, m, n-1),			//insert
						findEditDistance(s1, s2, m-1, n),		//delete
						findEditDistance(s1, s2, m-1, n-1));	//replace
	}
	
	static int findEditDistance2(String s1, String s2, int m, int n) {
		//same logic is used as above method, only difference is here dp table is used
		//to avoid recalculations
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0)
					dp[i][j] = j;
				else if(j==0)
					dp[i][j] = i;
				else if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1 + getMin(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]); 
			}
		}
		return dp[m][n];
	}
	
	static int findEditDistance3(String s1, String s2, int m, int n) {
		int dp[][] = new int[2][n+1];
		
		for(int j=0; j<=n; j++)
			dp[0][j] = j;
		
		for(int i=1; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(j==0)
					dp[i%2][j] = i;
				else if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i%2][j] = dp[(i-1)%2][j-1];
				else
					dp[i%2][j] = 1 + getMin(dp[i%2][j-1], 
											dp[(i-1)%2][j], 
											dp[(i-1)%2][j-1]);
			}
		}
		return dp[m%2][n];
	}
	
}
