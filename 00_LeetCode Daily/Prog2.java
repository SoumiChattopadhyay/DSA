import java.util.Arrays;
// This code only valid for n x n matrix (no. of cols = no. of rows)
//Memory: uses a small array per diagonal (O(n) space).
// Time: O(n^2 log n) because each diagonal is sorted individually.
public class Prog2{
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        // Top-right diagonals (increasing order)
        for(int col=1;col<n;col++){
            sortDiagonal(0,col,true,grid);
        }
        // Bottom-left diagonals (decreasing order)
        for(int row=0;row<n;row++){
            sortDiagonal(row,0,false,grid);
        }
        return grid;
    }
    //helper function
    private void sortDiagonal(int startRow, int startCol,boolean ascending,int[][]grid){
        int n=grid.length;
        int len = Math.min(n-startRow,n-startCol);
        int[] diag = new int[len];

        // Collect diagonal elements
        for(int k=0;k<len;k++){
            diag[k] = grid[startRow+k][startCol+k];
        }
        //Sort the diagonal array
        if(ascending){
            Arrays.sort(diag);
        }else{
            Arrays.sort(diag);
            // Reverse the array
            for(int i=0;i<len/2;i++){
                int temp=diag[i];
                diag[i]=diag[len-1-i];
                diag[len-1-i]=temp;
            }
        }
        //Modify grid matrix
        for(int k=0;k<len;k++){
            grid[startRow+k][startCol+k]=diag[k];
        }
    }
    public static void main(String[] args) {
        Prog2 obj = new Prog2();
        int[][] grid = {{1,7,3},{9,8,2},{4,5,6}};
        int[][] ans = obj.sortMatrix(grid);
        //print ans
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }
}