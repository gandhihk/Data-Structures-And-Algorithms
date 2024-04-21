package Algorithms.DP;

public class UnboundedKnapsack {
    public static void main(String[] args)
    {
        int val[] = { 10, 30, 20 };
        int wt[] = { 5, 10, 15 };
        int n = val.length;
        int W = 100;

        System.out.println(knapSack(W, wt, val, n));
    }

    static int knapSack(int W, int[] weight, int[] profit, int N){
        int[][] dp = new int[N][W+1];
        for(int i=0; i<N; i++)
            for(int j=0; j<=W; j++)
                dp[i][j] = -1;
//        return unboundedKnapsack(0, W, weight, profit, N, dp);
        return unboundedKnapsackTabulationSpaceOptimized(W, weight, profit, N);
    }

    static int unboundedKnapsack(int i, int W, int[] weight, int[] profit, int N, int[][] dp){
        if(i == N-1){
            if(weight[i] <= W){
                return (W/weight[i])*profit[i];
            }else return 0;
        }

        if(dp[i][W] != -1)
            return dp[i][W];

        int take = Integer.MIN_VALUE;
        if(weight[i] <= W)
            take = profit[i] + unboundedKnapsack(i, (int) (W-weight[i]), weight, profit, N, dp);
        int not_take = unboundedKnapsack(i+1, W, weight, profit, N, dp);

        return dp[i][W] = Math.max(take, not_take);
    }

    static int unboundedKnapsackTabulationSpaceOptimized(int W, int[] weight, int[] profit, int N){
        int[] prev = new int[W+1];

        for(int w=0; w<=W; w++){
            prev[w] = (w/weight[N-1])*profit[N-1];
        }

        for(int i=N-2; i>=0; i--){
            for(int w=0; w<=W; w++){
                int take = Integer.MIN_VALUE;
                if(weight[i] <= w)
                    take = profit[i] + prev[(int) (w-weight[i])];
                int not_take = prev[w];

                prev[w] = Math.max(take, not_take);
            }
        }
        return prev[W];
    }
}
