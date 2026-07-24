// Shortest Path/Distance in Binary Maze
// Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

// All the visited cells of the path are 0.
// All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
// The length of a clear path is the number of visited cells of this path

import java.util.LinkedList;
import java.util.Queue;

public class Prog34_Shortest_Path_in_Binary_Maze_Diagonals_Included {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int srcRow=0,srcCol=0,destRow=n-1,destCol=n-1;
        // Edge Cases
        //1.If start or end blocked 
        if(grid[srcRow][srcCol]==1 || grid[destRow][destCol]==1){
            return -1;
        }
        //2.Single-cell grid. Ex: grid =[[0]]
        if(n==1 && grid[0][0]==0){
            return 1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,srcRow,srcCol});
        
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dist[i][j]=(int)1e9;
        dist[srcRow][srcCol]=1;

        int drow[] = new int[]{0,-1,-1,-1,0,+1,+1,+1};
        int dcol[] = new int[]{-1,-1,0,+1,+1,+1,0,-1};
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int distance = arr[0];
            int row = arr[1];
            int col = arr[2];

            for(int i=0;i<8;i++){
                int nRow = row+drow[i];
                int nCol = col+dcol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n
                && grid[nRow][nCol]==0 && distance+1<dist[nRow][nCol]){
                        dist[nRow][nCol]=distance+1;
                        if(nRow==destRow && nCol==destCol){
                            return distance+1;
                        }
                        q.add(new int[]{distance+1,nRow,nCol});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int grid[][] = new int[][] {
            {0,0,0},
            {1,1,0},
            {1,1,0}};
        System.out.println("Shortest distance = "+shortestPathBinaryMatrix(grid));
    }
}
