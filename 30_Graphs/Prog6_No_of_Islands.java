import java.util.LinkedList;
import java.util.Queue;

public class Prog6_No_of_Islands {
    class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
   public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][]visited = new boolean[m][n];
        int count=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(!visited[row][col] && grid[row][col] == '1'){
                    bfs(row,col,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int ro,int co,char[][]grid,boolean[][]visited){
        visited[ro][co]=true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,co));
        int m=grid.length;
        int n=grid[0].length;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            //we have to check for land in 4 directions
             int[] delrow = {-1, 0, 1, 0};
             int[] delcol = {0, -1, 0, 1};
             for(int i=0;i<4;i++){
                    int nrow = row+delrow[i];
                    int ncol = col+delcol[i];
                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]=='1' && !visited[nrow][ncol] ){
                        visited[nrow][ncol]=true;
                        q.add(new Pair(nrow,ncol));
                    }
            }
        }
    }
}
public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };//In prog5 this wud give no. of islands=1 but here its 3 becoz we are not considering diagonals
        Prog6_No_of_Islands obj = new Prog6_No_of_Islands();
        //In Java, when you have a non-static inner class (Solution inside Prog6_No_of_Islands), 
        // you must create it using the outer class instance, like this:
        Solution obj2 = obj.new Solution();
        System.out.println("No. of islands: "+obj2.numIslands(grid));
    }

}
