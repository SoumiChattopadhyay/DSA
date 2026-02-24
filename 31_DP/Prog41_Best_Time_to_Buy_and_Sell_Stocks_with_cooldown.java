public class Prog41_Best_Time_to_Buy_and_Sell_Stocks_with_cooldown {// cooldown means cant buy right after the day you sell
    // Recursion
    static int funct1(int ind, int buy, int[] prices, int n){
        // Base Case
        if(ind>=n) return 0;

        // can buy 
        if(buy==1){
            return Math.max(-prices[ind]+funct1(ind+1, 0, prices, n),
                            0 + funct1(ind+1, 1, prices, n));
        }
        // can sell
        return Math.max(prices[ind]+funct1(ind+2, 1, prices, n),
                        0 + funct1(ind+1, 0, prices, n));
    }
    // Memoization
    static int funct2(int ind, int buy,int[][] dp, int[] prices, int n){
        // Base Case
        if(ind>=n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];

        // can buy 
        if(buy==1){
            return dp[ind][buy] = Math.max(-prices[ind]+funct2(ind+1, 0, dp, prices, n),
                            0 + funct2(ind+1, 1, dp, prices, n));
        }
        // can sell
        return dp[ind][buy] = Math.max(prices[ind]+funct2(ind+2, 1, dp, prices, n),
                        0 + funct2(ind+1, 0, dp, prices, n));
    }
    // Tabulation
    static int funct3(int[][] dp, int[] prices, int n){
        // Base Case
        for(int buy=0;buy<=1;buy++) 
            dp[n][buy]=dp[n+1][buy]=dp[n+2][buy]=0;

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                // can buy 
                if(buy==1){
                    dp[ind][buy] = Math.max(-prices[ind]+dp[ind+1][0],
                                    0 + dp[ind+1][1]);
                }
                // can sell
                else{
                    dp[ind][buy] = Math.max(prices[ind]+dp[ind+2][1],
                                0 + dp[ind+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    // Tabulation (removing buy loop)
    static int funct3_2(int[][] dp, int[] prices, int n){
        // Base Case
        for(int buy=0;buy<=1;buy++) 
            dp[n][buy]=dp[n+1][buy]=dp[n+2][buy]=0;

        for(int ind=n-1;ind>=0;ind--){
            // can buy 
            dp[ind][1] = Math.max(-prices[ind]+dp[ind+1][0],
                                0 + dp[ind+1][1]);

            // can sell
            dp[ind][0] = Math.max(prices[ind]+dp[ind+2][1],
                            0 + dp[ind+1][0]);
        }
        return dp[0][1];
    }
    // Space Optimization
     static int funct4(int[] prices, int n){
        int[] after = new int[2];
        int[] after2 = new int[2];
        int[] curr = new int[2];
        // Base Case
        for(int buy=0;buy<=1;buy++) 
            after[buy]=after2[buy]=0;

        for(int ind=n-1;ind>=0;ind--){
            curr=new int[2];
            for(int buy=0;buy<=1;buy++){
                // can buy 
                if(buy==1){
                    curr[buy] = Math.max(-prices[ind]+after[0],
                                    0 + after[1]);
                }
                // can sell
                else{
                    curr[buy] = Math.max(prices[ind]+after2[1],
                                0 + after[0]);
                }
            }
            after2=after;
            after=curr;
        }
        return after[1];
    }
    // Space Optimization (removing buy loop)
     static int funct4_2(int[] prices, int n){
        int[] after = new int[2];
        int[] after2 = new int[2];
        int[] curr = new int[2];
        // Base Case
        for(int buy=0;buy<=1;buy++) 
            after[buy]=after2[buy]=0;

        for(int ind=n-1;ind>=0;ind--){
            curr=new int[2];
            // can buy 
                curr[1] = Math.max(-prices[ind]+after[0],
                                0 + after[1]);
            // can sell
                curr[0] = Math.max(prices[ind]+after2[1],
                            0 + after[0]);
            after2=after;
            after=curr;
        }
        return after[1];
    }
    public static void main(String[] args) {
        int[] prices={4,9,0,4,10};
        int n=prices.length;
        System.out.println(funct1(0, 1, prices, n));

        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<=1;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(0, 1, dp, prices, n));

        dp=new int[n+3][2];
        System.out.println(funct3(dp, prices, n));

        dp=new int[n+3][2];
        System.out.println(funct3_2(dp, prices, n));

        System.out.println(funct4(prices, n));
        
        System.out.println(funct4_2(prices, n));

    }
}
