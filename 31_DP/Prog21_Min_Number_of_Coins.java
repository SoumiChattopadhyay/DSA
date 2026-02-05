public class Prog21_Min_Number_of_Coins {
    // Recursion
    static int funct(int ind, int tar, int[] arr){
        // Base Case
        if(ind==0){
            if(arr[0]==tar) return 1;
            if(tar%arr[0]==0) return tar/arr[0];//the first check isnt compulsory it will be checked here then
            else return (int)1e9;
            //instead of these 3 lines you can also write just this : return (tar%arr[ind]==0)?(tar/arr[ind]):0;
        }
        int nottake = 0 + funct(ind-1, tar, arr);
        int take = Integer.MAX_VALUE;
        if(arr[ind]<=tar){
            take = 1 + funct(ind,tar-arr[ind],arr);
        }
        return Math.min(take,nottake);
    }
    // Memoization
    static int funct2(int ind, int tar, int[] arr,int[][] dp){
        // Base Case
        if(ind==0){
            if(arr[0]==tar) return 1;//the first check isnt compulsory it will be checked here then
            if(tar%arr[0]==0) return tar/arr[0];
            else return (int)1e9;
        }
        if(dp[ind][tar]!=-1) return dp[ind][tar];

        int nottake = 0 + funct2(ind-1, tar, arr,dp);
        int take = Integer.MAX_VALUE;
        if(arr[ind]<=tar){
            take = 1 + funct2(ind,tar-arr[ind],arr,dp);
        }
        return dp[ind][tar]=Math.min(take,nottake);
    }
    // Tabulation
    static int funct3(int N, int targetPrice, int[] arr,int[][] dp){
        // Base Case
        dp[0][arr[0]]=1;//not compulsory would be evaluated in loop anyway
        for(int t=0;t<=targetPrice;t++){
            if(t%arr[0]==0) dp[0][t]=t/arr[0];
            else dp[0][t]=(int)1e9;
        }
        
        for(int ind=1;ind<N;ind++){
            for(int tar=0;tar<=targetPrice;tar++){
                int nottake = 0 + dp[ind-1][tar];
                int take = Integer.MAX_VALUE;
                if(arr[ind]<=tar){
                    take = 1 + dp[ind][tar-arr[ind]];
                }
                dp[ind][tar] = Math.min(nottake, take);
            }
        }
        return dp[N-1][targetPrice];
    }
    // Space Optimization
    static int funct4(int N, int targetPrice, int[] arr){
        // Base Case
        int[] prevRow = new int[targetPrice+1];
        prevRow[arr[0]]=1;//not compulsory would be evaluated in loop anyway
         for(int t=0;t<=targetPrice;t++){
            if(t%arr[0]==0) prevRow[t]=t/arr[0];
            else prevRow[t]=(int)1e9;
        }
        
        for(int ind=1;ind<N;ind++){
            int[] currRow = new int[targetPrice+1];
            for(int tar=0;tar<=targetPrice;tar++){
                int nottake = 0 + prevRow[tar];
                int take = Integer.MAX_VALUE;
                if(arr[ind]<=tar){
                    take = 1 + currRow[tar-arr[ind]];
                }
                currRow[tar] = Math.min(nottake, take);
            }
            prevRow=currRow;
        }
        return prevRow[targetPrice];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int targetPrice = 7;
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
