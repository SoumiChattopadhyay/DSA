public class Prog40_Best_Time_to_Buy_and_Sell_Stocks_IV_Way_2{
   // Recursion 
    static int funct(int ind, int transNo, int[] prices,int n, int k){
        // Base Cases
        if(transNo==k*2 || ind==n) return 0;

        //can buy case
        if(transNo%2==0){
            return Math.max(-prices[ind]+funct(ind+1, transNo+1, prices, n, k),//buy
                                0 + funct(ind+1, transNo, prices, n, k));//dont buy
        }
        // cannot buy or can sell case
        return Math.max(prices[ind]+funct(ind+1, transNo+1, prices, n, k),//sell
                            0 + funct(ind+1, transNo, prices, n, k));//dont sell
    }

    // Memoization 
    static int funct2(int ind, int transNo,int[][] dp, int[] prices,int n, int k){
        // Base Cases
        if(transNo==k*2 || ind==n) return 0;
        if(dp[ind][transNo]!=-1) return dp[ind][transNo];

        //can buy case
        if(transNo%2==0){
            return dp[ind][transNo]=Math.max(-prices[ind]+funct2(ind+1, transNo+1, dp, prices, n, k),//buy
                                                0 + funct2(ind+1, transNo, dp, prices, n, k));//dont buy
        }
        // cannot buy or can sell case
        return dp[ind][transNo]=Math.max(prices[ind]+funct2(ind+1, transNo+1, dp, prices, n, k),//sell
                                            0 + funct2(ind+1, transNo, dp, prices, n, k));//dont sell
    }
    // Tabulation 
    static int funct3(int[][] dp, int[] prices,int n, int k){
        // Base Cases
        for(int ind=0;ind<n;ind++) dp[ind][k*2]=0;
        for(int transNo=0;transNo<k*2;transNo++) dp[n][transNo]=0;

        for(int ind=n-1;ind>=0;ind--){
            for(int transNo=0;transNo<=k*2-1;transNo++){
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
    static int funct4(int[] prices,int n, int k){
        int[] after = new int[k*2+1];
        int[] curr = new int[k*2+1];
        // Base Cases
        for(int transNo=0;transNo<k*2;transNo++) after[transNo]=0;

        for(int ind=n-1;ind>=0;ind--){
            curr=new int[k*2+1];
            curr[k*2]=0;//Base case(not necessary as Arrays default to 0)
            for(int transNo=0;transNo<=k*2-1;transNo++){
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
        int[] prices = {3,2,6,5,0,3};
        int n=prices.length;
        int k=2;
        System.out.println(funct(0, 0, prices, n, k));

        int[][] dp = new int[n][k*2];
        for(int i=0;i<n;i++){
            for(int t=0;t<k*2;t++){
                dp[i][t]=-1;
            }
        }
        System.out.println(funct2(0, 0, dp, prices, n, k));

        dp = new int[n+1][k*2+1];
        System.out.println(funct3(dp, prices, n, k));


        System.out.println(funct4(prices, n, k));
    }
}
