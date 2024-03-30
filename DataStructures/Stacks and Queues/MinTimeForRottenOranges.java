package ds.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MinTimeForRottenOranges {
    public final static int R = 3;
    public final static int C = 5;

    static class Ele {
        int x = 0;
        int y = 0;
        Ele(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)
    {
        int[][] arr = { { 2, 1, 0, 2, 1 },
                { 1, 0, 1, 2, 1 },
                { 1, 0, 0, 2, 1 } };
        int ans = rotOranges(arr);
        if (ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println(
                    "Time required for all oranges to rot => "
                            + ans);
    }

    static int rotOranges(int[][] arr){
        Queue<Ele> q = new LinkedList<>();
        Ele temp;
        int time=0;

        // Store all the cells having rotten orange in first time frame
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 2)
                    q.add(new Ele(i, j));

        while(!q.isEmpty()){
            // This flag is used to determine whether even a single fresh orange gets rotten due to rotten
            // oranges in the current time frame so we can increase the count of the required time.
            boolean flag = false;

            int size = q.size();

            for(int i=0; i<size; i++){
                temp = q.poll();

                // check down cell
                if(isValid(temp.x+1, temp.y) && arr[temp.x+1][temp.y]==1){
                    if(!flag){
                        flag = true;
                        time++;
                    }
                    arr[temp.x+1][temp.y] = 2;
                    q.add(new Ele(temp.x+1, temp.y));
                }

                // check up cell
                if(isValid(temp.x-1, temp.y) && arr[temp.x-1][temp.y]==1){
                    if(!flag){
                        flag = true;
                        time++;
                    }
                    arr[temp.x-1][temp.y] = 2;
                    q.add(new Ele(temp.x-1, temp.y));
                }

                // check right cell
                if(isValid(temp.x, temp.y+1) && arr[temp.x][temp.y+1]==1){
                    if(!flag){
                        flag = true;
                        time++;
                    }
                    arr[temp.x][temp.y+1] = 2;
                    q.add(new Ele(temp.x, temp.y+1));
                }

                // check left cell
                if(isValid(temp.x, temp.y-1) && arr[temp.x][temp.y-1]==1){
                    if(!flag){
                        flag = true;
                        time++;
                    }
                    arr[temp.x][temp.y-1] = 2;
                    q.add(new Ele(temp.x, temp.y-1));
                }
            }
        }

        // Return -1 if all arranges could not rot,
        // otherwise ans
        return (checkAll(arr)) ? -1 : time;
    }

    // function to check whether a cell is valid / invalid
    static boolean isValid(int i, int j)
    {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    // Function to check whether there is still a fresh orange remaining
    static boolean checkAll(int[][] arr)
    {
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }

}
