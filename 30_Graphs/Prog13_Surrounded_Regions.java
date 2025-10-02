import java.util.Arrays;

public class Prog13_Surrounded_Regions {
    public void convert_O_to_X(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]visited=new boolean[n][m];
        // traverse first row and last row
        for(int col=0;col<m;col++){
                // first row
                if(grid[0][col]=='O' && !visited[0][col]){
                    dfs(0,col,visited,grid,n,m);
                }
                // last row
                if(grid[n-1][col]=='O' && !visited[n-1][col]){
                    dfs(n-1,col,visited,grid,n,m);
                }
        }
        // traverse first col and last col
        for(int row=0;row<n;row++){
                // first col
                if(grid[row][m-1]=='O' && !visited[row][m-1]){
                    dfs(row,m-1,visited,grid,n,m);
                }
                // last col
                if(grid[row][0]=='O' && !visited[row][0]){
                    dfs(row,0,visited,grid,n,m);
                }
        }
        // Convert O's which are unvisited to X
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='O' && !visited[i][j]){
                    grid[i][j]='X';
                }
            }
        }
    }
    private void dfs(int row,int col,boolean[][]visited,char[][]grid,int n,int m){
        visited[row][col]=true;
        int[] drow={0,-1,0,+1};
        int[] dcol={-1,0,+1,0};
        for(int i=0;i<4;i++){
            int nRow=row+drow[i];
            int nCol=col+dcol[i];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]=='O' 
            && !visited[nRow][nCol]){
                dfs(nRow,nCol,visited,grid,n,m);
            }
        }
    }
    public static void main(String[] args) {
        Prog13_Surrounded_Regions obj = new Prog13_Surrounded_Regions();
        char grid[][] = new char[][]{{'X','X','X','X'},{'X','O','X','X'},{'X','O','O','X'},{'X','O','X','X'},{'X','X','O','O'}};
        for(char[]arr:grid){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        obj.convert_O_to_X(grid);
        for(char[]arr:grid){
            System.out.println(Arrays.toString(arr));
        }
    }
}
// A group of O's overall must have X's on all 4 directions, then they can be converted into X's
// A group having O in any of the 4 boundaries of the grid will not be considered as top of it is empty
// A sub-group of that group will have O in the top not X, so that will also not be considered
// So, any group of O's connected to any of the 4 boundaries will never be converted into X's
// Algorithm that starts from the boundary and goes and connects all the O's
// DFS/BFS can be applied
// From the boundary O you go to the connected O's but since they are connected to the boundary O they will not converted into X
// So the O's which are not touched(not connected to boundary O) will be converted to X

// Algorithm:
// 1.Start from the boundary O's and mark them that they will not be converted
// 2.Convert the remaining O's to X

// Steps:
// 1. Take a boundary and find O, call dfs on it, mark it as visited
// Now dfs goes to its neighbour if its O dfs is called on it  
// And it is marked visited, Now dfs goes to its neighbour and does the same
// After this recursion calls return
// Finally dfs gets over
// Next consider the 2nd boundary, call dfs on O only if it is not visited
// Also call dfs on its neighbor if it is not visited
// Do traversals from all 4 boundaries
// Now the visited matrix has only those O's marked as true which cannot be converted to X's
// Convert those O's in grid to X's which have visited=false that means no boundary visited them