import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
public class Prog5_No_of_Islands {
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
    //try dfs traversal

    //bfs traversal
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
            //we have to check for land in 8 directions
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow = row+delrow;
                    int ncol = col+delcol;
                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]=='1' && !visited[nrow][ncol] ){
                        visited[nrow][ncol]=true;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][]grid = {
            {'0','1','1','0'},
            {'0','1','1','0'},
            {'0','0','1','0'},
            {'0','0','0','0'},
            {'1','1','0','1'}
        };
        Prog5_No_of_Islands obj = new Prog5_No_of_Islands();
        System.out.println("No. of islands: "+obj.numIslands(grid));
    }
}
