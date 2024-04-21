package Algorithms.DP;

public class UniquePathsInMatrix {
    public static void main(String[] args){
        System.out.println(numberOfPaths(3, 3));
    }

    static int numberOfPaths(int M, int N){
        int[][] dp = new int[M][N];
        for(int i=0; i<M; i++)
            for(int j=0; j<N; j++)
                dp[i][j] = -1;
        return numberOfPathsDP(0, 0, M-1, N-1, dp);
    }

    static int numberOfPathsDP(int i, int j, int M, int N, int[][] dp){
        //base case for coming from last row or last column, no. of unique paths will be 1
        if((i==M && j==N-1) || (i==M-1 && j==N))
            return 1;
        if(i>M || j>N)          //edge case if path goes out of matrix
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int down = numberOfPathsDP(i+1, j, M, N, dp);
        int right = numberOfPathsDP(i, j+1, M, N, dp);
        return dp[i][j] = down+right;
    }
}
