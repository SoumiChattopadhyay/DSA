public class Prog39_Best_Time_to_Buy_and_Sell_Stocks_III_Way_2 {
    // Recursion
    static int funct(int ind, int transNo, int[] prices,int n){
        // Base Cases
        if(transNo==4 || ind==n) return 0;

        //can buy case
        if(transNo%2==0){
            return Math.max(-prices[ind]+funct(ind+1, transNo+1, prices, n),//buy
                                0 + funct(ind+1, transNo, prices, n));//dont buy
        }
        // cannot buy or can sell case
        return Math.max(prices[ind]+funct(ind+1, transNo+1, prices, n),//sell
                            0 + funct(ind+1, transNo, prices, n));//dont sell
    }
    // Memoization
    static int funct2(int ind, int transNo,int[][] dp, int[] prices,int n){
        // Base Cases
        if(transNo==4 || ind==n) return 0;
        if(dp[ind][transNo]!=-1) return dp[ind][transNo];

        //can buy case
        if(transNo%2==0){
            return dp[ind][transNo]=Math.max(-prices[ind]+funct2(ind+1, transNo+1, dp, prices, n),//buy
                                                0 + funct2(ind+1, transNo, dp, prices, n));//dont buy
        }
        // cannot buy or can sell case
        return dp[ind][transNo]=Math.max(prices[ind]+funct2(ind+1, transNo+1, dp, prices, n),//sell
                                            0 + funct2(ind+1, transNo, dp, prices, n));//dont sell
    }
    // Tabulation
    static int funct3(int[][] dp, int[] prices,int n){
        // Base Cases
        for(int ind=0;ind<n;ind++) dp[ind][4]=0;
        for(int transNo=0;transNo<4;transNo++) dp[n][transNo]=0;

        for(int ind=n-1;ind>=0;ind--){
            for(int transNo=0;transNo<=3;transNo++){
                //can buy case
                if(transNo%2==0){
                    dp[ind][transNo]=Math.max(-prices[ind]+dp[ind+1][transNo+1],//buy
                                                        0 + dp[ind+1][transNo]);//dont buy
                }
                // cannot buy or can sell case
                else{
                    dp[ind][transNo]=Math.max(prices[ind]+dp[ind+1][transNo+1],//sell
                                                    0 + dp[ind+1][transNo]);//dont sell
                }
            }
        }
        return dp[0][0];
    }

    // Space Optimization
    static int funct4(int[] prices,int n){
        int[] after = new int[5];
        int[] curr = new int[5];
        // Base Cases
        for(int transNo=0;transNo<4;transNo++) after[transNo]=0;

        for(int ind=n-1;ind>=0;ind--){
            curr=new int[5];
            curr[4]=0;//Base case(not necessary as Arrays default to 0)
            for(int transNo=0;transNo<=3;transNo++){
                //can buy case
                if(transNo%2==0){
                    curr[transNo]=Math.max(-prices[ind]+after[transNo+1],//buy
                                                        0 + after[transNo]);//dont buy
                }
                // cannot buy or can sell case
                else{
                    curr[transNo]=Math.max(prices[ind]+after[transNo+1],//sell
                                                    0 + after[transNo]);//dont sell
                }
            }
            after=curr;
        }
        return after[0];
    }
    
     public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int n=prices.length;
        System.out.println(funct(0, 0, prices, n));

        int[][] dp = new int[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=-1;//initialize to -1 for memoization
            }
        }
        System.out.println(funct2(0, 0, dp, prices, n));

        dp = new int[n+1][5];//reinitialize to 0 for tabulation
        System.out.println(funct3(dp, prices, n));

        System.out.println(funct4(prices, n));

    }
}
