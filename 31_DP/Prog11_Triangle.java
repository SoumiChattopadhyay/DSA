public class Prog11_Triangle {
    static int funct(int i, int j, int[][] a){
        // Base case
        if(i==a.length-1) return a[i][j];

        int d = a[i][j] + funct(i+1,j,a);
        int dg = a[i][j] + funct(i+1,j+1,a);
        
        return Math.min(d,dg);
    }
    // Memoization
    static int funct2(int i, int j, int[][] a, int[][] dp){
        // Base case
        if(i==a.length-1) return a[i][j];
        if(dp[i][j]!=-1) return dp[i][j];

        int d = a[i][j] + funct(i+1,j,a);
        int dg = a[i][j] + funct(i+1,j+1,a);
        
        return dp[i][j] = Math.min(d,dg);
    }
    // Tabulation
    static int funct3(int n, int[][] a, int[][] dp){
        // 4 Base Cases
        for(int j=0;j<n;j++){
            dp[n-1][j]=a[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d = a[i][j]+dp[i+1][j];
                int dg = a[i][j]+dp[i+1][j+1];
                dp[i][j]=Math.min(d,dg);
            }
        }
        return dp[0][0];
    }
     // Space Optimization
    static int funct4(int n, int[][] a){
        // 4 Base Cases
        int[] nextRow = new int[n];
        for(int j=0;j<n;j++){
            nextRow[j]=a[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            int[] currRow = new int[i+1];//for row i we need i+1 elements
            for(int j=i;j>=0;j--){
                int d = a[i][j]+nextRow[j];
                int dg = a[i][j]+nextRow[j+1];
                currRow[j]=Math.min(d,dg);
            }
            nextRow=currRow;
        }
        return nextRow[0];
    }
    public static void main(String[] args) {
        int[][] arr = {
            {1},
            {2,3},
            {3,6,7},
            {8,9,6,10}
        };
        int n=arr.length;
        System.out.println(funct(0,0,arr));

         int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(0,0,arr,dp));
        System.out.println(funct3(n,arr,dp));
        System.out.println(funct4(n,arr));
    }
}
