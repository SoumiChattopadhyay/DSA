// https://leetcode.com/problems/flood-fill/description/
import java.util.Arrays;
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
public class Prog7_Flood_Fill {
     //sr means startingRow, sc means startingColumn
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        boolean[][] visited = new boolean[m+1][n+1];
        bfs(visited,image,sr,sc,color);
        return image;
    }
    private void bfs(boolean[][] visited,int[][] image, int sr, int sc, int color){
        int m=image.length;
        int n=image[0].length;
        int originalColor = image[sr][sc];
        visited[sr][sc]=true;
        image[sr][sc]=color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));

        while(!q.isEmpty()){
            Pair p=q.remove();
            int row = p.first;
            int col = p.second;
            //go in 4 directions
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,-1,0,1};
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n 
                && !visited[nrow][ncol] && image[nrow][ncol]==originalColor){
                    q.add(new Pair(nrow, ncol));
                    visited[nrow][ncol]=true;
                    image[nrow][ncol]=color;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        Prog7_Flood_Fill obj = new Prog7_Flood_Fill();
        int[][] ans = obj.floodFill(image,1,1,2);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }
}
