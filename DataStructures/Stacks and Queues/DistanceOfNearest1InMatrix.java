package ds.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearest1InMatrix {
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
        int[][] grid = { { 0, 1, 0, 0 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 } };
        grid = printDistance(grid, grid.length, grid[0].length);
        for (int[] row : grid) {
            for (int eachcal : row) {
                System.out.print(eachcal + " ");
            }
            System.out.println();
        }
    }

    static int[][] printDistance(int[][] grid, int n, int m){
        Queue<Ele> q = new LinkedList<>();
        //traverse grid to initialize all 0's to MAX and 1's to 0's and add them to queue
        for(int i=0; i< grid.length; i++)
            for(int j=0; j<grid[i].length; j++)
                if(grid[i][j]==1){
                    grid[i][j] = 0;
                    q.add(new Ele(i, j));
                }else{
                    grid[i][j] = Integer.MAX_VALUE;
                }

        Ele temp;
        while(!q.isEmpty()){
            temp = q.poll();

            int x1 = temp.x;
            int y1 = temp.y;

            //check upper cell
            if((x1-1>=0) && (grid[x1][y1] + 1 < grid[x1-1][y1])){
                grid[x1-1][y1] = grid[temp.x][temp.y] + 1;
                q.add(new Ele(x1-1, y1));
            }

            //check lower cell
            if((x1+1<n) && (grid[x1][y1] + 1 < grid[x1+1][y1])){
                grid[x1+1][y1] = grid[temp.x][temp.y] + 1;
                q.add(new Ele(x1+1, y1));
            }

            //check left cell
            if((y1-1>=0) && (grid[x1][y1] + 1 < grid[x1][y1-1])){
                grid[x1][y1-1] = grid[temp.x][temp.y] + 1;
                q.add(new Ele(x1, y1-1));
            }

            //check right cell
            if((y1+1<m) && (grid[x1][y1] + 1 < grid[x1][y1+1])){
                grid[x1][y1+1] = grid[temp.x][temp.y] + 1;
                q.add(new Ele(x1, y1+1));
            }
        }
        return grid;
    }
}
