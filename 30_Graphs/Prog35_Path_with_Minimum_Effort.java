// You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of 
// size rows x columns, where heights[row][col] represents the height of cell (row, col). 
// You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). 
// You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
// A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

import java.util.PriorityQueue;
class Tuple{
    int difference;
    int row;
    int col;
    Tuple(int difference,int row, int col){
        this.row=row;
        this.col=col;
        this.difference=difference;
    }
}
public class Prog35_Path_with_Minimum_Effort {
    public static int minimumEffortPath(int[][] heights) {
        
        int diff[][] = new int[heights.length][heights[0].length];
        for(int i=0;i<diff.length;i++)
            for(int j=0;j<diff[0].length;j++)
                diff[i][j]=Integer.MAX_VALUE;
        diff[0][0]=0;
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->{return x.difference-y.difference;});
        pq.add(new Tuple(0, 0, 0));
        
        int drow[] = new int[]{0,-1,0,+1};
        int dcol[] = new int[]{-1,0,+1,0};
        while(pq.size()!=0){//dont write !pq.size()==0 thats invalid !pq.isEmpty() is ok as it returns boolean value
            Tuple t = pq.poll();
            int currDiff = t.difference;
            int row = t.row;
            int col = t.col;
            if(row==heights.length-1 && col==heights[0].length-1){
                return currDiff;
            }
            for(int i=0;i<4;i++){
                int nRow=row+drow[i];
                int nCol=col+dcol[i];
                if(nRow>=0 && nRow<heights.length && nCol>=0 && nCol<heights[0].length){
                    int newDiff=Math.abs(heights[nRow][nCol]-heights[row][col]);
                    int effort=Math.max(newDiff,currDiff);
                    if(effort<diff[nRow][nCol]){
                        pq.add(new Tuple(effort, nRow, nCol));
                        diff[nRow][nCol]=effort;
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] heights = new int[][] {
            {1,2,2},
            {3,8,2},
            {5,3,5}};
        System.out.println("Minimum Effort = "+minimumEffortPath(heights));
    }
}
