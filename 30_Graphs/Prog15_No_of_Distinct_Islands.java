// Given a binary 2D matrix grid of size n * m. You have to find the number of distinct 
// islands where a group of connected 1s (horizontally or vertically) forms an island.
// Two islands are considered to be distinct if and only if one island is not equal to 
// another (not rotated or reflected).
import java.util.ArrayList;
import java.util.HashSet;
public class Prog15_No_of_Distinct_Islands {
    public int countDistinctIslands(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]visited=new boolean[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        // here we have to check for every cell
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    ArrayList<String>ls=new ArrayList<>();
                    dfs(i,j,ls,visited,grid,i,j);
                    set.add(ls);
                }
            }
        }
        return set.size();
    }
    private String toString(int r,int c){
        return Integer.toString(r)+","+Integer.toString(c);
    }
    private void dfs(int row,int col,ArrayList<String>ls,boolean[][]visited,int[][]grid,
    int row0,int col0){
        visited[row][col]=true;
        ls.add(toString(row-row0,col-col0));
        int n=grid.length;
        int m=grid[0].length;
        int[] drow={0,-1,0,+1};
        int[] dcol={-1,0,+1,0};
        for(int i=0;i<4;i++){
            int nRow=row+drow[i];
            int nCol=col+dcol[i];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1
            && !visited[nRow][nCol]){
                dfs(nRow,nCol,ls,visited,grid,row0,col0);
            }
        }
    }
    public static void main(String[] args) {
        Prog15_No_of_Distinct_Islands obj = new Prog15_No_of_Distinct_Islands();
        int[][]grid = new int[][]{
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}
        };
        System.out.println("No. of distinct islands = "+obj.countDistinctIslands(grid));
        int[][]grid2 = new int[][]{
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 0, 1, 0}
        };
        System.out.println("No. of distinct islands = "+obj.countDistinctIslands(grid2));

    }
}
