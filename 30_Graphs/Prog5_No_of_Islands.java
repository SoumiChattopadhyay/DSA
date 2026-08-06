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
    public int find_No_of_Islands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][]visited = new boolean[m][n];
        int count=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(!visited[row][col] && grid[row][col] == '1'){
                    // bfs(row,col,grid,visited);
                    dfs(row,col,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    //try dfs traversal
    public void dfs(int row, int col, char[][] grid, boolean[][] visited){
        
        visited[row][col]=true;
        
        int m=grid.length;
        int n=grid[0].length;

        for(int delRow=-1;delRow<=1;delRow++){
            for(int delCol=-1;delCol<=1;delCol++){
                int neighRow = row+delRow;
                int neighCol = col+delCol;
                if(neighRow>=0 && neighRow<m && neighCol>=0 && neighCol<n && !visited[neighRow][neighCol] && grid[neighRow][neighCol]=='1'){
                    dfs(neighRow, neighCol, grid, visited);
                }
            }
        }
    }

    //bfs traversal
    public void bfs(int ro, int co, char[][] grid, boolean[][] visited){
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,co));
        visited[ro][co]=true;
        
        int m=grid.length;
        int n=grid[0].length;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            //we have to check for land in 8 directions
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int neighrow = row+delrow;
                    int neighcol = col+delcol;
                    if(neighrow>=0 && neighrow<m && neighcol>=0 && neighcol<n && grid[neighrow][neighcol]=='1' && !visited[neighrow][neighcol] ){
                        visited[neighrow][neighcol]=true;
                        q.add(new Pair(neighrow,neighcol));
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
        System.out.println("No. of islands: " + obj.find_No_of_Islands(grid));
    }
}

/*
Why not form adjacency list and do simple bfs?

The given grid is not an adjacency matrix. Here, rows and columns represent cells, where '1' means land 
and '0' means water. It tells us what is present at each location, not which vertices are connected.

To form an adjacency list, we would first have to treat every cell as a vertex, give each cell a unique 
vertex number (or represent it using (row, col)), and then connect every land cell with its neighbouring 
land cells. This makes the solution more complex and uses extra memory.

Instead, we directly check all 4 (or 8) neighbouring cells of the current cell during BFS/DFS. Then we 
visit the neighbours of those neighbours, and so on. Since the neighbours can be found directly from the 
grid, building an adjacency list is unnecessary.

*/