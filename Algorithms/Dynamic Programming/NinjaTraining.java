package Algorithms.DP;

public class NinjaTraining {
    public static void main(String args[]) {
        // Define the points for each activity on each day
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        int n = points.length; // Get the number of days
        System.out.println(ninjaTraining(n, points)); // Calculate and print the maximum points
    }

    static int ninjaTraining(int N, int[][] arr){
        int[][] dp = new int[N][4];
        for(int i=0; i<N; i++)
            for(int j=0; j<4; j++)
                dp[i][j] = -1;
//        return findMaxPoints(0, N, arr, dp, 3);
        return findMaxPointsTabulation(N, arr, dp);
    }

    static int findMaxPoints(int day, int N, int[][] arr, int[][]dp, int prev){
        //here prev denotes the task no. done on prev day
        //dp[i][j] denotes the points we would get till day i if task j was done on prev day

        int maxi = 0;
        //base case
        if(day==N-1){
            for(int task=0; task<3; task++){            //check tasks except the task that was done prev day. if there was no prev day, prev=3 so all tasks will be compared
                if(task != prev)
                    maxi = Math.max(maxi, arr[N-1][task]);
            }
            return maxi;
        }

        if(dp[day][prev] != -1)         //if already calculated
            return dp[day][prev];

        for(int task=0; task<3; task++){                //recur for each task by picking 1 at a time and passing it as prev task in the argument
            if(task != prev)
                maxi = Math.max(maxi, arr[day][task] + findMaxPoints(day+1, N, arr, dp, task));
        }
        return dp[day][prev] = maxi;
    }

    static int findMaxPointsTabulation(int N, int[][] arr, int[][]dp){
        dp[N-1][0] = Math.max(arr[N-1][1], arr[N-1][2]);
        dp[N-1][1] = Math.max(arr[N-1][0], arr[N-1][2]);
        dp[N-1][2] = Math.max(arr[N-1][1], arr[N-1][0]);
        dp[N-1][3] = Math.max(arr[N-1][0], Math.max(arr[N-1][1], arr[N-1][2]));

        for(int day=N-2; day>=0; day--){            //for each day starting from 2nd last day
            for(int prev=0; prev<4; prev++){           // consider each task to be picked on prev day
                int maxi = 0;
                for(int task=0; task<3; task++){             //compare all tasks except prev
                    if(task != prev)
                        maxi = Math.max(maxi, arr[day][task] + dp[day+1][task]);        //instead of calling recursively, get prev day's points from dp
                }
                dp[day][prev] = maxi;
            }
        }
        return dp[0][3];
    }
}
