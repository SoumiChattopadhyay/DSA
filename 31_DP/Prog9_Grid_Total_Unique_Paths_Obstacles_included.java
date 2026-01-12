public class Prog9_Grid_Total_Unique_Paths_Obstacles_included {
    static int mod = (int)(1e9)+7;
    // Recursion
    static int funct(int i,int j, int[][] maze){
        //Base cases
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(i>=0 && j>=0 && maze[i][j]==-1) return 0;

        int up = funct(i-1,j,maze);
        int left = funct(i,j-1,maze);
        return (up+left)%mod;
    }
    // Memoization
    static int funct2(int i,int j,int[][] dp, int[][] maze){
        //Base cases
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(i>=0 && j>=0 && maze[i][j]==-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int up = funct2(i-1,j,dp,maze);
        int left = funct2(i,j-1,dp,maze);
        return dp[i][j]=(up+left)%mod;
    }
    // Tabulation
    static int funct3(int m,int n,int[][] dp, int[][] maze){
        dp[0][0]=1;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(maze[i][j]==-1) dp[i][j]=0;
                else if(i==0 && j==0) dp[0][0]=1;
                else{
                    int up=0,left=0;
                    if(i>0)
                        up=dp[i-1][j];
                    if(j>0)
                        left=dp[i][j-1];
                    dp[i][j]=(up+left)%mod;
                }
            }
        }
        return dp[m][n];
    }
    //Space Optimization
    static int funct4(int m,int n,int[][] maze){
        int[] prevRow = new int[n+1];
        for(int i=0;i<=m;i++){
            int[] temp=new int[n+1];
            for(int j=0;j<=n;j++){
                if(maze[i][j]==-1) temp[j]=0;
                else if(i==0 && j==0) temp[j]=1;
                else{
                    int up=0,left=0;
                    if(i>0)
                        up=prevRow[j];
                    if(j>0)
                        left=temp[j-1];
                    temp[j]=(up+left)%mod;
                }
            }
            prevRow=temp;
        }
        return prevRow[n];
    }
    public static void main(String[] args) {
        int m=3,n=3;
        int[][] maze = {
            {0,0,0},
            {0,-1,0},
            {0,0,0}
        };
        System.out.println(funct(m-1,n-1,maze));
        
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(m-1, n-1, dp,maze));
        System.out.println(funct3(m-1, n-1, dp,maze));
        System.out.println(funct4(m-1, n-1,maze));
    }
}
