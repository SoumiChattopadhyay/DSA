public class Prog23_Number_of_ways_to_make_Coin_Change {
    // Recursion
    static int funct(int ind, int tar, int[] arr){
        // Base Case
        if(ind==0){
            return (tar%arr[ind]==0)?1:0;
        }
        int nottake = funct(ind-1, tar, arr);
        int take = 0;
        if(arr[ind]<=tar){
            take = funct(ind,tar-arr[ind],arr);
        }
        return take+nottake;
    }
    // Memoization
    static int funct2(int ind, int tar, int[] arr,int[][] dp){
        // Base Case
        if(ind==0){
            return (tar%arr[ind]==0)?1:0;
        }
        if(dp[ind][tar]!=-1) return dp[ind][tar];

        int nottake = funct2(ind-1, tar, arr,dp);
        int take = 0;
        if(arr[ind]<=tar){
            take = funct2(ind,tar-arr[ind],arr,dp);
        }
        return dp[ind][tar]=take+nottake;
    }
    // Tabulation
    static int funct3(int N, int targetPrice, int[] arr,int[][] dp){
        // Base Case
        for(int t=0;t<=targetPrice;t++){
            dp[0][t]=(t%arr[0]==0)?1:0;
        }
        
        for(int ind=1;ind<N;ind++){
            for(int tar=0;tar<=targetPrice;tar++){
                int nottake = dp[ind-1][tar];
                int take = 0;
                if(arr[ind]<=tar){
                    take = dp[ind][tar-arr[ind]];
                }
                dp[ind][tar] = nottake+take;
            }
        }
        return dp[N-1][targetPrice];
    }
    // Space Optimization
    static int funct4(int N, int targetPrice, int[] arr){
        // Base Case
        int[] prevRow = new int[targetPrice+1];
         for(int t=0;t<=targetPrice;t++){
            prevRow[t]=(t%arr[0]==0)?1:0;
        }
        
        for(int ind=1;ind<N;ind++){
            int[] currRow = new int[targetPrice+1];
            for(int tar=0;tar<=targetPrice;tar++){
                int nottake = prevRow[tar];
                int take = 0;
                if(arr[ind]<=tar){
                    take = currRow[tar-arr[ind]];
                }
                currRow[tar] = nottake+take;
            }
            prevRow=currRow;
        }
        return prevRow[targetPrice];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int targetPrice = 4;
        int N=coins.length;
        System.out.println(funct(N-1,targetPrice,coins));

        int[][] dp = new int[N][targetPrice+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<=targetPrice;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(N-1, targetPrice, coins, dp));

        dp=new int[N][targetPrice+1];
        System.out.println(funct3(N, targetPrice, coins, dp));

        System.out.println(funct4(N, targetPrice, coins));
    }
}
