import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Pair {
    int row;
    int col;
    Pair(int r, int c) {
        row = r;
        col = c;
    }
}
//SC=O(NxM)+O(NxM)=O(NxM){for queue,visited matrix}
//TC=O(NxMx4)+O(NxM)=O(NxM) Worst Case:matrix has all 1's(all lands){queue is gonna run over all the matrix, each time 4 directions travelled}{another NxM for finding count(no. of lands)}
public class Prog14_No_of_Enclaves {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]visited=new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int col=0;col<m;col++){
            if(grid[0][col]==1){
                q.add(new Pair(0,col));
                visited[0][col]=true;
            }
            if(grid[n-1][col]==1){
                q.add(new Pair(n-1,col));
                visited[n-1][col]=true;
            }
        }
        for(int row=0;row<n;row++){
            if(grid[row][m-1]==1){
                q.add(new Pair(row,m-1));
                visited[row][m-1]=true;
            }
            if(grid[row][0]==1){
                q.add(new Pair(row,0));
                visited[row][0]=true;
            }
        }
        // instead of 4 loops we can also do this
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         // first row,last col,
        //         if(i==0||i==n-1||j==0||j==m-1){
        //             if(grid[i][j]==1){
        //                 q.add(new Pair(i,j));
        //                 visited[i][j]=true;
        //             }
        //         }
        //     }
        // }
        bfs(visited, grid, n, m,q);
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    // Multi-Source BFS - we start from more than 1 starting point
    public void bfs(boolean[][]visited,int[][]grid,int n,int m,Queue<Pair>q){
        int[] drow={0,-1,0,1};
        int[] dcol={-1,0,1,0};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
            for(int i=0;i<4;i++){
                int nRow=row+drow[i];
                int nCol=col+dcol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 
                && !visited[nRow][nCol]){
                    q.add(new Pair(nRow,nCol));
                    visited[nRow][nCol]=true;
                }
            }
        }
        
    }
    public static void main(String[] args) {
        Prog14_No_of_Enclaves obj = new Prog14_No_of_Enclaves();
        int[][]grid=new int[][]{{0,0,0,1,1},{0,0,1,1,0},{0,1,0,0,0},{0,1,1,0,0},{0,0,0,1,1}};
        for(int[]arr:grid){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("No. of enclaves = "+obj.numEnclaves(grid));
    }
}
// Count no. of lands from which you cannot go out of the boundary
// So something that is connected to the boundary will never be your answer
// From the boundary 1's whichever 1's are connected won't be in answer

// So intuition:
// Find Boundary 1's and mark all the 1's connected to them
// The remaining unvisited 1's would be in answer

// Algorithm: DFS or BFS


// Never do this!!!
// In your BFS, you mark cells as visited too late:
// visited[row][col] = true;   // happens when removing from queue
// q.remove();
// That means:
// You only mark a cell visited when you pull it out of the queue.
// Until then, other neighbors think it’s still unvisited, so they can add it to the queue again.
// Result: The same cell might get added to the queue multiple times → extra work.

// That’s two queue operations per iteration:
// peek()
// remove()
// The faster way is to just use:
// int[] cell = q.poll();  // removes + returns
// int row = cell[0], col = cell[1];

// Queue<int[]> q = new LinkedList<>();
// then do q.add(new int[]{nRow,nCol});

//Remaining Reasons for the Gap
// boolean[][] vs int[][]
// In Java, a boolean[][] is actually stored as an array of arrays of bytes (not true bits).
// Accessing it can be slightly less efficient than int[][], because:
// boolean loads/stores are not as optimized on the JVM.
// Extra bounds and conversion checks happen under the hood.
// The “9 ms” solution used int[][] visited, which JVM handles faster.

// more efficient solution
// class Solution {
//      public int numEnclaves(int[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;
//         int[][]visited=new int[n][m];
//         Queue<int[]> q = new LinkedList<>();
//         for(int col=0;col<m;col++){
//             if(grid[0][col]==1 && visited[0][col]==0){
//                 q.offer(new int[]{0,col});
//                 visited[0][col]=1;
//             }
//             if(grid[n-1][col]==1 && visited[n-1][col]==0){
//                 q.offer(new int[]{n-1,col});
//                 visited[n-1][col]=1;
//             }
//         }
//         for(int row=0;row<n;row++){
//             if(grid[row][m-1]==1 && visited[row][m-1]==0){
//                 q.offer(new int[]{row,m-1});
//                 visited[row][m-1]=1;
//             }
//             if(grid[row][0]==1 && visited[row][0]==0){
//                 q.offer(new int[]{row,0});
//                 visited[row][0]=1;
//             }
//         }
//         bfs(visited, grid, n, m,q);
//         int count=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(visited[i][j]==0 && grid[i][j]==1){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
//     public void bfs(int[][]visited,int[][]grid,int n,int m,Queue<int[]>q){
//         int[] drow={0,-1,0,1};
//         int[] dcol={-1,0,1,0};
//         int[] cell;
//         int row,col,nRow,nCol;
//         while(!q.isEmpty()){
//             cell=q.poll();
//             row=cell[0];
//             col=cell[1];
//             for(int i=0;i<4;i++){
//                 nRow=row+drow[i];
//                 nCol=col+dcol[i];
//                 if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 
//                 && visited[nRow][nCol]==0){
//                     q.offer(new int[]{nRow,nCol});
//                     visited[nRow][nCol]=1;
//                 }
//             }
//         }
        
//     }
// }