package Algorithms.DP;

public class LongestCommonSubstring {
    public static void main(String[] args)
    {
        String X = "abcdxyz";
        String Y = "xyzabcd";

        int m = X.length();
        int n = Y.length();

        System.out.println(
                "Length of Longest Common Substring is "
                        + longestCommonSubstringSpaceOptimized(X, Y, m, n));
    }

    static int longestCommonSubstring(String s1, String s2, int N, int M){
        int[][] dp = new int[N+1][M+1];
        for(int i=0; i<=N; i++)
            dp[i][M] = 0;
        for(int j=0; j<=M; j++)
            dp[N][j] = 0;

        int ans = Integer.MIN_VALUE;
        for(int i=N-1; i>=0; i--){
            for(int j=M-1; j>=0; j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
                else
                    dp[i][j] = 0;
            }
        }
        return ans;
    }
    static int longestCommonSubstringSpaceOptimized(String s1, String s2, int N, int M){
        int[] prev = new int[M+1];
        int[] curr = new int[M+1];
        int ans = Integer.MIN_VALUE;
        for(int i=N-1; i>=0; i--){
            for(int j=M-1; j>=0; j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    curr[j] = prev[j+1] + 1;
                    ans = Math.max(ans, curr[j]);
                }
                else
                    curr[j] = 0;
            }
            prev = curr.clone();
        }
        return ans;
    }

}
