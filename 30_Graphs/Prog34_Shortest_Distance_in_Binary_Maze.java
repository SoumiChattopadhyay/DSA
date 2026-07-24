// Shortest Distance in a Binary Maze
// Given a n * m matrix grid where each element can either be 0 or 1. 
// You need to find the shortest distance between a given source cell to a destination cell. 
// The path can only be created out of a cell if its value is 1. 
// If the path is not possible between source cell and destination cell, then return -1.
// Note : You can move into an adjacent cell if that adjacent cell is filled with element 1. 
// Two cells are adjacent if they share a side. In other words, you can move 
// in one of the four directions, Up, Down, Left and Right. 
// The source and destination cell are based on the zero based indexing. The destination cell should be 1.
// DP won't work as the value on any cell is path-dependent, so it won't work. 
// It works in the maze which has two direction movements in the right and bottom, 
// and the future cells would never be visited. Think about it by taking some examples. 
import java.util.LinkedList;
import java.util.Queue;

public class Prog34_Shortest_Distance_in_Binary_Maze {
    // What u did
    // U checked for destination when node came out of the queue
    // So u didnt need any edge case
    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int srcRow=source[0];
        int destRow=destination[0];
        int srcCol=source[1];
        int destCol=destination[1];
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,srcRow,srcCol});
        
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                dist[i][j]=(int)1e9;
        dist[srcRow][srcCol]=0;

        int drow[] = new int[]{0,-1,0,+1};
        int dcol[] = new int[]{-1,0,+1,0};
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int distance = arr[0];
            int row = arr[1];
            int col = arr[2];
            if(row==destRow && col==destCol){
                return distance;
            }
            for(int i=0;i<4;i++){
                int nRow = row+drow[i];
                int nCol = col+dcol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m
                && grid[nRow][nCol]==1 && distance+1<dist[nRow][nCol]){
                        dist[nRow][nCol]=distance+1;
                        q.add(new int[]{distance+1,nRow,nCol});
                }
            }
        }
        return -1;
    }
    // What Striver did
    // He checked for destination when a neighbor was formed
    // So the edge case must be given separately otherwise no neighbor formed for it so -1 would be returned which is wrong answer
    public static int shortestPath2(int[][] grid, int[] source, int[] destination) {
        int srcRow=source[0];
        int destRow=destination[0];
        int srcCol=source[1];
        int destCol=destination[1];
        int n = grid.length;
        int m = grid[0].length;
        
        // Edge Case
        if(srcRow==destRow && srcCol==destCol){
            return 0;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,srcRow,srcCol});
        
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                dist[i][j]=(int)1e9;
        dist[srcRow][srcCol]=0;

        int drow[] = new int[]{0,-1,0,+1};
        int dcol[] = new int[]{-1,0,+1,0};
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int distance = arr[0];
            int row = arr[1];
            int col = arr[2];

            for(int i=0;i<4;i++){
                int nRow = row+drow[i];
                int nCol = col+dcol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m
                && grid[nRow][nCol]==1 && distance+1<dist[nRow][nCol]){
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
        int grid[][] = new int[][] {{1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 0, 1}};
        int[] source = new int[]{0, 0};
        int[] destination = new int[] {3, 4};
        System.out.println("Shortest distance = "+shortestPath(grid, source, destination));
    }
}
