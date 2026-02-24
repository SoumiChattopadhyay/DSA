public class Prog40_Best_Time_to_Buy_and_Sell_Stocks_IV_Way_1 {
    // Recursion
    static int funct(int ind, int buy, int cap, int[] prices,int n, int k){
        // Base Cases
        if(cap==0 || ind==n) return 0;

        //can buy case
        if(buy==1){
            return Math.max(-prices[ind]+funct(ind+1, 0, cap, prices, n, k),//buy
                                0 + funct(ind+1, 1, cap, prices, n, k));//dont buy
        }
        // cannot buy or can sell case
        return Math.max(prices[ind]+funct(ind+1, 1, cap-1, prices, n, k),//sell
                            0 + funct(ind+1, 0, cap, prices, n, k));//dont sell
    }
    // Memoization
    static int funct2(int ind, int buy, int cap, int[][][] dp, int[] prices,int n, int k){
        // Base Cases
        if(cap==0 || ind==n) return 0;
        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];

        //can buy case
        if(buy==1){
            return dp[ind][buy][cap] = Math.max(-prices[ind]+funct2(ind+1, 0, cap, dp, prices, n, k),//buy
                                0 + funct2(ind+1, 1, cap, dp, prices, n, k));//dont buy
        }
        // cannot buy or can sell case
        return dp[ind][buy][cap] = Math.max(prices[ind]+funct2(ind+1, 1, cap-1, dp, prices, n, k),//sell
                                0 + funct2(ind+1, 0, cap, dp, prices, n, k));//dont sell
    }
    // Tabulation
    static int funct3(int[][][] dp, int[] prices,int n, int k){
        // Base Cases
        for(int ind=0;ind<n;ind++)
            for(int buy=0;buy<2;buy++)
                dp[ind][buy][0]=0;
        for(int buy=0;buy<2;buy++)
            for(int cap=0;cap<=k;cap++)
                dp[n][buy][cap]=0;


        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    //can buy case
                    if(buy==1){
                        dp[ind][buy][cap] = Math.max(-prices[ind]+dp[ind+1][0][cap],//buy
                                            0 + dp[ind+1][1][cap]);//dont buy
                    }
                    // cannot buy or can sell case
                    else{
                        dp[ind][buy][cap] = Math.max(prices[ind]+dp[ind+1][1][cap-1],//sell
                                            0 + dp[ind+1][0][cap]);//dont sell
                    }
                }
            }
        }
        return dp[0][1][k];
    }
    // Space Optimization taken from prev problem Way 1
    static int funct4(int[] prices, int n, int k){
        int[][] after = new int[2][k+1];
        int[][] curr = new int[2][k+1];
        // Base Cases
        for(int buy=0;buy<2;buy++)
            for(int cap=0;cap<k+1;cap++)
                after[buy][cap]=0;

        for(int ind=n-1;ind>=0;ind--){
            curr = new int[2][k+1];
            for(int buy=0;buy<=1;buy++){
                curr[buy][0]=0;//Base case(not necessary)
                for(int cap=1;cap<=k;cap++){
                    //can buy case
                    if(buy==1){
                        curr[buy][cap] = Math.max(-prices[ind]+after[0][cap],//buy
                                            0 + after[1][cap]);//dont buy
                    }
                    // cannot buy or can sell case
                    else{
                        curr[buy][cap] = Math.max(prices[ind]+after[1][cap-1],//sell
                                            0 + after[0][cap]);//dont sell
                    }
                }
            }
            after=curr;
        }
        return after[1][k];
    }
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int n=prices.length;
        int k=2;
        System.out.println(funct(0,1,k,prices, n, k)); 

        int[][][] dp = new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int c=0;c<=k;c++){
                    dp[i][j][c]=-1;
                }
            }
        }
        System.out.println(funct2(0,1, k, dp, prices, n, k));
        
        dp = new int[n+1][2][k+1];
        System.out.println(funct3(dp, prices, n, k)); 

        System.out.println(funct4(prices, n, k)); 
    }
}
