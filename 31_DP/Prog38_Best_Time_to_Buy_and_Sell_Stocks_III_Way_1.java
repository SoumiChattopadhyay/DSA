public class Prog38_Best_Time_to_Buy_and_Sell_Stocks_III_Way_1{
    // Recursion
    static int funct(int ind, int buy, int cap, int[] prices,int n){
        // Base Cases
        if(cap==0 || ind==n) return 0;

        //can buy case
        if(buy==1){
            return Math.max(-prices[ind]+funct(ind+1, 0, cap, prices, n),//buy
                                0 + funct(ind+1, 1, cap, prices, n));//dont buy
        }
        // cannot buy or can sell case
        return Math.max(prices[ind]+funct(ind+1, 1, cap-1, prices, n),//sell
                            0 + funct(ind+1, 0, cap, prices, n));//dont sell
    }
    // Memoization
    static int funct2(int ind, int buy, int cap, int[][][] dp, int[] prices,int n){
        // Base Cases
        if(cap==0 || ind==n) return 0;
        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];

        //can buy case
        if(buy==1){
            return dp[ind][buy][cap] = Math.max(-prices[ind]+funct2(ind+1, 0, cap, dp, prices, n),//buy
                                0 + funct2(ind+1, 1, cap, dp, prices, n));//dont buy
        }
        // cannot buy or can sell case
        return dp[ind][buy][cap] = Math.max(prices[ind]+funct2(ind+1, 1, cap-1, dp, prices, n),//sell
                                0 + funct2(ind+1, 0, cap, dp, prices, n));//dont sell
    }
    // Tabulation
    static int funct3(int[][][] dp, int[] prices,int n){
        // Base Cases
        for(int ind=0;ind<n;ind++)
            for(int buy=0;buy<2;buy++)
                dp[ind][buy][0]=0;
        for(int buy=0;buy<2;buy++)
            for(int cap=0;cap<3;cap++)
                dp[n][buy][cap]=0;


        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
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
        return dp[0][1][2];
    }
    // Space Optimization
    static int funct4(int[] prices, int n){
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];
        // Base Cases
        for(int buy=0;buy<2;buy++)
            for(int cap=0;cap<3;cap++)
                after[buy][cap]=0;

        for(int ind=n-1;ind>=0;ind--){
            curr = new int[2][3];
            for(int buy=0;buy<=1;buy++){
                curr[buy][0]=0;//Base case(not necessary)
                for(int cap=1;cap<=2;cap++){
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
        return after[1][2];
    }
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int n=prices.length;
        System.out.println(funct(0, 1, 2, prices, n));

        int[][][] dp = new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;//initialize to -1 for memoization
                }
            }
        }
        System.out.println(funct2(0, 1, 2, dp, prices, n));

        dp = new int[n+1][2][3];//reinitialize to 0 for tabulation
        System.out.println(funct3(dp, prices, n));

        System.out.println(funct4(prices, n));

    }
}
