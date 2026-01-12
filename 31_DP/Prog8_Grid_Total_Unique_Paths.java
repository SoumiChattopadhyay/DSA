public class Prog8_Grid_Total_Unique_Paths {
    // Watch this video for best answer :   
    // https://www.youtube.com/results?search_query=grid+unique+paths+striver
    // Recursion
    static int funct(int i,int j){
        // Base Cases
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        int up = funct(i-1,j);
        int left = funct(i,j-1);

        return up+left;
    }
    // Memoization
    static int funct2(int i,int j,int[][] dp){
        // Base Cases
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int up = funct2(i-1,j,dp);
        int left = funct2(i,j-1,dp);

        return dp[i][j]=up+left;
    }
     // Tabulation
    static int funct3(int m,int n,int[][] dp){
        // Step1 : Declare base case
        dp[0][0]=1;
        // Step 2 : Express all states in for loops
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0) dp[0][0]=1;
                else{
                    // Step 3 : Copy the recurrence and write it
                    int up=0, left=0;
                    if(i>0)
                        up = dp[i-1][j];
                    if(j>0)
                        left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m][n];
    }
    // Space Optimization
    static int funct4(int m,int n){
        int[] prevRow = new int[n+1];
        for(int i=0;i<=m;i++){
            int[] temp=new int[n+1];
            for(int j=0;j<=n;j++){
                if(i==0 && j==0) temp[j]=1;
                else{
                    int up=0,left=0;
                    if(i>0)
                        up=prevRow[j];
                    if(j>0)
                        left=temp[j-1];
                    temp[j]=up+left;
                }
            }
            prevRow=temp;
        }
        return prevRow[n];
    }
    public static void main(String[] args) {
        int m=3,n=3;
        System.out.println(funct(m-1,n-1));
        
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(m-1, n-1, dp));
        System.out.println(funct3(m-1, n-1, dp));
        System.out.println(funct4(m-1, n-1));
    }
}
