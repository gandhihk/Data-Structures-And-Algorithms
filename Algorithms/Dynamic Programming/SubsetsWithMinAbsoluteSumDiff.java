package Algorithms.DP;

public class SubsetsWithMinAbsoluteSumDiff {
    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 4, 2, 2, 1 };
        int n = arr.length;
        System.out.print("The minimum difference"
                + " between two sets is "
                + findMin(arr, n));
    }

    static int findMin(int[] arr, int N){
        int K=0;
        for(int i=0;i<N;i++)
            K += arr[i];
        boolean[][] dp = new boolean[N][K+1];
        getSubsetSum(arr, N, K, dp);

        int s1, s2, mini = Integer.MAX_VALUE;
        for(int i=0; i<=K; i++){
            if(dp[0][i]){
                s1 = i;
                s2 = K-s1;
                mini = Math.min(mini, Math.abs(s1-s2));
            }
        }
        return mini;
    }

    static void getSubsetSum(int[] arr, int N, int K, boolean[][] dp){
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

    }
}
