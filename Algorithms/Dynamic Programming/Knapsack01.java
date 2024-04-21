package Algorithms.DP;

public class Knapsack01 {
    public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));
    }

    static int knapSack(int W, int[] weight, int[] profit, int N){
        int[][] dp = new int[N][W+1];
//        for(int i=0; i<N; i++)
//            for(int j=0; j<=W; j++)
//                dp[i][j] = -1;
//        return findMaxProfit(0, W, weight, profit, N, dp);
        return findMaxProfitTabulation(W, weight, profit, N, dp);
//        return findMaxProfitTabulationSpaceOptimized(W, weight, profit, N);
    }

    static int findMaxProfit(int i, int W, int[] weight, int[] profit, int N, int[][] dp){
        if(i == N-1){
            if(weight[i] <= W)
                return profit[i];
            else return 0;
        }

        if(dp[i][W] != -1)
            return dp[i][W];

        int take=Integer.MIN_VALUE;
        if(weight[i] <= W)
            take = profit[i] + findMaxProfit(i+1, W-weight[i], weight, profit, N, dp);
        int not_take = findMaxProfit(i+1, W, weight, profit, N, dp);

        return dp[i][W] = Math.max(take, not_take);
    }

    static int findMaxProfitTabulation(int W, int[] weight, int[] profit, int N, int[][] dp){
        for(int i=weight[N-1]; i<=W; i++)
            dp[N-1][i] = profit[N-1];

        for(int i=N-2; i>=0; i--){
            for(int j=0; j<=W; j++){
                int take=Integer.MIN_VALUE;
                if(weight[i] <= W)
                    take = profit[i] + dp[i+1][W-weight[i]];
                int not_take = dp[i+1][W];

                dp[i][W] = Math.max(take, not_take);
            }
        }
        return dp[0][W];
    }

    static int findMaxProfitTabulationSpaceOptimized(int W, int[] weight, int[] profit, int N){
        int[] prev = new int[W+1];
        int[] curr = new int[W+1];
        for(int i=weight[0]; i<=W; i++)
            prev[i] = profit[N-1];

        for(int i=N-2; i>=0; i--){
            for(int j=0; j<=W; j++){
                int take=Integer.MIN_VALUE;
                if(weight[i] <= W)
                    take = profit[i] + prev[W-weight[i]];
                int not_take = prev[W];

                curr[W] = Math.max(take, not_take);
            }
            prev = curr;
        }
        return prev[W];
    }
}
