package Algorithms.DP;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args){
        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(solveTabulation(height,dp, n-1));
    }

    static int solve(int i, int[] height, int[] dp, int n){
        if(i == n-1)
            return Math.abs(height[n]-height[n-1]);
        if(i == n-2)
            return Math.min(Math.abs(height[n]-height[n-1])+Math.abs(height[n-1]-height[n-2]),
                    Math.abs(height[n]-height[n-2]));

        if(dp[i]!=-1)
            return dp[i];

        int one_step = solve(i+1, height, dp, n) + Math.abs(height[i+1]-height[i]);
        int two_step = solve(i+2, height, dp, n) + Math.abs(height[i+2]-height[i]);

        return dp[i] = Math.min(one_step, two_step);
    }

    static int solveTabulation(int[] height, int[] dp, int n){
        dp[n-1] = Math.abs(height[n]-height[n-1]);
        dp[n-2] = Math.min(Math.abs(height[n]-height[n-1])+Math.abs(height[n-1]-height[n-2]),
                Math.abs(height[n]-height[n-2]));
        int one_step, two_step=0;
        for(int i=n-3; i>=0; i--){
            one_step = dp[i+1] + Math.abs(height[i+1]-height[i]);
            two_step = dp[i+2] + Math.abs(height[i+2]-height[i]);
            dp[i] = Math.min(one_step, two_step);
        }
        return dp[0];
    }
}
