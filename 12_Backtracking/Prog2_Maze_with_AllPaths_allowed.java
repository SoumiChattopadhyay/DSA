import java.util.Arrays;

public class Prog2_Maze_with_AllPaths_allowed {
    public static void main(String[] args) {
        boolean[][] visited={
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        printPaths(visited,"", 3, 0, 0);
        int[][]path=new int[visited.length][visited[0].length];
        draw_and_printPaths(path,1,visited, "", 3, 0, 0);
    }
    // Maze with all paths allowed
    static void printPaths(boolean[][]visited,String p,int n,int r,int c){
         if(r==n-1 && c==n-1){
            System.out.println(p);
            return;
        }
        if(r>n-1 || c>n-1 || r<0 || c<0 || !visited[r][c]){
            return;
        }
        visited[r][c]=false;
        
        printPaths(visited,p+'D',n, r+1, c);
        printPaths(visited,p+'R',n, r, c+1);
        printPaths(visited,p+'U',n, r-1, c);
        printPaths(visited,p+'L',n, r, c-1);
        printPaths(visited,p+'d',n,r+1,c+1);
        // 5 Recursive calls for a particular function at a particular level, are for one single path
        // So make the position of that particular function that you made false as true
        visited[r][c]=true;
    }
    // Any change made via function calls on the array object will be reflected in the original array after returning
    // So is not true for normal variables like step
     static void draw_and_printPaths(int[][]path,int step,boolean[][]visited,String p,int n,int r,int c){
         if(r==n-1 && c==n-1){
            path[r][c]=step;
            for(int[] el:path){
                System.out.println(Arrays.toString(el));
            }
            System.out.print(p);
            System.out.println();
            System.out.println();
            return;
        }
        if(r>n-1 || c>n-1 || r<0 || c<0 || !visited[r][c]){
            return;
        }
        visited[r][c]=false;
        path[r][c]=step;
        draw_and_printPaths(path,step+1,visited,p+'D',n, r+1, c);
        draw_and_printPaths(path,step+1,visited,p+'R',n, r, c+1);
        draw_and_printPaths(path,step+1,visited,p+'U',n, r-1, c);
        draw_and_printPaths(path,step+1,visited,p+'L',n, r, c-1);
        draw_and_printPaths(path,step+1,visited,p+'d',n,r+1,c+1);
        // 5 Recursive calls for a particular function at a particular level, are for one single path
        // So make the position of that particular function that you made false as true
        visited[r][c]=true;
        path[r][c]=0;
    }
}
