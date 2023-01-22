package ds.string;

import java.util.Arrays;

public class WordWrap {

	public static void main(String[] args) {
		int l[] = {3, 2, 2, 5};
		int M = 6;
		solveWordWrap(l, M, 4);
	}

	static void solveWordWrap(int[] l, int M, int n) {
		//For simplicity, 1 extra space is used in all below arrays
		//extras[i][j] will store extra spaces after words from i to j are put in 1 line
		int[][] extras = new int[n+1][n+1];
		
		//lc[i][j] will store cost of 1 line if words i to j are put in it
		int[][] lc = new int[n+1][n+1];
		
		//c[i] will store optimal cost from 1 to i word
		int[] c = new int[n+1];
		
		int[] p = new int[n+1];			//used to print the words
		
		for(int i=1; i<=n; i++) {
			extras[i][i] = M - l[i-1];
			for(int j=i+1; j<=n; j++)
				extras[i][j] = extras[i][j-1] - l[j-1] - 1;		//1 is for space between i & j 
		}
		
		// Calculate line cost corresponding to the above calculated extra spaces
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				if(extras[i][j]<0)
					lc[i][j] = Integer.MAX_VALUE;
				else if(j==n && extras[i][j]>=0)
					lc[i][j] = 0;
				else
					lc[i][j] = extras[i][j] * extras[i][j];  
			}
		}
		
		//calculate minimum cost
		c[0] = 0;			//just for simplicity
		for(int i=1; i<=n; i++) {
			c[i] = Integer.MAX_VALUE; 
			for(int j=1; j<=i; j++) {
				if(c[j-1]!=Integer.MAX_VALUE && lc[j][i]!=Integer.MAX_VALUE 
						&& c[j-1]+lc[j][i] < c[i]) {
					c[i] =  c[j-1]+lc[j][i-1];		//update the minimal cost till i word
					p[i] = j;						//add j word to the line starting with i word
				}
			}
		}
		System.out.println(Arrays.toString(p));
		printValue(p, n);
	}
	
	static void printValue(int[] p, int n) {
		if(n==1)
			System.out.println(p[n]+" "+n);
		else {
			printValue(p, p[n]-1);
			System.out.println(p[n]+" "+n);
		}
	}
}
