package Algorithms.DP;

public class MinInsertionsToMakeStringPalindrome {
    public static void main(String args[])
    {
        String str= "geeks";
        int[][] dp = new int[str.length()][str.length()];
        for(int i=0; i<str.length(); i++)
            for(int j=0; j<str.length(); j++)
                dp[i][j] = -1;
        System.out.println(findMinInsertions(str,
                0, str.length()-1, dp));
    }

    static int findMinInsertions(String s, int i, int j, int[][] dp){
        if(i > j)           //base case 1: if pointers cross each other
            return Integer.MAX_VALUE;
        if(i == j)          //base case 2: if only 1 char is left, then no insertions required
            return 0;
        if(i+1==j)          //base case 3: if only 2 chars left, then if they are same then no insertions required, else 1 insertion required to make palindrome
            return s.charAt(i)==s.charAt(j) ? 0 : 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s.charAt(i)==s.charAt(j))        //if both chars same then insertions are required for rest of the string
            return dp[i][j] = findMinInsertions(s, i+1, j-1, dp);
        else                                //else this char will require 1 insertion and check min insertions required for rest of string by picking left and right char once each
            return dp[i][j] = 1+ Math.min(findMinInsertions(s, i+1, j, dp), findMinInsertions(s, i, j-1, dp));
    }
}
