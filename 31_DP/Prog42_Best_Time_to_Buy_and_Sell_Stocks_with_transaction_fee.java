public class Prog42_Best_Time_to_Buy_and_Sell_Stocks_with_transaction_fee {
    // Recursion
    static int funct1(int ind, int buy, int[] prices, int n, int fee){
        // Base Case
        if(ind==n) return 0;

        // can buy 
        if(buy==1){
            return Math.max(-prices[ind]+funct1(ind+1, 0, prices, n, fee),
                            0 + funct1(ind+1, 1, prices, n, fee));
        }
        // can sell
        return Math.max(prices[ind]-fee + funct1(ind+1, 1, prices, n, fee),
                        0 + funct1(ind+1, 0, prices, n, fee));
    }
    // Memoization
    static int funct2(int ind, int buy,int[][] dp, int[] prices, int n, int fee){
        // Base Case
        if(ind==n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];

        // can buy 
        if(buy==1){
            return dp[ind][buy] = Math.max(-prices[ind]+funct2(ind+1, 0, dp, prices, n, fee),
                            0 + funct2(ind+1, 1, dp, prices, n, fee));
        }
        // can sell
        return dp[ind][buy] = Math.max(prices[ind]-fee + funct2(ind+1, 1, dp, prices, n, fee),
                        0 + funct2(ind+1, 0, dp, prices, n, fee));
    }
    // Tabulation 
    static int funct3(int[][] dp, int[] prices, int n, int fee){
        // Base Case
            dp[n][0]=dp[n][1]=0;

        for(int ind=n-1;ind>=0;ind--){
            // can buy 
            dp[ind][1] = Math.max(-prices[ind]+dp[ind+1][0],
                                0 + dp[ind+1][1]);

            // can sell
            dp[ind][0] = Math.max(prices[ind]-fee+dp[ind+1][1],
                            0 + dp[ind+1][0]);
        }
        return dp[0][1];
    }
    
    // Space Optimization 
     static int funct4(int[] prices, int n, int fee){
        int[] after = new int[2];
        int[] curr = new int[2];
        // Base Case
        for(int buy=0;buy<=1;buy++) 
            after[buy]=0;

        for(int ind=n-1;ind>=0;ind--){
            curr=new int[2];
            // can buy 
                curr[1] = Math.max(-prices[ind]+after[0],
                                0 + after[1]);
            // can sell
                curr[0] = Math.max(prices[ind]-fee+after[1],
                            0 + after[0]);
            after=curr;
        }
        return after[1];
    }

     // Space Optimization (Using 4 variables)
     static int funct4_2(int[] prices, int n, int fee){
        int afterNotBuy, afterBuy, currNotBuy, currBuy;
        // Base Case
        afterNotBuy=afterBuy=0;

        for(int ind=n-1;ind>=0;ind--){
            // can buy 
            currBuy = Math.max(-prices[ind]+afterNotBuy,
                            0 + afterBuy);
            // can sell
            currNotBuy = Math.max(prices[ind]-fee+afterBuy,
                        0 + afterNotBuy);
            
            afterBuy=currBuy;
            afterNotBuy=currNotBuy;
        }
        return afterBuy;
    }
    public static void main(String[] args) {
        int[] prices={1,3,2,8,4,9};
        int fee=2;
        int n=prices.length;
        System.out.println(funct1(0, 1, prices, n, fee));

        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<=1;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(0, 1, dp, prices, n, fee));

        dp=new int[n+1][2];
        System.out.println(funct3(dp, prices, n, fee));

        System.out.println(funct4(prices, n, fee));

        System.out.println(funct4_2(prices, n, fee));
        
    }
}
