public class Prog37_Best_Time_to_Buy_and_Sell_Stocks_II {
    // Recursion
    static int funct(int ind,int buy,int[] prices, int n){
        // Base case
        if(ind==n) return 0;   

        int profit=0;
        // can buy 
        if(buy==1){
            profit = Math.max(-prices[ind] + funct(ind+1, 0, prices, n),// buy 
                                0 + funct(ind+1, 1, prices, n));// not buy
        }
        // cannot buy
        else{
            profit = Math.max(prices[ind] + funct(ind+1, 1, prices, n),// sell 
                                0 + funct(ind+1, 0, prices, n));// not sell
        }
        return profit;
    }
    // Memoization
    static int funct2(int ind,int buy, int[][] dp, int[] prices, int n){
        // Base case
        if(ind==n) return 0; 
        if(dp[ind][buy]!=-1) return dp[ind][buy];  

        int profit=0;
        // can buy 
        if(buy==1){
            profit = Math.max(-prices[ind] + funct2(ind+1, 0, dp, prices, n),// buy 
                                0 + funct2(ind+1, 1, dp, prices, n));// not buy
        }
        // cannot buy
        else{
            profit = Math.max(prices[ind] + funct2(ind+1, 1, dp, prices, n),// sell 
                                0 + funct2(ind+1, 0, dp, prices, n));// not sell
        }
        return dp[ind][buy]=profit;
    }
    // Tabulation
    static int funct3(int[][] dp, int[] prices, int n){
        // Base case
        dp[n][0]=0;
        dp[n][1]=0;

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                // can buy 
                if(buy==1){
                    profit = Math.max(-prices[ind] + dp[ind+1][0],// buy 
                                        0 + dp[ind+1][1]);// not buy
                }
                // cannot buy
                else{
                    profit = Math.max(prices[ind] + dp[ind+1][1],// sell 
                                        0 + dp[ind+1][0]);// not sell
                }
                dp[ind][buy]=profit;
            }
        }
        return dp[0][1];        
    }
    // Way 1
    // Space Optimization (Using 2 arrays of size 2)
    static int funct4(int[] prices, int n){
        int[] ahead = new int[2];
        int[] curr = new int[2];

        for(int ind=n-1;ind>=0;ind--){
            curr=new int[2];
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                // can buy 
                if(buy==1){
                    profit = Math.max(-prices[ind] + ahead[0],// buy 
                                        0 + ahead[1]);// not buy
                }
                // cannot buy
                else{
                    profit = Math.max(prices[ind] + ahead[1],// sell 
                                        0 + ahead[0]);// not sell
                }
                curr[buy]=profit;
            }
            ahead=curr;
        }
        return ahead[1];        
    }
    // Way 2
    // Space Optimization (Using 4 variables)
    static int funct5(int[] prices, int n){
        int aheadNotBuy,aheadBuy,currNotBuy,currBuy;

        // Base Case
        aheadNotBuy=aheadBuy=0;

        for(int ind=n-1;ind>=0;ind--){
     
            // cannot buy
            currNotBuy = Math.max(prices[ind] + aheadBuy, // sell 
                                0 + aheadNotBuy);// not sell 
        
            // can buy 
            currBuy = Math.max(-prices[ind] + aheadNotBuy, // buy
                                0 + aheadBuy); // not buy
            
            aheadBuy=currBuy;
            aheadNotBuy=currNotBuy;
        }
        return aheadBuy;        
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int n=6;
        System.out.println(funct(0,1,prices, n));

        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(0,1,dp,prices, n));

        dp = new int[n+1][2];
        System.out.println(funct3(dp,prices, n));

        System.out.println(funct4(prices, n));

        System.out.println(funct5(prices, n));
    }
}
