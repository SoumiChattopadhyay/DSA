public class Prog12_Maximum_Falling_Path_Sum {
    static int funct(int i, int j, int[][] a){
        // Base Cases
        if(j<0 || j>a[0].length-1) return -(int)1e9;//boundary crossing case(j<0 or j>m)
        if(i==0) return a[0][j];//destination case
        
        int leftDiag=a[i][j]+funct(i-1,j-1,a);
        int up=a[i][j]+funct(i-1,j,a);
        int rightDiag=a[i][j]+funct(i-1,j+1,a);

        return Math.max(up,Math.max(leftDiag, rightDiag));
    }
    // Memoization
    static int funct2(int i, int j, int[][] a, int[][] dp){
        // Base Cases
        if(j<0 || j>a.length-1) return -(int)1e9;//boundary crossing case(j<0 or j>m)
        if(i==0) return a[0][j];//destination case
        if(dp[i][j]!=-1) return dp[i][j];
        
        int leftDiag=a[i][j]+funct2(i-1,j-1,a,dp);
        int up=a[i][j]+funct2(i-1,j,a,dp);
        int rightDiag=a[i][j]+funct2(i-1,j+1,a,dp);

        return dp[i][j]=Math.max(up,Math.max(leftDiag, rightDiag));
    }
    // Tabulation
    static int funct3(int n, int m,int[][] a,int[][] dp){
        // Base Case
        for(int j=0;j<m;j++){
            dp[0][j]=a[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=0,leftDiag=0,rightDiag=0;
                if(j>0)
                    leftDiag = a[i][j]+dp[i-1][j-1];
                up = a[i][j]+dp[i-1][j];
                if(j<m-1)
                    rightDiag = a[i][j]+dp[i-1][j+1];
                dp[i][j]=Math.max(up,Math.max(leftDiag,rightDiag));
            }
        }
        int max=dp[n-1][0];
        for(int j=1;j<m;j++){
            max=Math.max(max,dp[n-1][j]);
        }
        return max;
    }
    // Space Optimization
    static int funct4(int n, int m, int[][] a){
         // Base Case
        int[] prevRow = new int[m];
        for(int j=0;j<m;j++){
            prevRow[j]=a[0][j];
        }
        for(int i=1;i<n;i++){
            int[] currRow = new int[m];
            for(int j=0;j<m;j++){
                int up=0,leftDiag=0,rightDiag=0;
                if(j>0)
                    leftDiag = a[i][j]+prevRow[j-1];
                up = a[i][j]+prevRow[j];
                if(j<m-1)
                    rightDiag = a[i][j]+prevRow[j+1];
                currRow[j]=Math.max(up,Math.max(leftDiag,rightDiag));
            }
            prevRow=currRow;
        }
        int max=prevRow[0];
        for(int j=1;j<m;j++){
            max=Math.max(max,prevRow[j]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,100},
            {2,2,3},
            {3,10,2},
        };
        int n=matrix.length;
        int m=matrix[0].length;
        
        // Recursion
        int max=0;
        for(int j=0;j<m;j++){
            max=Math.max(max,funct(n-1,j,matrix));
        }
        System.out.println(max);

        // Memoization
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        max=0;
        for(int j=0;j<m;j++){
            max=Math.max(max,funct2(n-1,j,matrix,dp));
        }
        System.out.println(max);

        // Tabulation
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct3(n,m,matrix,dp));
        System.out.println(funct4(n,m,matrix));
    }
}
