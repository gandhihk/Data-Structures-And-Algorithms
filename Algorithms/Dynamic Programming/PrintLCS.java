package Algorithms.DP;

import java.util.Arrays;

public class PrintLCS {
    public static void main(String[] args) {
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";

        // Function call
        System.out.println("LCS is " + longestCommonSubsequence(S1, S2));
    }

    static String longestCommonSubsequence(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int len = lcsTabulation(s1, s2, dp);
        char[] ans = new char[len];
        getLCSTabulation(s1, s2, dp, ans);
        return Arrays.toString(ans);
    }

    static void getLCSTabulation(String s1, String s2, int[][] dp, char[] ans){
        int i = 0, j = 0, N=dp.length-1, M=dp[0].length-1;
        int index = 0;
        while(i<N && j<M){
            if(s1.charAt(i)==s2.charAt(j)){
                ans[index++] = s1.charAt(i);
                i++; j++;
            }else if(dp[i+1][j]>dp[i][j+1])
                i++;
            else j++;
        }
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
