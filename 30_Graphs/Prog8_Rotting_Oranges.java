import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int row;
    int col;
    int time;
    Pair(int _row,int _col,int _tm){
        row = _row;
        col = _col;
        time = _tm;
    }
}
public class Prog8_Rotting_Oranges{
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int cntFresh=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }

        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        int cntRottened=0;
        int tm=0;

        while(!q.isEmpty()){//Queue only stores rotten oranges
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.remove();
            tm = Math.max(tm,t);
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,t+1));
                    visited[nrow][ncol]=2;
                    cntRottened++;
                }
            }
        }

        if(cntFresh!=cntRottened){
            return -1;
        }else{
            return tm;
        }


    }
    public static void main(String[] args) {
        Prog8_Rotting_Oranges obj = new Prog8_Rotting_Oranges();
        int[][] grid = new int[][]{{0,1,2},{0,1,1},{2,1,1}};
        int minTime = obj.orangesRotting(grid);
        if(minTime == -1){
            System.out.println("Grid still has fresh oranges.");
        }else{
            System.out.println("Grid has all rotten oranges.");
            System.out.println(minTime+" secs was taken.");
        }
    }
}
// Algorithm: BFS
// Initially queue has the rotten oranges(their row,col,time)
// Remove first rotten orange, go to 4 directions
// Ignore visited oranges and rotten oranges and empty cells
// Add only the fresh oranges in the quick since they will become rotten because of this rotten orange
// Count the rottened oranges
// Check the countRottened with countFresh