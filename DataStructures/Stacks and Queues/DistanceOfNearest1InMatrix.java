package ds.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearest1InMatrix {
    static class Ele {
        int x = 0;
        int y = 0;
        int dist=0;
        Ele(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
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
        Queue<Ele> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];

        //traverse grid to initialize add all 1's to queue and mark them as visited
        for(int i=0; i< grid.length; i++)
            for(int j=0; j<grid[i].length; j++)
                if(grid[i][j]==1){
                    visited[i][j] = true;
                    queue.add(new Ele(i, j, 0));            //initial nodes having 1's will have 0 distance
                }

        //adjacent rows and columns
        int[] delRow = {-1, 0 , +1, 0};
        int[] delCol = {0, +1, 0, -1};

        Ele temp;
        while(!queue.isEmpty()){
            temp = queue.poll();
            dist[temp.x][temp.y] = temp.dist;               //set this node's distance in dist[][] array

            for(int i=0; i<4; i++){
                int nrow = temp.x+delRow[i];
                int ncol = temp.y+delCol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
                    && !visited[nrow][ncol]){
                    visited[nrow][ncol] = true;
                    queue.add(new Ele(nrow, ncol, temp.dist+1));
                }
            }
        }
        return dist;
    }
}
