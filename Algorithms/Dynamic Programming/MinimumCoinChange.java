package Algorithms.DP;

public class MinimumCoinChange {
    public static void main(String args[])
    {
        int coins[] =  {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is "+ minCoins(coins, m, V) );
    }

    static int minCoins(int[] coins, int N, int target){
        int[][] dp = new int[N][target+1];
//        for(int i=0; i<N; i++)
//            for(int j=0; j<=target; j++)
//                dp[i][j] = -1;
//        return findMinCoins(0, coins, N, target, dp);
        return findMinCoinsTabulation(coins, N, target, dp);
    }

    static int findMinCoins(int i, int[] coins, int N, int target, int[][] dp){
        if(i == N-1){
            if(target%coins[i] == 0)
                return target/coins[i];
            else return Integer.MAX_VALUE;
        }

        if(dp[i][target] != -1)
            return dp[i][target];

        int take = Integer.MAX_VALUE;
        if(coins[i] <= target)
            take = 1 + findMinCoins(i, coins, N, target-coins[i], dp);
        int not_take = findMinCoins(i+1, coins, N, target, dp);

        return dp[i][target] = Math.min(take, not_take);
    }

    static int findMinCoinsTabulation(int[] coins, int N, int target, int[][] dp){
        for(int i=0; i<=target; i++) {
            if (i % coins[N - 1] == 0) {
                dp[N - 1][i] = i / coins[N - 1];
            } else dp[N - 1][i] = Integer.MAX_VALUE;
        }

        for(int i=N-2; i>=0; i--){
            for(int j=0; j<=target; j++){
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j)
                    take = 1 + dp[i][j-coins[i]];
                int not_take = dp[i+1][j];

                dp[i][j] = Math.min(take, not_take);
            }
        }
        return dp[0][target];
    }
}
