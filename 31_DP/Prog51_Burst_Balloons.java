public class Prog51_Burst_Balloons {
    // Recursion
    static int funct1(int i, int j, int[] arr, int n){
        // Base Case
        if(i>j) return 0;

        int maxi=-(int)1e9;
        for(int ind=i;ind<=j;ind++){
            int cost = arr[i-1]*arr[ind]*arr[j+1]
                        + funct1(i, ind-1, arr, n)
                        + funct1(ind+1, j, arr, n);
            maxi = Math.max(maxi, cost);
        }
        
        return maxi;
    }
    static int helper1(int[] arr, int n){
        int[] newArr = new int[n+2];
        newArr[0]=1;
        newArr[n+1]=1;
        for(int i=0;i<n;i++)
            newArr[i+1]=arr[i];
        return funct1(1, n, newArr, n);
    }

    // Memoization
    static int funct2(int i, int j, int[][] dp, int[] arr, int n){
        // Base Cases
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int maxi=-(int)1e9;
        for(int ind=i;ind<=j;ind++){
            int cost = arr[i-1]*arr[ind]*arr[j+1]
                        + funct2(i, ind-1, dp, arr, n)
                        + funct2(ind+1, j, dp, arr, n);
            maxi = Math.max(maxi, cost);
        }
        
        return dp[i][j]=maxi;
    }
    static int helper2(int[] arr, int n){
        int[] newArr = new int[n+2];
        newArr[0]=1;
        newArr[n+1]=1;
        for(int i=0;i<n;i++)
            newArr[i+1]=arr[i];

        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return funct2(1, n, dp, newArr, n);
    }

    static int funct3(int[][] dp, int[] arr, int n){
        // Base Case (Not needed if u initialize dp with 0s)
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i>j) 
                    dp[i][j]=0;
            }
        }

        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                int maxi=-(int)1e9;
                for(int ind=i;ind<=j;ind++){
                    int cost = arr[i-1]*arr[ind]*arr[j+1]
                                + dp[i][ind-1]
                                + dp[ind+1][j];
                    maxi = Math.max(maxi, cost);
                }
                
                dp[i][j]=maxi;
            }
        }
        
        return dp[1][n];       
    }
    static int helper3(int[] arr, int n){
        int[] newArr = new int[n+2];
        newArr[0]=1;
        newArr[n+1]=1;
        for(int i=0;i<n;i++)
            newArr[i+1]=arr[i];

        int[][] dp = new int[n+2][n+2];
        
        return funct3(dp, newArr, n);
    }
    public static void main(String[] args) {
        int[] arr = {3,1,5,8};
        int n = arr.length;
        System.out.println(helper1(arr, n));
        System.out.println(helper2(arr, n));
        System.out.println(helper3(arr, n));
    }
}
