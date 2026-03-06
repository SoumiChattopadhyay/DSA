public class Prog49_MCM{
    // Recursion
    static int funct1(int i, int j, int[] arr, int N){
        // Base Case
        if(i==j) return 0;

        int mini=(int)1e9;
        for(int k=i;k<=j-1;k++){
            int steps = arr[i-1]*arr[k]*arr[j]
                        + funct1(i, k, arr, mini)
                        + funct1(k+1, j, arr, mini);
            if(steps<mini) mini=steps;
        }

        return mini;
    }
    // Memoization
    static int funct2(int i, int j, int[][] dp, int[] arr, int N){
        // Base Cases
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int mini=(int)1e9;
        for(int k=i;k<=j-1;k++){
            int steps = arr[i-1]*arr[k]*arr[j]
                        + funct2(i, k, dp, arr, mini)
                        + funct2(k+1, j, dp, arr, mini);
            if(steps<mini) mini=steps;
        }

        return dp[i][j]=mini;
    }
    // Tabulation
    static int funct3(int[][] dp, int[] arr, int N){
        // Base Case
        for(int i=1;i<N;i++)
           dp[i][i]=0;

        for(int i=N-1;i>=1;i--){
            for(int j=i+1;j<=N-1;j++){
                int mini=(int)1e9;
                for(int k=i;k<=j-1;k++){
                    int steps = arr[i-1]*arr[k]*arr[j]
                                + dp[i][k]
                                + dp[k+1][j];
                    if(steps<mini) mini=steps;
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][N-1];
    }
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int N=arr.length;

        System.out.println(funct1(1, N-1, arr, N));

        int[][] dp = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(1, N-1, dp, arr, N));

        dp = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct3(dp, arr, N));

    }
}