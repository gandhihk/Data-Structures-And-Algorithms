package Algorithms.DP;

public class LCS {
    public static void main(String[] args) {
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";

        // Function call
        System.out.println("Length of LCS is " + longestCommonSubsequence(S1, S2));
    }

    static int longestCommonSubsequence(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
//        for(int i=0; i<s1.length()+1; i++)
//            for(int j=0; j<s2.length()+1; j++)
//                dp[i][j] = -1;
//        return lcs(1, 1, s1, s2, s1.length(), s2.length(), dp);
        return lcsTabulation(s1, s2, dp);
    }

    static int lcs(int i, int j, String s1, String s2, int N, int M, int[][] dp){
        if(i==N+1 || j==M+1)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s1.charAt(i-1)==s2.charAt(j-1))
            return dp[i][j] = 1 + lcs(i+1, j+1, s1, s2, N, M, dp);

        return dp[i][j] = Math.max(lcs(i+1, j, s1, s2, N, M, dp), lcs(i, j+1, s1, s2, N, M, dp));
    }

    static int lcsTabulation(String s1, String s2, int[][] dp){
        int N = s1.length(), M = s2.length();

        for(int i=0; i<=N; i++)
            dp[i][M] = 0;
        for(int j=0; j<=M; j++)
            dp[N][j] = 0;

        for(int i=N-1; i>=0; i--){
            for(int j=M-1; j>=0; j--){
                if(s1.charAt(i)==s2.charAt(j))
                    dp[i][j] = 1 + dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
