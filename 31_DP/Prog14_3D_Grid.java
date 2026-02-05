// import java.util.Arrays;

public class Prog14_3D_Grid {
    static int maxChocos(int i,int j1,int j2,int[][] a){
        int n=a.length;
        int m=a[0].length;
        // Base Cases
        // Out of bounds case : always write this first
        if(j1<0 || j1>=m || j2<0 ||j2>=m){
            return (int)-1e8;
        }
        // Destination Case
        if(i==n-1){
            if(j1==j2) return a[i][j1];//if they reach same pos count it once
            else return a[i][j1]+a[i][j2];//if they reach 2 diff positions count both
        }
        // explore all paths of alice and bob simultaneously
        int maxi=(int)-1e8;
        for(int dj1=-1;dj1<=+1;dj1++){
            for(int dj2=-1;dj2<=+1;dj2++){
                if(j1==j2){ 
                    maxi = Math.max(maxi,a[i][j1]+maxChocos(i+1,j1+dj1,j2+dj2,a));
                }else{
                    maxi = Math.max(maxi,a[i][j1]+a[i][j2]+maxChocos(i+1,j1+dj1,j2+dj2,a));
                }
            }
        }
        return maxi;//takes max of all the states
    }
    
    // Memoization
    // ṬC=O(n*m*m), SC=O(n*m*m)+O(n)
    static int maxChocos2(int i, int j1, int j2, int[][][] dp, int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        // Base Cases
        // Out of bounds case : always write this first
        if(j1<0 || j1>=m || j2<0 ||j2>=m){
            return (int)-1e8;
        }
        // Destination Case
        if(i==n-1){
            if(j1==j2) return grid[i][j1];//if they reach same pos count it once
            else return grid[i][j1]+grid[i][j2];//if they reach 2 diff positions count both
        }
        // Re-evaluation prevention case //put this after both the cases otherwise u will get out of bounds error. j1,j2 boundary checked by out of bounds case and i boundary checked by destination case
        if(dp[i][j1][j2]!=-1){
            System.out.println("Prevented re-evaluation of f("+i+","+j1+","+j2+")");
            return dp[i][j1][j2];
        }
        // explore all paths of alice and bob simultaneously
        int maxi=(int)-1e8;
        for(int dj1=-1;dj1<=+1;dj1++){
            for(int dj2=-1;dj2<=+1;dj2++){
                int value=0;
                if(j1==j2) value=grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += maxChocos2(i+1, j1+dj1, j2+dj2, dp, grid);
                maxi = Math.max(maxi,value);
            }
        }
        return  dp[i][j1][j2]=maxi;//takes max of all the states
    }
    // Tabulation
    static int maxChocos3(int n, int m, int[][][] dp, int[][] grid){
        // Base Cases
        // Destination Case
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }
        // Explore all paths of Alice and Bob simultaneously
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi=(int)-1e8;
                    for(int dj1=-1;dj1<=+1;dj1++){
                        for(int dj2=-1;dj2<=+1;dj2++){
                            int value=0;
                            if(j1==j2) value=grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if(j1+dj1>=0 && j1+dj1<m && j2+dj2>=0 && j2+dj2<m)
                                value += dp[i+1][j1+dj1][j2+dj2];
                            else
                                value += (int)-1e8;
                            maxi = Math.max(maxi,value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
    // Space Optimization
    static int maxChocos4(int n, int m, int[][] grid){
        int[][] frontRow = new int[m][m];
        int[][] currRow = new int[m][m];
        // Base Cases
        // Destination Case
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) frontRow[j1][j2] = grid[n-1][j1];
                else frontRow[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }
        // Explore all paths of Alice and Bob simultaneously
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi=(int)-1e8;
                    for(int dj1=-1;dj1<=+1;dj1++){
                        for(int dj2=-1;dj2<=+1;dj2++){
                            int value=0;
                            if(j1==j2) value=grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if(j1+dj1>=0 && j1+dj1<m && j2+dj2>=0 && j2+dj2<m)
                                value += frontRow[j1+dj1][j2+dj2];
                            else
                                value += (int)-1e8;
                            maxi = Math.max(maxi,value);
                        }
                    }
                    currRow[j1][j2] = maxi;
                }
            }
            frontRow=currRow;
            currRow = new int[m][m];
        }
        return frontRow[0][m-1];
    }
    public static void main(String[] args) {
        // int[][] grid = {
        //     {2,3,1,2},
        //     {3,4,2,2},
        //     {5,6,3,5}
        // };
        int[][] grid = {
            {2,3,2},
            {3,4,2},
            {5,6,3}
        };
        int n=grid.length;
        int m=grid[0].length;
        System.out.println("Recursion solution:");
        System.out.println(maxChocos(0, 0, m-1, grid)+"\n");
        
        int[][][] dp = new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        System.out.println("Memoization solution:");
        System.out.println(maxChocos2(0, 0, m-1, dp, grid));
        // System.out.println("Printing the dp array:");
        // int c=0;
        // for(int[][] arr_2d:dp){
        //     System.out.println("Layer "+ c++);
        //     for(int[] arr:arr_2d){
        //         System.out.println(Arrays.toString(arr));
        //     }
        // }

        // Resetting dp array to -1 for tabulation
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        System.out.println("\nTabulation solution:");
        System.out.println(maxChocos3(n, m, dp, grid));
        // System.out.println("Printing the dp array:");
        // c=0;
        // for(int[][] arr_2d:dp){
        //     System.out.println("Layer "+ c++);
        //     for(int[] arr:arr_2d){
        //         System.out.println(Arrays.toString(arr));
        //     }
        // }
        System.out.println("\nSpace Optimization solution:");
        System.out.println(maxChocos4(n, m, grid));
    }
}