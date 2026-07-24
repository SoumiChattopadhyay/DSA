// A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end.
// Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
import java.util.Arrays;
public class Prog3 {
    public int[][] sortDiagonals(int[][] grid) {
        int m=grid.length;//no. of rows
        int n=grid[0].length;//no. of cols
        // Top-right diagonals
        for(int col=1;col<n;col++){
            sortDiagonal(0,col,grid);
        }
        // Bottom-left diagonals
        for(int row=0;row<m;row++){
            sortDiagonal(row,0,grid);
        }
        return grid;
    }
    //helper function
    private void sortDiagonal(int startRow, int startCol,int[][]grid){
        int m=grid.length;
        int n=grid[0].length;
        int len = Math.min(m-startRow,n-startCol);
        int[] diag = new int[len];

        // Collect diagonal elements
        for(int k=0;k<len;k++){
            diag[k] = grid[startRow+k][startCol+k];
        }
        
        //Sort the diagonal array
        Arrays.sort(diag);

        //Modify grid matrix
        for(int k=0;k<len;k++){
            grid[startRow+k][startCol+k]=diag[k];
        }
    }
    public static void main(String[] args) {
         Prog3 obj = new Prog3();
        int[][] grid = {{1,7,3},{9,8,2},{4,5,6}};
        int[][] ans = obj.sortDiagonals(grid);
        //print ans
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }
}
