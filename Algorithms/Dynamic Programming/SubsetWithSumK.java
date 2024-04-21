package Algorithms.DP;

public class SubsetWithSumK {
    public static void main(String args[])
    {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum))
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    static boolean isSubsetSum(int[] arr, int N, int K){
        int[][] dp = new int[N][K+1];
        for(int i=0; i<N; i++)
            for(int j=0; j<=K; j++)
                dp[i][j] = -1;
//        return checkSubsetSum(0, arr, N-1, K, dp);
        boolean[][] dp1 = new boolean[N][K+1];
        return checkSubsetSUmTabulation(arr, N, K, dp1);
    }

    static boolean checkSubsetSum(int i, int[] arr, int N, int K, int[][] dp){
        if(K==0)
            return true;
        if(i == N)
            return arr[N] == K;

        if(dp[i][K] != -1)
            return dp[i][K]==1;

        boolean take = false;
        if(arr[i] <= K)
            take = checkSubsetSum(i+1, arr, N, K-arr[i], dp);
        boolean not_take = checkSubsetSum(i+1, arr, N, K, dp);
        dp[i][K] = take || not_take ? 1 : 0;
        return take || not_take;
    }

    static boolean checkSubsetSUmTabulation(int[] arr, int N, int K, boolean[][] dp){
        for(int i=0; i<N; i++)
            dp[i][0] = true;
        if(arr[N-1]<=K)
            dp[N-1][arr[N-1]] = true;

        for(int i=N-2; i>=0; i--){
            for(int j=1; j<=K; j++){
                boolean take = false;
                if(arr[i] <= j)
                    take = dp[i+1][j-arr[i]];
                boolean not_take = dp[i+1][j];
                dp[i][j] = take || not_take;
            }
        }
        return dp[0][K];
    }
}
