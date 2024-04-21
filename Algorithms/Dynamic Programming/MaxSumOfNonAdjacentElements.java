package Algorithms.DP;

public class MaxSumOfNonAdjacentElements {
    public static void main(String[] args)
    {
        int hval[] = { 6, 7, 1, 3, 8, 2, 4 };
        int n = hval.length;
        int[] dp = {-1, -1, -1, -1, -1, -1, -1};
        System.out.println("Maximum loot possible : "
                + maxLoot(hval, 0, n-1, dp));
        System.out.println("Maximum loot possible : "
                + maxLootTabulation(hval, n-1, dp));
    }

    static int maxLoot(int[] arr, int i, int N, int[] dp){
        //base case
        if(i == N)                      //if reached last index, that means last-1 index was not picked, and there is only 1 option to pick this
            return arr[i];

        if(i > N)               //if goes beyond last, return 0
            return 0;

        if(dp[i]!=-1)
            return dp[i];

        int pick = arr[i] + maxLoot(arr, i+2, N, dp);       //pick this and next non-adj index
        int not_pick = maxLoot(arr, i+1, N, dp);            //don't pick this, pick adj index

        return dp[i] = Math.max(pick, not_pick);
    }

    static int maxLootTabulation(int[] arr, int N, int[] dp){
        dp[N] = arr[N];
        int pick=0, not_pick;
        for(int i=N-1; i>=0; i--){
            if(i+2 <=N)
                pick = arr[i] + dp[i+2];
            else pick = arr[i];
            not_pick = dp[i+1];
            dp[i] = Math.max(pick, not_pick);
        }
        return dp[0];
    }
}
