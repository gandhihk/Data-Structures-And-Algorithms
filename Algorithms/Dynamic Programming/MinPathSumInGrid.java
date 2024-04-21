package Algorithms.DP;

public class MinPathSumInGrid {
    public static void main(String[] args) {
        // Cost matrix for the grid
        int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

        // Calculate and print the minimum cost path from (0, 0) to (2, 2)
        System.out.println(minCost(cost, 3, 3));
    }

    static int minCost(int[][] cost, int M, int N){
        int[][] dp = new int[M][N];
        for(int i=0; i<M; i++)
            for(int j=0; j<N; j++)
                dp[i][j] = -1;
//        return minCostDP(0, 0, M-1, N-1, cost, dp);
        return minCostTabulationSpaceOptimized(M-1, N-1, cost);
    }

    static int minCostDP(int i, int j, int M, int N, int[][] cost, int[][] dp){
        if(i==M && j==N)
            return cost[M][N];
        if(i>M || j>N)
            return Integer.MAX_VALUE;

        if(dp[i][j] != -1)
            return dp[i][j];

        int down = minCostDP(i+1, j, M, N, cost, dp);
        int right = minCostDP(i, j+1, M, N, cost, dp);
        return dp[i][j] = cost[i][j] + Math.min(down, right);
    }

    static int minCostTabulation(int M, int N, int[][] cost, int[][] dp){
        for(int i=M; i>=0; i--){
            int down=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
            for(int j=N; j>=0; j--){
                if(i==M && j==N)
                    dp[i][j] = cost[i][j];
                else{
                    if(i<M)
                        down = dp[i+1][j];
                    if(j<N)
                        right = dp[i][j+1];
                    dp[i][j] = cost[i][j] + Math.min(down, right);
                }
            }
        }
        return dp[0][0];
    }

    static int minCostTabulationSpaceOptimized(int M, int N, int[][] cost){
        int[] next = new int[N+1];
        for(int i=M; i>=0; i--){
            int down=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
            for(int j=N; j>=0; j--){
                if(i==M && j==N)
                    next[j] = cost[i][j];
                else{
                    if(i<M)
                        down = next[j];
                    if(j<N)
                        right = next[j+1];
                    next[j] = cost[i][j] + Math.min(down, right);
                }
            }
        }
        return next[0];
    }
}
