package Algorithms.DP;

public class LongestPalindromicSubsequence {
    public static void main(String[] args)
    {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.printf("The length of the LPS is %d",
                lps(seq, 0, n - 1));
        System.out.printf("The length of the LPS is %d",
                lpsUsingLCS(seq));
    }

    static int lps(String s, int i, int j){
        if(i == j)          // Base Case 1: If there is only 1 character
            return 1;

        if(i+1==j && s.charAt(i)==s.charAt(j))              // Base Case 2: If there are only 2 characters and both are same
            return 2;

        if(s.charAt(i) == s.charAt(j))
            return 2 + lps(s, i+1, j-1);

        return Math.max(lps(s, i+1, j), lps(s, i, j-1));
    }

    static int lpsUsingLCS(String s){
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()+1][s.length()+1];
        return LCS.lcsTabulation(s, s2, dp);
    }
}
