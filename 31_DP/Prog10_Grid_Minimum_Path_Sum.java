public class Prog10_Grid_Minimum_Path_Sum {
    // Recursion
    static int funct(int i, int j, int[][] a){
        // Base Cases
        if(i==0 && j==0) return a[0][0];
        if(i<0 || j<0) return (int)1e9;

        int up = a[i][j]+funct(i-1,j,a);
        int left = a[i][j]+funct(i,j-1,a);
        return Math.min(up,left);
    }
    // Memoization
    static int funct2(int i, int j, int[][] a, int[][] dp){
        // Base Cases
        if(i==0 && j==0) return a[0][0];
        if(i<0 || j<0) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];

        int up = a[i][j]+funct(i-1,j,a);
        int left = a[i][j]+funct(i,j-1,a);
        return dp[i][j]=Math.min(up,left);
    }
    // Tabulation
    static int funct3(int n, int m, int[][] a, int[][] dp){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0)dp[i][j]=a[i][j];
                else{
                    int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;//dont initialize up and left with 0 as 0 might win the Math.min, producing wrong minimum sums
                    if(i>0)
                        up=a[i][j]+dp[i-1][j];
                    if(j>0)
                        left=a[i][j]+dp[i][j-1];
                    dp[i][j]=Math.min(up,left);
                    //you can also initialise up=a[i][j],left=a[i][j] and later do 
                    // if(i>0) up+=dp[i-1][j] //consider the path
                    // else up=(int)1e9 //dont consider the path because of i=0 and j=1(say) then there is no up so that path is invalid
                    // if(j>0) left+=dp[i][j-1] //consider the path
                    // else left=(int)1e9 //dont consider the path because of j=0 and i=1(say) then there is no left so that path is invalid
                }
            }
        }
        return dp[n-1][m-1];
    }
    // Space Optimization
    static int funct4(int n, int m, int[][] a){
        int[] prevRow = new int[m];
        for(int i=0;i<n;i++){
            int[] currRow = new int[m+1];
            for(int j=0;j<m;j++){
                if(i==0 && j==0) currRow[j]=a[i][j];
                else{
                    int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;//dont initialize up and left with 0 as 0 might win the Math.min, producing wrong minimum sums
                    if(i>0)
                        up=a[i][j]+prevRow[j];//requiring previous row's j col
                    if(j>0)
                        left=a[i][j]+currRow[j-1];//requiring current row's j-1 col
                    currRow[j]=Math.min(up,left);
                }
            }
            prevRow=currRow;
        }
        return prevRow[m-1];
    }
    public static void main(String[] args) {
        int n=2,m=3;
        int[][] grid = {
            {5,9,6},
            {11,5,2},
        };
        System.out.println(funct(n-1,m-1,grid));
        
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(n-1,m-1,grid,dp));
        System.out.println(funct3(n,m,grid,dp));
        System.out.println(funct4(n,m,grid));

    }
}
