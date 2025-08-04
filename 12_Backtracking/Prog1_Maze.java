import java.util.ArrayList;

public class Prog1_Maze{
    public static void main(String[] args) {
        System.out.println(countPaths(3,0,0));
        printPaths("", 0, 0, 3);
        System.out.println(returnPaths("", 0, 0, 3));
        printPaths2("", 3, 0, 0);
        System.out.println(returnPaths2("", 0, 0, 3));
        boolean[][] boards={
            {true,true,true},
            {true,false,true},
            {true,true,true}
        };
        printPaths_Obstacles(boards,"", 0, 0);
    }
    // Given an n x n maze(2D matrix) count no. of paths to reach from (0,0) to (n-1,n-1)
    // You are allowed to go only Right(R) by inc. col by 1 or Down(D) by inc. row by 1
    static int countPaths(int n, int r, int c){
        if(r==n-1 || c==n-1){
            return 1;
        }
        int c1 = countPaths(n, r, c+1);
        int c2 = countPaths(n, r+1, c);
        return c1+c2;
    }
    // Print all the paths from (0,0) to (n-1,n-1)
    static void printPaths(String p,int r, int c,int n){//p:path
        if(r==n-1 && c==n-1){
            System.out.println(p);
            return;
        }
        if(r>n-1 || c>n-1){
            return;
        }
        printPaths(p+'R',r,c+1,n);
        printPaths(p+'D',r+1,c,n);
    }
    // Store the paths in an ArrayList and return it
     static ArrayList<String> returnPaths(String p,int r, int c,int n){//p:path
        if(r==n-1 && c==n-1){
           ArrayList<String> list = new ArrayList<>();
           list.add(p);
           return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(c<n-1){
            list.addAll(returnPaths(p+'R',r,c+1,n));
        }
        if(r<n-1){
            list.addAll(returnPaths(p+'D',r+1,c,n));
        }
        return list;
    }
    // Maze with Diagonal path allowed
    // Given an n x n maze(2D matrix) count no. of paths to reach from (0,0) to (n-1,n-1)
    // You are allowed to go Right(R) by inc. col by 1 or Down(D) by inc. row by 1 or Diagonally(d) by inc. both row and col by 1
    static void printPaths2(String p,int n,int r,int c){//Diagonal path included
         if(r==n-1 && c==n-1){
            System.out.println(p);
            return;
        }
        if(r>n-1 || c>n-1){
            return;
        }
        printPaths2(p+'d',n,r+1,c+1);
        printPaths2(p+'R',n,r,c+1);
        printPaths2(p+'D',n,r+1,c);
    }
    static ArrayList<String> returnPaths2(String p,int r, int c,int n){//p:path
        if(r==n-1 && c==n-1){
           ArrayList<String> list = new ArrayList<>();
           list.add(p);
           return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(c<n-1 && r<n-1){
            list.addAll(returnPaths2(p+'d',r+1, c+1,n));
        }
        if(c<n-1){
            list.addAll(returnPaths2(p+'R',r,c+1,n));
        }
        if(r<n-1){
            list.addAll(returnPaths2(p+'D',r+1,c,n));
        }
        return list;
    }
    // Maze with obstacles
    static void printPaths_Obstacles(boolean[][]boards,String p,int r,int c){//Diagonal path included
        if(r==boards.length-1 && c==boards[0].length-1){
            System.out.println(p);
            return;
        }
        // out-of-bounds checking if must always come before the obstacle checking if because if the bounds is not checked and the value of r and c is greater than the length of boards array then we might get an ArrayIndexOutOfBoundsException(a runtime error)
        if(r>boards.length-1 || c>boards[0].length-1){//out-of-bounds checking if
            return;
        }
        if(!boards[r][c]){//obstacle checking if
            return;
        }
        printPaths_Obstacles(boards,p+'d',r+1,c+1);
        printPaths_Obstacles(boards,p+'R',r,c+1);
        printPaths_Obstacles(boards,p+'D',r+1,c);
    }
    
}
